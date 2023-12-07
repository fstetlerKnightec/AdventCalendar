package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String combinedNumber = null;
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

//            String currentString = listOfStrings.get(i);
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

    private static String reverseString(String input) {
        // Use StringBuilder to reverse the string
        StringBuilder reversed = new StringBuilder(input).reverse();
        return reversed.toString();
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

//    public Integer calculateSumOfAllValues(List<String> listOfStrings) {
//        int totalValue = 0;
//        for (int i = 0; i < listOfStrings.size(); i++) {
//            String stringNumber = "";
//            for (int j = 0; j < listOfStrings.get(i).charAt(j); j++) {
//                if (Character.isDigit(listOfStrings.get(i).charAt(j))) {
//                    stringNumber += listOfStrings.get(i).charAt(j);
//                    break;
//                }
//            }
//
//            for (int j = 0; j <listOfStrings.size(); j++) {
//                if (Character.isDigit(listOfStrings.get(i).charAt(j))) {
//                    stringNumber += listOfStrings.get(i).charAt(j);
//                    break;
//                }
//            }
//            totalValue += Integer.parseInt(stringNumber);
//        }
//        return totalValue;
//    }

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


    public void replaceNumbersAsWordsWithNumbersAsNumericInString(List<String> stringList) {




    }




















//    public void replaceNumbersAsWordsWithNumbersAsNumericInString(List<String> wordList) {
//        for (int i = 0; i < wordList.size(); i++) {
//            replaceLettersOneWithNumeric1(wordList, i);
//            replaceLettersTwoWithNumeric2(wordList, i);
//            replaceLettersThreeWithNumeric3(wordList, i);
//            replaceLettersFourWithNumeric4(wordList, i);
//            replaceLettersFiveWithNumeric5(wordList, i);
//            replaceLettersSixWithNumeric6(wordList, i);
//            replaceLettersSevenWithNumeric7(wordList, i);
//            replaceLettersEightWithNumeric8(wordList, i);
//            replaceLettersNineWithNumeric9(wordList, i);
//        }
//    }
//
//    private static void replaceLettersNineWithNumeric9(List<String> wordList, int i) {
//        while (wordList.get(i).contains("nine")) {
//            replaceLettersEightWithNumeric8(wordList, i);
//            wordList.set(i, wordList.get(i).replace("nine", "9"));
//        }
//    }
//
//    private static void replaceLettersEightWithNumeric8(List<String> wordList, int i) {
//        while (wordList.get(i).contains("eight")) {
//            if (wordList.get(i).indexOf("three") < wordList.get(i).indexOf("eight")) {
//                wordList.set(i, wordList.get(i).replace("three", "3"));
//            }
//            if (wordList.get(i).indexOf("two") < wordList.get(i).indexOf("eight")) {
//                wordList.set(i, wordList.get(i).replace("two", "2"));
//            }
//            if (wordList.get(i).indexOf("nine") < wordList.get(i).indexOf("eight")) {
//                wordList.set(i, wordList.get(i).replace("nine", "9"));
//            }
//            if (wordList.get(i).indexOf("five") < wordList.get(i).indexOf("eight")) {
//                wordList.set(i, wordList.get(i).replace("five", "5"));
//            }
//            if (wordList.get(i).contains("eight")) {
//                wordList.set(i, wordList.get(i).replace("eight", "8"));
//            }
//        }
//    }
//
//    private static void replaceLettersSevenWithNumeric7(List<String> wordList, int i) {
//        while (wordList.get(i).contains("seven")) {
//            wordList.set(i, wordList.get(i).replace("seven", "7"));
//        }
//    }
//
//    private static void replaceLettersSixWithNumeric6(List<String> wordList, int i) {
//        while (wordList.get(i).contains("six")) {
//            wordList.set(i, wordList.get(i).replace("six", "6"));
//        }
//    }
//
//    private static void replaceLettersFiveWithNumeric5(List<String> wordList, int i) {
//        while (wordList.get(i).contains("five")) {
//            wordList.set(i, wordList.get(i).replace("five", "5"));
//        }
//    }
//
//    private static void replaceLettersFourWithNumeric4(List<String> wordList, int i) {
//        while (wordList.get(i).contains("four")) {
//            wordList.set(i, wordList.get(i).replace("four", "4"));
//        }
//    }
//
//    private static void replaceLettersThreeWithNumeric3(List<String> wordList, int i) {
//        while (wordList.get(i).contains("three")) {
//            replaceLettersEightWithNumeric8(wordList, i);
//            wordList.set(i, wordList.get(i).replace("three", "3"));
//        }
//    }
//
//    private static void replaceLettersTwoWithNumeric2(List<String> wordList, int i) {
//        while (wordList.get(i).contains("two")) {
//            replaceLettersEightWithNumeric8(wordList, i);
//            wordList.set(i, wordList.get(i).replace("two", "2"));
//        }
//    }
//
//    private static void replaceLettersOneWithNumeric1(List<String> wordList, int i) {
//        while (wordList.get(i).contains("one")) {
//            replaceLettersTwoWithNumeric2(wordList, i);
//            wordList.set(i, wordList.get(i).replace("one", "1"));
//        }
//    }
}
