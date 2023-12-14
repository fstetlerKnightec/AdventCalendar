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
                Number number = new Number();
                number.setRow(rowIndex);
                number.setColumn(i);
                number.setNumberValue(numberAtIndexOnRow(currentLine, i));
                number.setHasAdjacentToSymbol(false);
                numbers.add(number);
                i = i + String.valueOf(number.getNumberValue()).length();
            }
        }

        return numbers;
    }

    public List<Number> listOfAllNumbers(List<String> listOfCutStrings) {
        List<Number> numbersFromAllStrings = new ArrayList<>();
        for (int i = 0; i < listOfCutStrings.size(); i++) {
            List<Number> numbers = numbersOnCurrentLine(listOfCutStrings.get(i), i);
            numbersFromAllStrings.addAll(numbers);
        }

        return numbersFromAllStrings;
    }

    public int numberAtIndexOnRow(String currentLine, int columnIndex) {
        if (isCharNotDigitOnIndex(currentLine, columnIndex, 1)) {
            return Integer.parseInt(String.valueOf(currentLine.charAt(columnIndex)));
        }
        if (isCharNotDigitOnIndex(currentLine, columnIndex, 2)) {
            return Integer.parseInt(currentLine.charAt(columnIndex) + String.valueOf(currentLine.charAt(columnIndex + 1)));
        }

        return Integer.parseInt(currentLine.charAt(columnIndex) + String.valueOf(currentLine.charAt(columnIndex + 1)) + currentLine.charAt(columnIndex + 2));

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
