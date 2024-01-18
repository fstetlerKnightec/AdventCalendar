package org.advent.dayeleven;

import java.util.ArrayList;
import java.util.List;

public class Space {

    public List<Row> rows = new ArrayList<>();
    public List<Column> columns = new ArrayList<>();

    public void makeRows(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            int width = getWidthOfRow(strings.get(i));
            Row row = new Row(width);
            List<Position> positions = loopStringAndCreatePositions(strings, i);
            row.setPositions(positions);
            row.setRowNumber(positions.getFirst().getCoordinate().getY());
            rows.add(row);
        }
    }

    public void makeColumnsFromExistingRows() {
        for (int i = 0; i < rows.getFirst().getPositions().size(); i++) {
            Column column = new Column();
            column.setPositions(loopRowsAndCreateColumnsWithPositions(i));
            column.setWidth(getWidthFromColumn(column));
//            System.out.println("first = " + column.getPositions().getFirst().getCoordinate().getX());
            column.setColumnNumber(column.getPositions().getFirst().getCoordinate().getX());
//            System.out.println("columnNumber = " + column.getColumnNumber());
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

//        System.out.println(startColumn.getColumnNumber());

        int numberOfXStepsBetweenPos = Math.abs(pos1.getCoordinate().getX() - pos2.getCoordinate().getX());

//        System.out.println(numberOfXStepsBetweenPos);
        Column updatedColumn = startColumn;
        int countedSteps = 0;
        int startX = startColumn.getPositions().getFirst().getCoordinate().getX();
//        System.out.println("size = " + columns.size());
        for (int i = startX; i < startX + numberOfXStepsBetweenPos; i++) {
            countedSteps += updatedColumn.getWidth();

//            System.out.println(updatedColumn.getColumnNumber());
//            System.out.println("char = " + updatedColumn.getPositions().getFirst().getCharacter());

            int finalI = i;
            updatedColumn = columns.stream().filter(c -> c.getColumnNumber() == finalI + 1).findFirst().orElseThrow();
        }
        System.out.println("X = " + countedSteps);
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
        System.out.println("Y = " + countedSteps);

        return countedSteps;
    }


    public int getWidthFromColumn(Column column) {
        return column.getPositions().stream().anyMatch(pos -> pos.getCharacter() == '#') ? 1 : 2;

    }

    public List<Position> loopRowsAndCreateColumnsWithPositions(int i) {
        List<Position> positions = new ArrayList<>();

        for (int j = 0; j < rows.size(); j++) {
//            System.out.println("rows = " + rows.get(j).getRowNumber());
            positions.add(rows.get(j).getPositions().get(i));
        }
        return positions;

//        return rows.stream().map(row -> row.getPositions().getFirst().getCoordinate().getX() == i).collect(Collectors.toList());
    }

    public List<Position> loopStringAndCreatePositions(List<String> strings, int i) {
        List<Position> positions = new ArrayList<>();
        for (int j = 0; j < strings.size(); j++) {
            Position position = new Position(new Coordinate(j, i), strings.get(i).charAt(j));
            positions.add(position);
        }
        return positions;
        //        return strings.stream().map(s -> new Position(new Coordinate(
//                strings.indexOf(s), i), strings.get(i).charAt(strings.indexOf(s)))).collect(Collectors.toList());
    }

    public int getWidthOfRow(String currentString) {
        return currentString.contains("#") ? 1 : 2;
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


    //        Row row1 = rows.stream().filter(r -> r.getPositions().contains(pos1)).findFirst().orElseThrow();
//        Column column1 = columns.stream().filter(c -> c.getPositions().contains(pos1)).findFirst().orElseThrow();
//
//        Row row2 = rows.stream().filter(r -> r.getPositions().contains(pos2)).findFirst().orElseThrow();
//        Column column2 = columns.stream().filter(c -> c.getPositions().contains(pos2)).findFirst().orElseThrow();
//
//        int column1XPos = column1.getPositions().getFirst().getCoordinate().getX();
//        int column2XPos = column2.getPositions().getFirst().getCoordinate().getX();
//        int row1YPos = row1.getPositions().getFirst().getCoordinate().getY();
//        int row2YPos = row2.getPositions().getFirst().getCoordinate().getY();
//
//        int startXPos = Math.max(column1XPos, column2XPos);
//        int startYPos = Math.max(row1YPos, row2YPos);
//
//        int xStepsBetweenPos = Math.abs(column1XPos - column2XPos);
//        int yStepsBetweenPos = Math.abs(row1YPos - row2YPos);
//
//
//
//        int countXSteps = 0;
//        for (int i = 0; i < xStepsBetweenPos; i++) {
//
//        }
//
//
//        System.out.println(xStepsBetweenPos);
//        System.out.println(yStepsBetweenPos);
}
