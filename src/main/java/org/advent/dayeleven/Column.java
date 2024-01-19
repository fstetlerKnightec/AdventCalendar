package org.advent.dayeleven;

import java.util.List;

public class Column {

    private final List<Position> positions;

    private final int width;

    public Column(List<Position> positions, int width) {
        this.positions = positions;
        this.width = width;
    }

    private int getWidthFromColumn(int widthExpander) {
        return positions.stream().anyMatch(pos -> pos.getCharacter() == '#') ? 1 : widthExpander;
    }

    public int getWidth() {
        return getWidthFromColumn(width);
    }

    public List<Position> getPositions() {
        return positions;
    }

    public int getColumnNumber() {
        return positions.getFirst().getCoordinate().getX();
    }
}
