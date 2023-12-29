package org.advent.daythree;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class DayThree implements PrintSolution {

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

    public List<String> addCushionLinesAndColumnsOnStringsInList(List<String> listOfStrings) {

        for (int i = 0; i < listOfStrings.size(); i++) {
            listOfStrings.set(i, "." + listOfStrings.get(i));
            listOfStrings.set(i, listOfStrings.get(i) + "...");
        }

        listOfStrings.add(0, ".".repeat(143));
        listOfStrings.add(".".repeat(143));

        return listOfStrings;
    }

    public int results(boolean isPartOne) throws IOException {
        Util util = new Util();
        List<String> readList = util.readStringsFromFile(Paths.get("src/main/resources/dayThree.txt").toString());
        List<String> list3 = addCushionLinesAndColumnsOnStringsInList(readList);
        List<Number> listOfAllNumbers = listOfAllNumbers(list3);
        setAdjacentToSymbolForNumber(listOfAllNumbers, list3);

        if (isPartOne) {
            return getTotalAddedNumbersAdjacentToSymbol(listOfAllNumbers);
        }
        return calculateTotalValueOfAllAdjacentValuesToStar(listOfAllNumbers);
    }

    @Override
    public void printPartOne() throws IOException {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total value of numbers adjacent to symbol = " + results(true));

    }

    @Override
    public void printPartTwo() throws IOException {
        System.out.println("TotalValue for two values adjacent to a star = " + results(false));
    }

}
