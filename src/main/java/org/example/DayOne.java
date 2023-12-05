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

        for (int i = 0; i < wordList.size(); i++) {

            if (wordList.get(i).contains("one")) {
                wordList.set(i, wordList.get(i).replace("one", "1"));
            }
            if (wordList.get(i).contains("two")) {
                wordList.set(i, wordList.get(i).replace("two", "2"));
            }
            if (wordList.get(i).contains("three")) {
                wordList.set(i, wordList.get(i).replace("three", "3"));
            }
            if (wordList.get(i).contains("four")) {
                wordList.set(i, wordList.get(i).replace("four", "4"));
            }
            if (wordList.get(i).contains("five")) {
                wordList.set(i, wordList.get(i).replace("five", "5"));
            }
            if (wordList.get(i).contains("six")) {
                wordList.set(i, wordList.get(i).replace("six", "6"));
            }
            if (wordList.get(i).contains("seven")) {
                wordList.set(i, wordList.get(i).replace("seven", "7"));
            }
            if (wordList.get(i).contains("eight")) {
                wordList.set(i, wordList.get(i).replace("eight", "8"));
            }
            if (wordList.get(i).contains("nine")) {
                wordList.set(i, wordList.get(i).replace("nine", "9"));
            }
        }

        System.out.println(wordList.get(12));
        return wordList;
    }
}
