package org.advent.dayeleven;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Space {

    public List<Row> rows;
    public List<Column> columns;

    public Space(List<Row> rows, List<Column> columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public long minimumXStepsBetweenTwoCoordinates(Position pos1, Position pos2) {

        Column startColumn;
        if (pos1.getCoordinate().getX() > pos2.getCoordinate().getX()) {
            startColumn = columns.stream().filter(c -> c.getPositions().contains(pos2)).findAny().orElseThrow();
        } else {
            startColumn = columns.stream().filter(c -> c.getPositions().contains(pos1)).findAny().orElseThrow();
        }

        int numberOfXStepsBetweenPos = Math.abs(pos1.getCoordinate().getX() - pos2.getCoordinate().getX());

        Column updatedColumn = startColumn;
        int countedSteps = 0;
        int startX = startColumn.getPositions().getFirst().getCoordinate().getX();
        for (int i = startX; i < startX + numberOfXStepsBetweenPos; i++) {
            countedSteps += updatedColumn.getWidth();
            int finalI = i;
            updatedColumn = columns.stream().filter(c -> c.getColumnNumber() == finalI + 1).findFirst().orElseThrow();
        }
        return countedSteps;
    }

    public long minimumYStepsBetweenTwoCoordinates(Position pos1, Position pos2) {

        Row startRow;
        if (pos1.getCoordinate().getY() > pos2.getCoordinate().getY()) {
            startRow = rows.stream().filter(c -> c.positions().contains(pos2)).findAny().orElseThrow();
        } else {
            startRow = rows.stream().filter(c -> c.positions().contains(pos1)).findAny().orElseThrow();
        }

        int numberOfYStepsBetweenPos = Math.abs(pos1.getCoordinate().getY() - pos2.getCoordinate().getY());

        Row updatedRow = startRow;
        int countedSteps = 0;
        int startY = startRow.positions().getFirst().getCoordinate().getY();
        for (int i = startY; i < startY + numberOfYStepsBetweenPos; i++) {
            countedSteps += updatedRow.width();

            int finalI = i;
            updatedRow = rows.stream().filter(r -> r.rowNumber() == finalI + 1).findFirst().orElseThrow();
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
        List<Position> usedPosition = new ArrayList<>();
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

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Row> getRows() {
        return rows;
    }

    public List<Column> getColumns() {
        return columns;
    }
}
