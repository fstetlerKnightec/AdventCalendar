package org.advent.dayeleven;

import java.util.List;

public interface RowCol {

    int getRowColNumber();

    int getWidth();

    List<Position> positions();
}
