package org.advent.dayeleven;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Space {

    public List<RowCol> rows;
    public List<RowCol> columns;

    public Space(List<RowCol> rows, List<RowCol> columns) {
        this.rows = rows;
        this.columns = columns;
    }

    private RowCol getStartRowCol(Position pos1, Position pos2, List<RowCol> rowColList, ToIntFunction<Position> posOp) {
        if (posOp.applyAsInt(pos1) > posOp.applyAsInt(pos2)) {
            return rowColList.stream().filter(c -> c.positions().contains(pos2)).findAny().orElseThrow();
        }
        return rowColList.stream().filter(c -> c.positions().contains(pos1)).findAny().orElseThrow();
    }

    public long minimumStepsBetweenTwoPositions(Position pos1, Position pos2, List<RowCol> rowColList, ToIntFunction<Position> posOp) {
        RowCol startRowCol = getStartRowCol(pos1, pos2, rowColList, posOp);
        int numberOfStepsBetweenPos = Math.abs(posOp.applyAsInt(pos1) - posOp.applyAsInt(pos2));
        return countedStepsBetweenPositions(startRowCol, numberOfStepsBetweenPos, rowColList);
    }

    private int countedStepsBetweenPositions(RowCol startRowCol, int numberOfStepsBetweenPos, List<RowCol> rowColList) {
        RowCol updatedColumn = startRowCol;
        int countedSteps = 0;
        int start = startRowCol.getRowColNumber();
        for (int i = start; i < start + numberOfStepsBetweenPos; i++) {
            countedSteps += updatedColumn.getWidth();
            int finalI = i;
            updatedColumn = rowColList.stream().filter(c -> c.getRowColNumber() == finalI + 1).findFirst().orElseThrow();
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
        ToIntFunction<Position> posX = p -> p.coordinate().x();
        ToIntFunction<Position> posY = p -> p.coordinate().y();

        for (Position startPosition : positions) {
            for (Position toPosition : positions) {
                if (!toPosition.equals(startPosition) && !usedPosition.contains(toPosition)) {
                    steps = (minimumStepsBetweenTwoPositions(startPosition, toPosition, columns, posX)
                            + minimumStepsBetweenTwoPositions(startPosition, toPosition, rows, posY));
                    sumOfSteps += steps;
                }
                usedPosition.add(startPosition);
            }
        }
        return sumOfSteps;
    }


    public List<RowCol> getRows() {
        return rows;
    }

    public List<RowCol> getColumns() {
        return columns;
    }
}
