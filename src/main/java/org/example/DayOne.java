package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayOne {

    public Integer calculateSumOfAllValues(List<String> listOfStrings) {
        int totalValue = 0;
        for (int i = 0; i < listOfStrings.size(); i++) {
            String stringNumber = "";
            for (int j = 0; j < listOfStrings.get(i).charAt(j); j++) {
                if (Character.isDigit(listOfStrings.get(i).charAt(j))) {
                    stringNumber += listOfStrings.get(i).charAt(j);
                    break;
                }
            }

            for (int j = listOfStrings.get(i).length() - 1; j >= 0; j--) {
                if (Character.isDigit(listOfStrings.get(i).charAt(j))) {
                    stringNumber += listOfStrings.get(i).charAt(j);
                    break;
                }
            }
            totalValue += Integer.parseInt(stringNumber);
        }
        return totalValue;
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

        replaceNumbersAsWordsWithNumbersAsNumericInString(wordList);

        return wordList;
    }

    public void replaceNumbersAsWordsWithNumbersAsNumericInString(List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            replaceLettersOneWithNumeric1(wordList, i);
            replaceLettersTwoWithNumeric2(wordList, i);
            replaceLettersThreeWithNumeric3(wordList, i);
            replaceLettersFourWithNumeric4(wordList, i);
            replaceLettersFiveWithNumeric5(wordList, i);
            replaceLettersSixWithNumeric6(wordList, i);
            replaceLettersSevenWithNumeric7(wordList, i);
            replaceLettersEightWithNumeric8(wordList, i);
            replaceLettersNineWithNumeric9(wordList, i);
        }
    }

    private static void replaceLettersNineWithNumeric9(List<String> wordList, int i) {
        while (wordList.get(i).contains("nine")) {
            replaceLettersEightWithNumeric8(wordList, i);
            wordList.set(i, wordList.get(i).replace("nine", "9"));
        }
    }

    private static void replaceLettersEightWithNumeric8(List<String> wordList, int i) {
        while (wordList.get(i).contains("eight")) {
            if (wordList.get(i).indexOf("three") < wordList.get(i).indexOf("eight")) {
                wordList.set(i, wordList.get(i).replace("three", "3"));
            }
            if (wordList.get(i).indexOf("two") < wordList.get(i).indexOf("eight")) {
                wordList.set(i, wordList.get(i).replace("two", "2"));
            }
            if (wordList.get(i).indexOf("nine") < wordList.get(i).indexOf("eight")) {
                wordList.set(i, wordList.get(i).replace("nine", "9"));
            }
            if (wordList.get(i).indexOf("five") < wordList.get(i).indexOf("eight")) {
                wordList.set(i, wordList.get(i).replace("five", "5"));
            }
            if (wordList.get(i).contains("eight")) {
                wordList.set(i, wordList.get(i).replace("eight", "8"));
            }
        }
    }

    private static void replaceLettersSevenWithNumeric7(List<String> wordList, int i) {
        while (wordList.get(i).contains("seven")) {
            wordList.set(i, wordList.get(i).replace("seven", "7"));
        }
    }

    private static void replaceLettersSixWithNumeric6(List<String> wordList, int i) {
        while (wordList.get(i).contains("six")) {
            wordList.set(i, wordList.get(i).replace("six", "6"));
        }
    }

    private static void replaceLettersFiveWithNumeric5(List<String> wordList, int i) {
        while (wordList.get(i).contains("five")) {
            wordList.set(i, wordList.get(i).replace("five", "5"));
        }
    }

    private static void replaceLettersFourWithNumeric4(List<String> wordList, int i) {
        while (wordList.get(i).contains("four")) {
            wordList.set(i, wordList.get(i).replace("four", "4"));
        }
    }

    private static void replaceLettersThreeWithNumeric3(List<String> wordList, int i) {
        while (wordList.get(i).contains("three")) {
            replaceLettersEightWithNumeric8(wordList, i);
            wordList.set(i, wordList.get(i).replace("three", "3"));
        }
    }

    private static void replaceLettersTwoWithNumeric2(List<String> wordList, int i) {
        while (wordList.get(i).contains("two")) {
            replaceLettersEightWithNumeric8(wordList, i);
            wordList.set(i, wordList.get(i).replace("two", "2"));
        }
    }

    private static void replaceLettersOneWithNumeric1(List<String> wordList, int i) {
        while (wordList.get(i).contains("one")) {
            replaceLettersTwoWithNumeric2(wordList, i);
            wordList.set(i, wordList.get(i).replace("one", "1"));
        }
    }
}
