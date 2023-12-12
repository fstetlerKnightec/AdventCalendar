package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DayThree {

    // Check each character, check if its a number. If its a number, check in a 360 grid around it, one index row above, 1 2 3, left right, then under 1 2 3
    // If its a special character in any place, that number is tagged now find the value after and the one after that, see if its a dot, or the one before, see if dot
    // then add the number to a int with multiplier either 1, 10, or 100
    // then sum it all



    public void numberHasAdjacantWeirdSymbol(List<String> listOfStrings) {








    }



    public static List<List<Integer>> eachNumberAndItsRowAndColumnIndexFromList(List<String> listOfStrings) {

        List<Integer> numberAndRowAndColumnIndex = new ArrayList<>();
        List<List<Integer>> listOfNumberAndRowAndColumnIndex = new ArrayList<>();

        for (int i = 0; i < listOfStrings.size(); i++) {
            String currentString = listOfStrings.get(i);
            for (int j = 0; j < currentString.length() - 2; j++) {
                int value;
                int firstValue;
                if (Character.isDigit(currentString.charAt(j))) {
                    int columnValue = j;
                    int rowValue = i;
                    firstValue = Integer.parseInt(String.valueOf(currentString.charAt(j)));
                    int skipValue = 0;
                    boolean cont = true;

                    if (!Character.isDigit(currentString.charAt(j+1))) {
                        numberAndRowAndColumnIndex.add(firstValue);
                        numberAndRowAndColumnIndex.add(rowValue);
                        numberAndRowAndColumnIndex.add(columnValue);

                        listOfNumberAndRowAndColumnIndex.add(numberAndRowAndColumnIndex);
                        cont = false;
                    }

                    if (cont && !Character.isDigit(currentString.charAt(j+2))) {
                        value = 10 * Integer.parseInt(String.valueOf(currentString.charAt(j)))
                                + Integer.parseInt(String.valueOf(currentString.charAt(j+1)));
                        numberAndRowAndColumnIndex.add(value);
                        numberAndRowAndColumnIndex.add(rowValue);
                        numberAndRowAndColumnIndex.add(columnValue);

                        listOfNumberAndRowAndColumnIndex.add(numberAndRowAndColumnIndex);
                        skipValue = 1;
                        cont = false;
                    }

                    if (cont && !Character.isDigit(currentString.charAt(j+3))) {
                        value = 100 * Integer.parseInt(String.valueOf(currentString.charAt(j)))
                                + 10 * Integer.parseInt(String.valueOf(currentString.charAt(j+1)))
                                + Integer.parseInt(String.valueOf(currentString.charAt(j+2)));
                        numberAndRowAndColumnIndex.add(value);
                        numberAndRowAndColumnIndex.add(rowValue);
                        numberAndRowAndColumnIndex.add(columnValue);

                        listOfNumberAndRowAndColumnIndex.add(numberAndRowAndColumnIndex);
                        skipValue = 2;
                    }
                    j += skipValue;
                }
            }
        }

        return listOfNumberAndRowAndColumnIndex;

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
            listOfStrings.set(i, listOfStrings.get(i) + "..");
        }

        listOfStrings.add(0, ".".repeat(141));

        listOfStrings.add(".".repeat(141));

//        String stringOfDots = "." * 140;

        return listOfStrings;
    }


}
