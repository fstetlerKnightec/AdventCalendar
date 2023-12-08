package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayOneClean {

    public String returnFirstNumberFromString(String currentString, boolean reversed, boolean partOne) {

        List<String> listOfNumbersAsWords;
        if (reversed) {
            listOfNumbersAsWords = new ArrayList<>(Arrays.asList("eno", "owt", "eerht", "ruof", "evif", "xis", "neves", "thgie", "enin" ));
            currentString = reverseString(currentString);
        } else {
            listOfNumbersAsWords = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine" ));
        }

        Integer firstNumber = null;
        for (int i = 0; i < currentString.length(); i++) {
            boolean found = false;
            if (Character.isDigit(currentString.charAt(i))) {
                firstNumber = Integer.parseInt(String.valueOf(currentString.charAt(i)));
                found = true;
            }
            for (int j = 0; j < listOfNumbersAsWords.size(); j++) {
                if (currentString.startsWith(listOfNumbersAsWords.get(j), i) && !found && !partOne) {
                    firstNumber = (j+1);
                    found = true;
                }
            }
            if (found) {
                break;
            }
        }

        return String.valueOf(firstNumber);
    }

    public Integer addAllNumbersTogether(List<String> listOfCombinedNumbers) {
        return listOfCombinedNumbers.stream().mapToInt(Integer::parseInt).sum();
    }

    public List<String> readFileAndReturnList(String filePath) throws FileNotFoundException {
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
        return listOfStrings;
    }

    private static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        return reversed.toString();
    }
}