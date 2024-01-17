package org.advent.dayeleven;

import java.util.ArrayList;
import java.util.List;

public class Space {

    public List<Row> rows = new ArrayList<>();
    public List<Column> columns = new ArrayList<>();

    public void makeRows(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            Row row = new Row();
            List<Position> positions = new ArrayList<>();
            for (int j = 0; j < strings.get(i).length(); j++) {
                Position position = new Position();
                position.setCoordinate(new Coordinate(j, i));
                position.setCharacter(strings.get(i).charAt(j));
                position.setGalaxy(position.getCharacter() == '#');
                positions.add(position);
            }
            row.setPositions(positions);
            rows.add(row);
        }
    }

    public void makeColumnsFromExistingRows() {
        for (int i = 0; i < rows.getFirst().getPositions().size(); i++) {
            Column column = new Column();
            List<Position> positions = new ArrayList<>();
            for (int j = 0; j < rows.getFirst().getPositions().size(); j++) {
                positions.add(rows.get(j).getPositions().get(i));
            }
            column.setPositions(positions);
            columns.add(column);
        }
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
