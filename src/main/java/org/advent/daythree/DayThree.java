package org.advent.daythree;

import java.io.FileNotFoundException;
import java.util.*;

public class DayThree {

    public List<Number> numbersOnCurrentLine(String currentLine, int rowIndex) {
        List<Number> numbers = new ArrayList<>();

        for (int i = 0; i < currentLine.length(); i++) {
            if (Character.isDigit(currentLine.charAt(i))) {
                Number number = new Number(
                        numberAtIndexOnRow(currentLine, i),
                        rowIndex,
                        i);
                numbers.add(number);
                i = i + String.valueOf(number.getNumberValue()).length();
            }
        }
        return numbers;
    }

    public void setAdjacentToSymbolForNumber(List<Number> listOfAllNumbers, List<String> listOfStrings) {
        for (Number currentNumber : listOfAllNumbers) {
            if (currentNumber.doesNumberHasAdjacentSymbol(listOfStrings, currentNumber.getRow(), currentNumber.getColumn(), String.valueOf(currentNumber.getNumberValue()).length())) {
                currentNumber.setIsAdjacentToSymbol(true);
            }
        }
    }

    public int calculateTotalValueOfAllAdjacentValuesToStar(List<Number> listOfAllNumbers) {
        int totalValue = 0;
        for (int i = 0; i < listOfAllNumbers.size(); i++) {
            Number currentNumber = listOfAllNumbers.get(i);
            for (Number secondNumber : listOfAllNumbers) {
                totalValue = returnTotalValueIfNumbersAreValid(currentNumber, secondNumber, totalValue);
            }
        }
        return totalValue;
    }

    public int returnTotalValueIfNumbersAreValid(Number currentNumber, Number secondNumber, int totalValue) {
        if (currentNumber != secondNumber) {
            if (currentNumber.getAdjacentStarCoordinates() != null && secondNumber.getAdjacentStarCoordinates() != null) {
                if (currentNumber.getAdjacentStarCoordinates().equals(secondNumber.getAdjacentStarCoordinates())) {
                    if (currentNumber.hasNotBeenUsed() && secondNumber.hasNotBeenUsed()) {
                        totalValue += currentNumber.getNumberValue() * secondNumber.getNumberValue();
                        currentNumber.setHasBeenUsed(true);
                        secondNumber.setHasBeenUsed(true);
                    }
                }
            }
        }
        return totalValue;
    }

    public List<Number> listOfAllNumbers(List<String> listOfStrings) {
        List<Number> numbersFromAllStrings = new ArrayList<>();
        for (int i = 0; i < listOfStrings.size(); i++) {
            List<Number> numbers = numbersOnCurrentLine(listOfStrings.get(i), i);
            numbersFromAllStrings.addAll(numbers);
        }
        return numbersFromAllStrings;
    }

    public int numberAtIndexOnRow(String currentLine, int columnIndex) {
        for (int i = 1; i < 4; i++) {
            if (isCharNotDigitOnIndex(currentLine, columnIndex, i)) {
                return Integer.parseInt(currentLine.substring(columnIndex, columnIndex + i));
            }
        }
        return 0;
    }

    public int getTotalAddedNumbersAdjacentToSymbol(List<Number> listOfAllNumbers) {
        int totalValue = 0;
        for (Number currentNumber : listOfAllNumbers) {
            if (currentNumber.getIsAdjacentToSymbol()) {
                totalValue += currentNumber.getNumberValue();
            }
        }
        return totalValue;
    }

    public boolean isCharNotDigitOnIndex(String currentLine, int index, int offset) {
        return !Character.isDigit(currentLine.charAt(index + offset));
    }

    public List<String> addCushionLinesAndColumnsOnStringsInList(List<String> listOfStrings) throws FileNotFoundException {

        for (int i = 0; i < listOfStrings.size(); i++) {
            listOfStrings.set(i, "." + listOfStrings.get(i));
            listOfStrings.set(i, listOfStrings.get(i) + "...");
        }

        listOfStrings.add(0, ".".repeat(143));
        listOfStrings.add(".".repeat(143));

        return listOfStrings;
    }
}
