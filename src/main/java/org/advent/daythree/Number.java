package org.advent.daythree;

import java.util.ArrayList;
import java.util.List;

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

    public boolean doesCharacterHaveAdjacantSymbol(List<String> listOfStrings, String symbol, int rowIndex, int columnIndex) {
        return doesNumberHasAdjacantSymbol(listOfStrings, symbol, rowIndex, columnIndex, String.valueOf(numberValue).length());
    }

    public boolean doesOneDigitCharacterHasAdjacantSymbol(List<String> listOfStrings, String symbol, int rowIndex, int columnIndex) {

//        for (Direction direction : Direction.values()) {
//            System.out.println(direction.getCol());
//        }

        for (int rowOffset = -1; rowOffset < 2; rowOffset++) {
            for (int colOffset = -1; colOffset < 2; colOffset++ ) {
                if (String.valueOf(listOfStrings.get(rowIndex + rowIndex).charAt(columnIndex + colOffset)).equals(symbol)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean doesNumberHasAdjacantSymbol(List<String> listOfStrings, String symbol, int rowIndex, int columnIndex, int numberLength) {
        for (int rowOffset = -1; rowOffset < 2; rowOffset++) {
            for (int colOffset = -1; colOffset < numberLength + 1; colOffset++ ) {
                if (String.valueOf(listOfStrings.get(rowIndex + rowIndex).charAt(columnIndex + colOffset)).equals(symbol)) {
                    return true;
                }
            }
        }
        return false;
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

    public boolean getHasAdjacentToSymbol() {
        return hasAdjacentToSymbol;
    }

    public void setHasAdjacentToSymbol(boolean hasAdjacentToSymbol) {
        this.hasAdjacentToSymbol = hasAdjacentToSymbol;
    }
}
