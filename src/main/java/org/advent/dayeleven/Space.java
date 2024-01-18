package org.advent.dayeleven;

import java.util.ArrayList;
import java.util.List;

public class Space {

    public List<Row> rows = new ArrayList<>();
    public List<Column> columns = new ArrayList<>();

    public void makeRows(List<String> strings, long widthExpander) {
        for (int i = 0; i < strings.size(); i++) {
            long width = getWidthOfRow(strings.get(i), widthExpander);
            Row row = new Row(width);
            List<Position> positions = loopStringAndCreatePositions(strings, i);
            row.setPositions(positions);
            row.setRowNumber(positions.getFirst().getCoordinate().getY());
            rows.add(row);
        }
    }

    public void makeColumnsFromExistingRows(long widthExpander) {
        for (long i = 0; i < rows.getFirst().getPositions().size(); i++) {
            Column column = new Column();
            column.setPositions(loopRowsAndCreateColumnsWithPositions(i));
            column.setWidth(getWidthFromColumn(column, widthExpander));
            column.setColumnNumber(column.getPositions().getFirst().getCoordinate().getX());
            columns.add(column);
        }
    }

    public long minimumXStepsBetweenTwoCoordinates(Position pos1, Position pos2) {

        Column startColumn;
        if (pos1.getCoordinate().getX() > pos2.getCoordinate().getX()) {
            startColumn = columns.stream().filter(c -> c.getPositions().contains(pos2)).findAny().orElseThrow();
        } else {
            startColumn = columns.stream().filter(c -> c.getPositions().contains(pos1)).findAny().orElseThrow();;
        }

        long numberOfXStepsBetweenPos = Math.abs(pos1.getCoordinate().getX() - pos2.getCoordinate().getX());

        Column updatedColumn = startColumn;
        long countedSteps = 0;
        long startX = startColumn.getPositions().getFirst().getCoordinate().getX();
        for (long i = startX; i < startX + numberOfXStepsBetweenPos; i++) {
            countedSteps += updatedColumn.getWidth();


            long finalI = i;
            updatedColumn = columns.stream().filter(c -> c.getColumnNumber() == finalI + 1).findFirst().orElseThrow();
        }
        return countedSteps;
    }

    public long minimumYStepsBetweenTwoCoordinates(Position pos1, Position pos2) {

        Row startRow;
        if (pos1.getCoordinate().getY() > pos2.getCoordinate().getY()) {
            startRow = rows.stream().filter(c -> c.getPositions().contains(pos2)).findAny().orElseThrow();
        } else {
            startRow = rows.stream().filter(c -> c.getPositions().contains(pos1)).findAny().orElseThrow();;
        }

        long numberOfYStepsBetweenPos = Math.abs(pos1.getCoordinate().getY() - pos2.getCoordinate().getY());

        Row updatedRow = startRow;
        long countedSteps = 0;
        long startY = startRow.getPositions().getFirst().getCoordinate().getY();
        for (long i = startY; i < startY + numberOfYStepsBetweenPos; i++) {
            countedSteps += updatedRow.getWidth();

            long finalI = i;
            updatedRow = rows.stream().filter(r -> r.getRowNumber() == finalI + 1).findFirst().orElseThrow();
        }
        return countedSteps;
    }


    public long getWidthFromColumn(Column column, long widthExpander) {
        return column.getPositions().stream().anyMatch(pos -> pos.getCharacter() == '#') ? 1 : widthExpander;

    }

    public List<Position> loopRowsAndCreateColumnsWithPositions(long i) {
        List<Position> positions = new ArrayList<>();
        for (Row row : rows) {
            positions.add(row.getPositions().get((int) i));
        }
        return positions;
    }

    public List<Position> loopStringAndCreatePositions(List<String> strings, long i) {
        List<Position> positions = new ArrayList<>();
        for (long j = 0; j < strings.size(); j++) {
            Position position = new Position(new Coordinate((int) j, (int) i), strings.get((int) i).charAt((int) j));
            position.setGalaxy(position.getCharacter() == '#');
            positions.add(position);
        }
        return positions;
    }

    public List<Position> galaxyPositions() {
        List<Position> galaxyPositions = new ArrayList<>();
        for (long i = 0; i < rows.size(); i++) {
            for (long j = 0; j < rows.get((int) i).getPositions().size(); j++) {
                if (rows.get((int) i).getPositions().get((int) j).isGalaxy()) {
                    galaxyPositions.add(rows.get((int) i).getPositions().get((int) j));
                }
            }
        }
        return galaxyPositions;
    }

    public long getWidthOfRow(String currentString, long widthExpander) {
        return currentString.contains("#") ? 1 : widthExpander;
    }

    public long loopPositionsAndFindSum(List<Position> positions) {
        long steps;
        long sumOfSteps = 0;
        List<Position> usedPosition = new ArrayList<>();
        for (long i = 0; i < positions.size(); i++) {
            Position basePosition = positions.get((int) i);
            for (long j = 0; j < positions.size(); j++) {
                Position toPosition = positions.get((int) j);
                if (!toPosition.equals(basePosition) && !usedPosition.contains(toPosition)) {
                    steps = (minimumXStepsBetweenTwoCoordinates(basePosition, toPosition) + minimumYStepsBetweenTwoCoordinates(basePosition, toPosition));
                    sumOfSteps += steps;
                }
            }
            usedPosition.add(basePosition);
        }

        return sumOfSteps;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
