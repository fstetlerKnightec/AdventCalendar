package org.advent.daythree;

import java.util.List;

public class Number {

    int numberValue;
    int row;
    int column;
    boolean isAdjacentToSymbol;
    StarCoordinates adjacentStarCoordinates;
    boolean hasBeenUsed;

    public Number(int numberValue, int row, int column) {
        this.numberValue = numberValue;
        this.row = row;
        this.column = column;
    }

    public boolean doesNumberHasAdjacentSymbol(List<String> listOfStrings, String symbol, int rowIndex, int columnIndex, int numberLength) {
        for (int rowOffset = -1; rowOffset < 2; rowOffset++) {
            for (int colOffset = -1; colOffset < numberLength + 1; colOffset++ ) {
                if (String.valueOf(listOfStrings.get(rowIndex + rowOffset).charAt(columnIndex + colOffset)).equals(symbol)) {
                    if (String.valueOf(listOfStrings.get(rowIndex + rowOffset).charAt(columnIndex + colOffset)).equals("*")) {
                        setAdjacentStarCoordinates(new StarCoordinates(rowIndex + rowOffset, columnIndex + colOffset));
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int getNumberValue() {
        return numberValue;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean getIsAdjacentToSymbol() {
        return isAdjacentToSymbol;
    }

    public void setIsAdjacentToSymbol(boolean isAdjacentToSymbol) {
        this.isAdjacentToSymbol = isAdjacentToSymbol;
    }

    public boolean isHasBeenUsed() {
        return !hasBeenUsed;
    }

    public void setHasBeenUsed(boolean hasBeenUsed) {
        this.hasBeenUsed = hasBeenUsed;
    }

    public StarCoordinates getAdjacentStarCoordinates() {
        return adjacentStarCoordinates;
    }

    public void setAdjacentStarCoordinates(StarCoordinates adjacentStarCoordinates) {
        this.adjacentStarCoordinates = adjacentStarCoordinates;
    }
}
