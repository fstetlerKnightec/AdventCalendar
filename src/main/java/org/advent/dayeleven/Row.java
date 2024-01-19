package org.advent.dayeleven;

import java.util.List;

public record Row(List<Position> positions, int width) {

    public int getWidth() {
        return getWidthFromRow(width);
    }

    public int getRowNumber() {
        return positions.getFirst().coordinate().getY();
    }

    private int getWidthFromRow(int widthExpander) {
        return positions.stream().anyMatch(pos -> pos.character() == '#') ? 1 : widthExpander;
    }

}
