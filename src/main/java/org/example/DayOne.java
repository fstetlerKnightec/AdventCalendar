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

            for (int j = listOfStrings.get(i).length() - 1; j > 0; j--) {
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
        return wordList;
    }

}
