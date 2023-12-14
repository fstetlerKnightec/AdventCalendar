package org.advent.daythree;

public class StarCoordinates {

    public StarCoordinates(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    int rowIndex;

    int columnIndex;
}
