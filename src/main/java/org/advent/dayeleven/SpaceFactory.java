package org.advent.dayeleven;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpaceFactory {

    public Space spaceCreator(List<String> strings, int widthExpander) {
        List<RowCol> rows = makeRows(strings, widthExpander);
        List<RowCol> columns = makeColumnsFromExistingRows(rows, widthExpander);
        return new Space(rows, columns);
    }

    public List<RowCol> makeRows(List<String> strings, int widthExpander) {
        List<RowCol> rows = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            Row row = new Row(
                    loopStringAndCreatePositions(strings, i),
                    getWidthOfRow(strings.get(i), widthExpander));
            rows.add(row);
        }
        return rows;
    }

    public List<RowCol> makeColumnsFromExistingRows(List<RowCol> rows, int widthExpander) {
        List<RowCol> columns = new ArrayList<>();
        for (int i = 0; i < rows.getFirst().positions().size(); i++) {
            Column column = new Column(
                    loopRowsAndCreateColumnsWithPositions(rows, i),
                    widthExpander);
            columns.add(column);
        }
        return columns;
    }

    private List<Position> loopStringAndCreatePositions(List<String> strings, int i) {
        List<Position> positions = new ArrayList<>();
        for (int j = 0; j < strings.size(); j++) {
            char currentChar = strings.get(i).charAt(j);
            Position position = new Position(new Coordinate(j, i), currentChar);
            positions.add(position);
        }
        return positions;
    }

    private List<Position> loopRowsAndCreateColumnsWithPositions(List<RowCol> rows, int i) {
        return rows.stream().map(row -> row.positions().get(i)).collect(Collectors.toList());
    }

    private int getWidthOfRow(String currentString, int widthExpander) {
        return currentString.contains("#") ? 1 : widthExpander;
    }
}
