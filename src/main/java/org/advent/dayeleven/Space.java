package org.advent.dayeleven;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Space {

    public List<Row> rows = new ArrayList<>();
    public List<Column> columns = new ArrayList<>();

    public void makeRows(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            int width = getWidthOfRow(strings.get(i));
            Row row = new Row(width);
            List<Position> positions = loopStringAndCreatePositionsAndRows(strings, i);
            row.setPositions(positions);
            rows.add(row);
        }
    }

    public void makeColumnsFromExistingRows() {
        for (int i = 0; i < rows.getFirst().getPositions().size(); i++) {
            Column column = new Column();
            column.setPositions(loopRowsAndCreateColumns(i));
            column.setWidth(getWidthFromColumn(column));
            columns.add(column);
        }
    }

    public int getWidthFromColumn(Column column) {
        return column.getPositions().stream().anyMatch(pos -> pos.getCharacter() == '#') ? 1 : 2;

    }

    public List<Position> loopRowsAndCreateColumns(int i) {
        return rows.stream().map(row -> row.getPositions().get(i)).collect(Collectors.toList());
    }

    public List<Position> loopStringAndCreatePositionsAndRows(List<String> strings, int i) {
        return strings.stream().map(s -> new Position(new Coordinate(
                strings.indexOf(s), i), strings.get(i).charAt(strings.indexOf(s)))).collect(Collectors.toList());
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
}
