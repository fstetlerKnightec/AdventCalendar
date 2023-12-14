package org.advent.daythree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number {

    int numberValue;
    int row;
    int column;
    boolean hasAdjacentToSymbol;

    public boolean isHasBeenUsed() {
        return hasBeenUsed;
    }

    public void setHasBeenUsed(boolean hasBeenUsed) {
        this.hasBeenUsed = hasBeenUsed;
    }

    boolean hasBeenUsed;

    public StarCoordinates getAdjacantSymbolCoordinates() {
        return adjacantSymbolCoordinates;
    }

    public void setAdjacantSymbolCoordinates(StarCoordinates adjacantSymbolCoordinates) {
        this.adjacantSymbolCoordinates = adjacantSymbolCoordinates;
    }

    StarCoordinates adjacantSymbolCoordinates;

    public StarCoordinates getAdjacantStarCoordinates() {
        return adjacantStarCoordinates;
    }

    public void setAdjacantStarCoordinates(StarCoordinates adjacantStarCoordinates) {
        this.adjacantStarCoordinates = adjacantStarCoordinates;
    }

    StarCoordinates adjacantStarCoordinates;

    public Number() {

    }

    public Number(int numberValue, int row, int column, boolean adjacentToSymbol) {
        this.numberValue = numberValue;
        this.row = row;
        this.column = column;
        this.hasAdjacentToSymbol = adjacentToSymbol;
    }

    public Number(int numberValue, int row, int column) {
        this.numberValue = numberValue;
        this.row = row;
        this.column = column;
    }


    public boolean doesNumberHasAdjacantSymbol(List<String> listOfStrings, String symbol, int rowIndex, int columnIndex, int numberLength) {
        for (int rowOffset = -1; rowOffset < 2; rowOffset++) {
            for (int colOffset = -1; colOffset < numberLength + 1; colOffset++ ) {
                if (String.valueOf(listOfStrings.get(rowIndex + rowOffset).charAt(columnIndex + colOffset)).equals(symbol)) {
                    if (String.valueOf(listOfStrings.get(rowIndex + rowOffset).charAt(columnIndex + colOffset)).equals("*")) {
                        setAdjacantStarCoordinates(new StarCoordinates(rowIndex + rowOffset, columnIndex + colOffset));
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

    public boolean getHasAdjacentToSymbol() {
        return hasAdjacentToSymbol;
    }

    public void setHasAdjacentToSymbol(boolean hasAdjacentToSymbol) {
        this.hasAdjacentToSymbol = hasAdjacentToSymbol;
    }
}
