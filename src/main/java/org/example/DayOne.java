package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayOne {

    public Integer addAllNumbersTogether(List<String> listOfStrings) {
        int totalNumber = 0;
        List<String> listOfAddedNumbers = addBothNumbersFromList(listOfStrings);
        for (int i = 0; i < listOfAddedNumbers.size(); i++) {
            totalNumber += Integer.parseInt(listOfAddedNumbers.get(i));
        }
        return totalNumber;
    }

    public List<String> addBothNumbersFromList(List<String> listOfStrings) {
        String combinedNumber;
        List<String> combinedNumberList = new ArrayList<>();
        for (int i = 0; i < listOfStrings.size(); i++) {
            String firstNumber = returnFirstNumberFromLeft(listOfStrings).get(i);
            String secondNumber = returnFirstNumberFromRight(listOfStrings).get(i);
            combinedNumber = firstNumber + secondNumber;
            combinedNumberList.add(combinedNumber);
        }
        return combinedNumberList;
    }

    public List<String> returnFirstNumberFromLeft(List<String> listOfStrings) {

        Integer firstNumber = null;
        List<String> firstNumberList = new ArrayList<>();
        for (int i = 0; i < listOfStrings.size(); i++) {
            String currentString = listOfStrings.get(i);
            for (int j = 0; j < currentString.length(); j++) {

                if (Character.isDigit(currentString.charAt(j))) {
                    firstNumber = Integer.parseInt(String.valueOf(currentString.charAt(j)));
                    break;
                }


                if (currentString.startsWith("one", j)) {
                    firstNumber = 1;
                    break;
                }

                if (currentString.startsWith("two", j)) {
                    firstNumber = 2;
                    break;
                }

                if (currentString.startsWith("three", j)) {
                    firstNumber = 3;
                    break;
                }

                if (currentString.startsWith("four", j)) {
                    firstNumber = 4;
                    break;
                }

                if (currentString.startsWith("five", j)) {
                    firstNumber = 5;
                    break;
                }

                if (currentString.startsWith("six", j)) {
                    firstNumber = 6;
                    break;
                }

                if (currentString.startsWith("seven", j)) {
                    firstNumber = 7;
                    break;
                }

                if (currentString.startsWith("eight", j)) {
                    firstNumber = 8;
                    break;
                }

                if (currentString.startsWith("nine", j)) {
                    firstNumber = 9;
                    break;
                }
            }
            firstNumberList.add(String.valueOf(firstNumber));
        }
        return firstNumberList;
    }

    public List<String> returnFirstNumberFromRight(List<String> listOfStrings) {
        Integer firstNumber = null;
        List<String> firstNumberList = new ArrayList<>();

        for (int i = 0; i < listOfStrings.size(); i++) {
            String currentString = reverseString(listOfStrings.get(i));

            for (int j = 0; j < currentString.length(); j++) {

                if (Character.isDigit(currentString.charAt(j))) {
                    firstNumber = Integer.parseInt(String.valueOf(currentString.charAt(j)));
                    break;
                }

                if (currentString.startsWith("eno", j)) {
                    firstNumber = 1;
                    break;
                }

                if (currentString.startsWith("owt", j)) {
                    firstNumber = 2;
                    break;
                }

                if (currentString.startsWith("eerht", j)) {
                    firstNumber = 3;
                    break;
                }

                if (currentString.startsWith("ruof", j)) {
                    firstNumber = 4;
                    break;
                }

                if (currentString.startsWith("evif", j)) {
                    firstNumber = 5;
                    break;
                }

                if (currentString.startsWith("xis", j)) {
                    firstNumber = 6;
                    break;
                }

                if (currentString.startsWith("neves", j)) {
                    firstNumber = 7;
                    break;
                }

                if (currentString.startsWith("thgie", j)) {
                    firstNumber = 8;
                    break;
                }

                if (currentString.startsWith("enin", j)) {
                    firstNumber = 9;
                    break;
                }
            }
            firstNumberList.add(String.valueOf(firstNumber));
        }
        return firstNumberList;
    }

    public List<String> readFileAndReturnList(String filePath) {
        ArrayList<String> wordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.trim();
                    if (!word.isEmpty()) {
                        wordList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    private static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        return reversed.toString();
    }
}
