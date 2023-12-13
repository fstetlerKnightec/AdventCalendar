package org.advent.daythree;

public class Number {

    int numberValue;
    int row;
    int column;
    boolean hasAdjacentToSymbol;

    public Number() {

    }

    public Number(int numberValue, int row, int column, boolean adjacentToSymbol) {
        this.numberValue = numberValue;
        this.row = row;
        this.column = column;
        this.hasAdjacentToSymbol = adjacentToSymbol;
    }

    public int getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(int numberValue) {
        this.numberValue = numberValue;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isHasAdjacentToSymbol() {
        return hasAdjacentToSymbol;
    }

    public void setHasAdjacentToSymbol(boolean hasAdjacentToSymbol) {
        this.hasAdjacentToSymbol = hasAdjacentToSymbol;
    }
}
