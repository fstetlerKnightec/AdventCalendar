package org.advent.dayone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayOne {

    public String returnFirstNumberFromString(String currentString, boolean reversed, boolean partOne) {

        List<String> listOfNumbersAsWords;
        if (reversed) {
            listOfNumbersAsWords = new ArrayList<>(Arrays.asList("eno", "owt", "eerht", "ruof", "evif", "xis", "neves", "thgie", "enin" ));
            currentString = reverseString(currentString);
        } else {
            listOfNumbersAsWords = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine" ));
        }

        for (int i = 0; i < currentString.length(); i++) {
            boolean found = false;
            if (Character.isDigit(currentString.charAt(i))) {
                return String.valueOf(currentString.charAt(i));
            }
            for (int j = 0; j < listOfNumbersAsWords.size(); j++) {
                if (currentString.startsWith(listOfNumbersAsWords.get(j), i) && !found && !partOne) {
                    return String.valueOf(j+1);
                }
            }
        }
        return null;
    }

    public Integer addAllNumbersTogether(List<String> listOfCombinedNumbers) {
        return listOfCombinedNumbers.stream().mapToInt(Integer::parseInt).sum();
    }

    private static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        return reversed.toString();
    }
}
