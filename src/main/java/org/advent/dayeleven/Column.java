package org.advent.dayeleven;

import java.util.List;

public class Column {

    private List<Position> positions;

    private long columnNumber;

    private long width;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public long getWidth() {
        return width;
    }

    public long getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(long columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
