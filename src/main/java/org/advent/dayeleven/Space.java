package org.advent.dayeleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Space{

    public List<Row> rows = new ArrayList<>();
    public List<Column> columns = new ArrayList<>();

    public void makeRows(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            int widthOfRow = strings.get(i).contains("#") ? 1 : 2;
            Row row = new Row(widthOfRow);
            List<Position> positions = new ArrayList<>();
            for (int j = 0; j < strings.get(i).length(); j++) {
                Position position = new Position(new Coordinate(j, i), strings.get(i).charAt(j));
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
            int width = column.getPositions().stream().anyMatch(pos -> pos.getCharacter() == '#') ? 1: 2;
            column.setWidth(width);
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


    //    public int expandSpaceBesideEmptyRow(List<String> strings) {
//        for (int i = 0; i < strings.size(); i++) {
//            if (!strings.get(i).contains("#")) {
////                System.out.println(strings.size());
//                String dots = ".".repeat(strings.get(i).length());
////                System.out.println(dots);
//////                strings.set(i, ".".repeat(strings.get(i).length()));
//////                System.out.println(strings.get(i));
//                strings.add(i, dots);
//                i = i + 1;
//////                System.out.println(dots);
//            }
//        }
//
////      Gör ett viktsystem istället för att sätta in punkterna i listan, räkna de tomma spacet som 2, och sen när du går
////      från punkt a till b så räknar du dubbelt steg om fältet i raden är en "dubbel", dvs 2 bredd
//
//        for (int i = 0; i < strings.size(); i++) {
//            System.out.println(strings.get(i));
//        }
//
//        return 1;
//
//    }
}
