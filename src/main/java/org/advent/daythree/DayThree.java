package org.advent.daythree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        List<String> symbols = new ArrayList<>(Arrays.asList("*", "#", "+", "$", "@", "/", "=", "-", "&", "%"));
        for (Number currentNumber : listOfAllNumbers) {
            for (String s : symbols) {
                if (currentNumber.doesNumberHasAdjacentSymbol(listOfStrings, s, currentNumber.getRow(), currentNumber.getColumn(), String.valueOf(currentNumber.getNumberValue()).length())) {
                    currentNumber.setIsAdjacentToSymbol(true);
                    break;
                }
            }
        }
    }

    public int calculateTotalValueOfAllAdjacentValuesToStar(List<Number> listOfAllNumbers) {
        int totalValue = 0;
        for (int i = 0; i < listOfAllNumbers.size(); i++) {
            Number currentNumber = listOfAllNumbers.get(i);
            for (Number secondNumber : listOfAllNumbers) {
                if (currentNumber != secondNumber) {
                    if (currentNumber.getAdjacentStarCoordinates() != null && secondNumber.getAdjacentStarCoordinates() != null) {
                        if (currentNumber.getAdjacentStarCoordinates().getColumnIndex() == secondNumber.getAdjacentStarCoordinates().getColumnIndex() && currentNumber.getAdjacentStarCoordinates().getRowIndex() == secondNumber.getAdjacentStarCoordinates().getRowIndex()) {
                            if (currentNumber.isHasBeenUsed() || secondNumber.isHasBeenUsed()) {
                                totalValue += currentNumber.getNumberValue() * secondNumber.getNumberValue();
                                currentNumber.setHasBeenUsed(true);
                                secondNumber.setHasBeenUsed(true);
                            }
                        }
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
        if (isCharNotDigitOnIndex(currentLine, columnIndex, 1)) {
            return returnOneDigitNumber(currentLine, columnIndex);
        }
        if (isCharNotDigitOnIndex(currentLine, columnIndex, 2)) {
            return returnTwoDigitNumber(currentLine, columnIndex);
        }
        return returnThreeDigitNumber(currentLine, columnIndex);
    }

    public int returnTwoDigitNumber(String currentLine, int columnIndex) {
        return Integer.parseInt(currentLine.charAt(columnIndex) + String.valueOf(currentLine.charAt(columnIndex + 1)));
    }

    public int returnOneDigitNumber(String currentLine, int columnIndex) {
        return Integer.parseInt(String.valueOf(currentLine.charAt(columnIndex)));
    }

    public int returnThreeDigitNumber(String currentLine, int columnIndex) {
        return Integer.parseInt(currentLine.charAt(columnIndex) + String.valueOf(currentLine.charAt(columnIndex + 1)) + currentLine.charAt(columnIndex + 2));
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

    public static List<String> readFileAndReturnList(String filePath) throws FileNotFoundException {
        ArrayList<String> listOfStrings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.trim();
                    if (!word.isEmpty()) {
                        listOfStrings.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Could not find the file located at " + filePath);
        }

        for (int i = 0; i < listOfStrings.size(); i++) {
            listOfStrings.set(i, "." + listOfStrings.get(i));
            listOfStrings.set(i, listOfStrings.get(i) + "...");
        }

        listOfStrings.add(0, ".".repeat(143));
        listOfStrings.add(".".repeat(143));

        return listOfStrings;
    }
}
