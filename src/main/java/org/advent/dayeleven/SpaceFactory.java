package org.advent.dayeleven;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpaceFactory {

    public Space spaceCreator(List<String> strings, int widthExpander) {
        Space space = new Space();
        List<Row> rows = makeRows(strings, widthExpander);
        List<Column> columns = makeColumnsFromExistingRows(rows, widthExpander);
        space.setRows(rows);
        space.setColumns(columns);
        return space;
    }

    public List<Row> makeRows(List<String> strings, int widthExpander) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            List<Position> positions = loopStringAndCreatePositions(strings, i);
            Row row = new Row(
                    positions,
                    getWidthOfRow(strings.get(i), widthExpander),
                    positions.getFirst().getCoordinate().getY());
            rows.add(row);
        }
        return rows;
    }

    public List<Column> makeColumnsFromExistingRows(List<Row> rows, int widthExpander) {
        List<Column> columns = new ArrayList<>();
        for (int i = 0; i < rows.getFirst().positions().size(); i++) {
            Column column = new Column(
                    loopRowsAndCreateColumnsWithPositions(rows, i));
            column.setWidth(getWidthFromColumn(column, widthExpander));
            column.setColumnNumber(column.getPositions().getFirst().getCoordinate().getX());
            columns.add(column);
        }
        return columns;
    }

    private int getWidthFromColumn(Column column, int widthExpander) {
        return column.getPositions().stream().anyMatch(pos -> pos.getCharacter() == '#') ? 1 : widthExpander;
    }

    private List<Position> loopStringAndCreatePositions(List<String> strings, int i) {
        List<Position> positions = new ArrayList<>();
        for (int j = 0; j < strings.size(); j++) {
            Position position = new Position(new Coordinate(j, i), strings.get(i).charAt(j));
            position.setGalaxy(position.getCharacter() == '#');
            positions.add(position);
        }
        return positions;
    }

    private List<Position> loopRowsAndCreateColumnsWithPositions(List<Row> rows, int i) {
        return rows.stream().map(row -> row.positions().get(i)).collect(Collectors.toList());
    }

    private int getWidthOfRow(String currentString, int widthExpander) {
        return currentString.contains("#") ? 1 : widthExpander;
    }

}
