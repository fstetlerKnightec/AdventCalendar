package org.advent.dayeleven;

import java.util.List;

public record Column(List<Position> positions, int width) implements RowCol{

    @Override
    public int getWidth() {
        return getWidthFromColumn(width);
    }


    private int getWidthFromColumn(int widthExpander) {
        return positions.stream().anyMatch(pos -> pos.character() == '#') ? 1 : widthExpander;
    }

    @Override
    public int getRowColNumber() {
        return positions.getFirst().coordinate().x();
    }
}
