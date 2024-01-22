package org.advent.dayeleven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Space {

    public List<Row> rows;
    public List<Column> columns;

    public Space(List<Row> rows, List<Column> columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public long minimumXStepsBetweenTwoCoordinates(Position pos1, Position pos2) {
        // left for later, try to combine with the other minimumYSteps
        Column startColumn;
        if (pos1.coordinate().getX() > pos2.coordinate().getX()) {
            startColumn = columns.stream().filter(c -> c.positions().contains(pos2)).findAny().orElseThrow();
        } else {
            startColumn = columns.stream().filter(c -> c.positions().contains(pos1)).findAny().orElseThrow();
        }

        int numberOfXStepsBetweenPos = Math.abs(pos1.coordinate().getX() - pos2.coordinate().getX());

        Column updatedColumn = startColumn;
        int countedSteps = 0;
        int startX = startColumn.positions().getFirst().coordinate().getX();
        for (int i = startX; i < startX + numberOfXStepsBetweenPos; i++) {
            countedSteps += updatedColumn.getWidth();
            int finalI = i;
            updatedColumn = columns.stream().filter(c -> c.getColumnNumber() == finalI + 1).findFirst().orElseThrow();
        }
        return countedSteps;
    }

    public long minimumYStepsBetweenTwoCoordinates(Position pos1, Position pos2) {
        // left for later
        Row startRow;
        if (pos1.coordinate().getY() > pos2.coordinate().getY()) {
            startRow = rows.stream().filter(c -> c.positions().contains(pos2)).findAny().orElseThrow();
        } else {
            startRow = rows.stream().filter(c -> c.positions().contains(pos1)).findAny().orElseThrow();
        }

        int numberOfYStepsBetweenPos = Math.abs(pos1.coordinate().getY() - pos2.coordinate().getY());

        Row updatedRow = startRow;
        int countedSteps = 0;
        int startY = startRow.positions().getFirst().coordinate().getY();
        for (int i = startY; i < startY + numberOfYStepsBetweenPos; i++) {
            countedSteps += updatedRow.getWidth();
            int finalI = i;
            updatedRow = rows.stream().filter(r -> r.getRowNumber() == finalI + 1).findFirst().orElseThrow();
        }
        return countedSteps;
    }

    public List<Position> galaxyPositions() {
        return rows.stream().flatMap(row ->
                row.positions().stream()).filter(Position::isGalaxy).collect(Collectors.toList());
    }

    public long loopPositionsAndFindSum(List<Position> positions) {
        long steps;
        long sumOfSteps = 0;
        Set<Position> usedPosition = new HashSet<>();
        for (Position startPosition : positions) {
            for (Position toPosition : positions) {
                if (!toPosition.equals(startPosition) && !usedPosition.contains(toPosition)) {
                    steps = (minimumXStepsBetweenTwoCoordinates(startPosition, toPosition) + minimumYStepsBetweenTwoCoordinates(startPosition, toPosition));
                    sumOfSteps += steps;
                }
                usedPosition.add(startPosition);
            }
        }
        return sumOfSteps;
    }

    public List<Row> getRows() {
        return rows;
    }

    public List<Column> getColumns() {
        return columns;
    }
}
