package org.advent.dayeleven;

import java.util.List;

public record Column(List<Position> positions, int width) {

    private int getWidthFromColumn(int widthExpander) {
        return positions.stream().anyMatch(pos -> pos.character() == '#') ? 1 : widthExpander;
    }

    @Override
    public int width() {
        return getWidthFromColumn(width);
    }

    public int getColumnNumber() {
        return positions.getFirst().coordinate().getX();
    }
}
