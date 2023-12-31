package org.advent.daythree;

import java.util.List;

public class Number {
    private final int numberValue;
    private final int row;
    private final int column;
    private boolean isAdjacentToSymbol;
    private StarCoordinates adjacentStarCoordinates;
    private boolean hasBeenUsed;

    public Number(int numberValue, int row, int column) {
        this.numberValue = numberValue;
        this.row = row;
        this.column = column;
    }

    public boolean doesNumberHasAdjacentSymbol(List<String> listOfStrings, int rowIndex, int columnIndex, int numberLength) {
        for (int rowOffset = -1; rowOffset < 2; rowOffset++) {
            for (int colOffset = -1; colOffset < numberLength + 1; colOffset++ ) {
                if (doesCharacterEqualSymbol(listOfStrings, rowIndex + rowOffset, columnIndex + colOffset)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean doesCharacterEqualSymbol(List<String> listOfStrings, int row, int column) {
        if (listOfStrings.get(row).charAt(column) == '*') {
            setAdjacentStarCoordinates(new StarCoordinates(row, column));
        }
        return listOfStrings.get(row).charAt(column) != '.' && !Character.isDigit(listOfStrings.get(row).charAt(column));
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

    public boolean hasNotBeenUsed() {
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
