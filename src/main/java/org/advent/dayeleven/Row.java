package org.advent.dayeleven;

import java.util.List;

public record Row(List<Position> positions, int width) implements RowCol {

    @Override
    public int getWidth() {
        return getWidthFromRow(width);
    }


    private int getWidthFromRow(int widthExpander) {
        return positions.stream().anyMatch(pos -> pos.character() == '#') ? 1 : widthExpander;
    }

    @Override
    public int getRowColNumber() {
        return positions.getFirst().coordinate().y();
    }
}
