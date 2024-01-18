package org.advent.dayeleven;

import java.util.List;

public class Row {

    private List<Position> positions;

    private long rowNumber;

    private final long width;

    public Row(long width) {
        this.width = width;
    }

    public long getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(long rowNumber) {
        this.rowNumber = rowNumber;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public long getWidth() {
        return width;
    }
}
