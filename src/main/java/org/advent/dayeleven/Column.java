package org.advent.dayeleven;

import java.util.List;

public class Column {

    private final List<Position> positions;
    private int columnNumber;
    private int width;

    public Column(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    private int getWidthFromColumn(int widthExpander) {
        return getPositions().stream().anyMatch(pos -> pos.getCharacter() == '#') ? 1 : widthExpander;
    }

    public int getWidth() {
        return width;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setWidth(int width) {
        this.width = getWidthFromColumn(width); // IS THIS ALLOWED
    }
}
