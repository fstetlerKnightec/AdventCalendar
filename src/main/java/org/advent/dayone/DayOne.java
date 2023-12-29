package org.advent.dayone;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DayOne implements PrintSolution {

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

    @Override
    public void printPartOne() throws IOException {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total sum of all values in list = " + results(true));

    }

    @Override
    public void printPartTwo() throws IOException {
        System.out.println("Total sum of all numbers, even the text ones, in list = " + results(false));
    }


    public int results(boolean isPartOne) throws IOException {

        Util util = new Util();
        List<String> listOfStrings = util.readStringsFromFile(Paths.get("src/main/resources/dayOne.txt").toString());
        List<String> listOfFirstNumbersFromLeft = listOfStrings.stream()
                .map(s -> returnFirstNumberFromString(String.valueOf(s), false, isPartOne)).toList();
        List<String> listOfFirstNumbersFromRight = listOfStrings.stream()
                .map(s -> returnFirstNumberFromString(String.valueOf(s), true, isPartOne)).toList();

        List<String> listOfCombinedNumbersFromLeftAndRight =
                IntStream.range(0, listOfFirstNumbersFromLeft.size())
                        .mapToObj(i -> listOfFirstNumbersFromLeft.get(i) + listOfFirstNumbersFromRight.get(i)).toList();

        return addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight);
    }
}
