package org.advent.dayfour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayFour {


    public int exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame(WinningNumbers winningNumbers, NumbersYouHave numbersYouHave) {

        int numberOfMatchingNumbers = 0;
        for (int i = 0; i < winningNumbers.getWinningNumbers().size(); i++) {
            for (int j = 0; j < numbersYouHave.getNumbersYouHave().size(); j++) {
                if (winningNumbers.getWinningNumbers().get(i).equals(numbersYouHave.getNumbersYouHave().get(j))) {
                    numberOfMatchingNumbers += 1;
                }
            }
        }
        return (int) Math.pow(2, numberOfMatchingNumbers - 1);
    }

    public int totalSum(List<WinningNumbers> winningNumbersList, List<NumbersYouHave> numbersYouHaveList) {
        int totalSum = 0;
        for (int i = 0; i < winningNumbersList.size(); i++) {
            WinningNumbers winningNumbers = winningNumbersList.get(i);
            NumbersYouHave numbersYouHave = numbersYouHaveList.get(i);
            totalSum += exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame(winningNumbers, numbersYouHave);
        }
        return totalSum;
    }

    public List<WinningNumbers> listOfWinningNumbers(List<String> listOfCutString) {
        List<WinningNumbers> winningNumbersList = new ArrayList<>();
        for (String s : listOfCutString) {
            String currentWinningString = s.split("\\|")[0];
            String[] numberStrings = currentWinningString.trim().split("\\s+");
            List<Integer> integerList = new ArrayList<>();
            for (String numberString : numberStrings) {
                int number = Integer.parseInt(numberString);
                integerList.add(number);
            }
            WinningNumbers winningNumbers = new WinningNumbers(integerList);
            winningNumbersList.add(winningNumbers);
        }
        return winningNumbersList;

    }

    public List<NumbersYouHave> listOfNumbersYouHave(List<String> listOfCutString) {
        List<NumbersYouHave> numbersYouHaveList = new ArrayList<>();
        for (String s : listOfCutString) {
            String currentNumbersYouHaveString = s.split("\\|")[1];
            String[] numberStrings = currentNumbersYouHaveString.trim().split("\\s+");
            List<Integer> integerList = new ArrayList<>();
            for (String numberString : numberStrings) {
                int number = Integer.parseInt(numberString);
                integerList.add(number);
            }
            NumbersYouHave numbersYouHave = new NumbersYouHave(integerList);
            numbersYouHaveList.add(numbersYouHave);
        }
        return numbersYouHaveList;

    }


    public List<String> removeFrontPartOfStringAndReturnList(List<String> stringList) {
        return stringList.stream().map(s -> s.replaceAll(".*:", "")).toList();
    }

    public List<String> readStringsFromFile(String filePath) throws IOException {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
        }
        return stringList;
    }
}
