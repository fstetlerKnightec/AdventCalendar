package org.advent.dayeleven;

import java.util.List;

public class Column {

    private List<Position> positions;

    private int width;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
