package org.advent.dayeleven;

import java.util.List;

public class Row {

    private List<Position> positions;

    private final int width;

    public Row(int width) {
        this.width = width;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public int getWidth() {
        return width;
    }
}
