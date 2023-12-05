package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet"));

        System.out.println(calculateSumOfAllValues(listOfStrings));

    }

    public static Integer calculateSumOfAllValues(List<String> listOfStrings) {
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

}