package org.advent.dayeleven;

import java.util.ArrayList;
import java.util.List;

public class Space {

    public List<Row> rows = new ArrayList<>();
    public List<Column> columns = new ArrayList<>();

    public void makeRows(List<String> strings, int widthExpander) {
        for (int i = 0; i < strings.size(); i++) {
            int width = getWidthOfRow(strings.get(i), widthExpander);
            Row row = new Row(width);
            List<Position> positions = loopStringAndCreatePositions(strings, i);
            row.setPositions(positions);
            row.setRowNumber(positions.getFirst().getCoordinate().getY());
            rows.add(row);
        }
    }

    public void makeColumnsFromExistingRows(int widthExpander) {
        for (int i = 0; i < rows.getFirst().getPositions().size(); i++) {
            Column column = new Column();
            column.setPositions(loopRowsAndCreateColumnsWithPositions(i));
            column.setWidth(getWidthFromColumn(column, widthExpander));
            column.setColumnNumber(column.getPositions().getFirst().getCoordinate().getX());
            columns.add(column);
        }
    }

    public int minimumXStepsBetweenTwoCoordinates(Position pos1, Position pos2) {

        Column startColumn;
        if (pos1.getCoordinate().getX() > pos2.getCoordinate().getX()) {
            startColumn = columns.stream().filter(c -> c.getPositions().contains(pos2)).findAny().orElseThrow();
        } else {
            startColumn = columns.stream().filter(c -> c.getPositions().contains(pos1)).findAny().orElseThrow();;
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

    public int minimumYStepsBetweenTwoCoordinates(Position pos1, Position pos2) {

        Row startRow;
        if (pos1.getCoordinate().getY() > pos2.getCoordinate().getY()) {
            startRow = rows.stream().filter(c -> c.getPositions().contains(pos2)).findAny().orElseThrow();
        } else {
            startRow = rows.stream().filter(c -> c.getPositions().contains(pos1)).findAny().orElseThrow();;
        }

        int numberOfYStepsBetweenPos = Math.abs(pos1.getCoordinate().getY() - pos2.getCoordinate().getY());

        Row updatedRow = startRow;
        int countedSteps = 0;
        int startY = startRow.getPositions().getFirst().getCoordinate().getY();
        for (int i = startY; i < startY + numberOfYStepsBetweenPos; i++) {
            countedSteps += updatedRow.getWidth();

            int finalI = i;
            updatedRow = rows.stream().filter(r -> r.getRowNumber() == finalI + 1).findFirst().orElseThrow();
        }
        return countedSteps;
    }


    public int getWidthFromColumn(Column column, int widthExpander) {
        return column.getPositions().stream().anyMatch(pos -> pos.getCharacter() == '#') ? 1 : widthExpander;

    }

    public List<Position> loopRowsAndCreateColumnsWithPositions(int i) {
        List<Position> positions = new ArrayList<>();
        for (Row row : rows) {
            positions.add(row.getPositions().get(i));
        }
        return positions;
    }

    public List<Position> loopStringAndCreatePositions(List<String> strings, int i) {
        List<Position> positions = new ArrayList<>();
        for (int j = 0; j < strings.size(); j++) {
            Position position = new Position(new Coordinate(j, i), strings.get(i).charAt(j));
            position.setGalaxy(position.getCharacter() == '#');
            positions.add(position);
        }
        return positions;
    }

    public List<Position> galaxyPositions() {
        List<Position> galaxyPositions = new ArrayList<>();
        for (Row row : rows) {
            for (int j = 0; j < row.getPositions().size(); j++) {
                if (row.getPositions().get(j).isGalaxy()) {
                    galaxyPositions.add(row.getPositions().get(j));
                }
            }
        }
        return galaxyPositions;
    }

    public int getWidthOfRow(String currentString, int widthExpander) {
        return currentString.contains("#") ? 1 : widthExpander;
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

    public List<Row> getRows() {
        return rows;
    }

    public List<Column> getColumns() {
        return columns;
    }
}
