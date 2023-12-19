package org.advent.dayfour;

import org.advent.daythree.Number;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayFour {


    public int exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame(NumbersPerCard numbersPerCard) {
        return (int) Math.pow(2, matchingNumbersPerCard(numbersPerCard) - 1);
    }

    public int matchingNumbersPerCard(NumbersPerCard numbersPerCard) {
        int numberOfMatchingNumbers = 0;
        for (int i = 0; i < numbersPerCard.getWinningNumbers().size(); i++) {
            for (int j = 0; j < numbersPerCard.getNumbersYouHave().size(); j++) {
                if (numbersPerCard.getWinningNumbers().get(i).equals(numbersPerCard.getNumbersYouHave().get(j))) {
                    numberOfMatchingNumbers += 1;
                }
            }
        }
        return numberOfMatchingNumbers;
    }

    public void setMatchingNumberPerCard(List<NumbersPerCard> listOfNumbersPerCard) {
        for (int i = 0; i < listOfNumbersPerCard.size(); i++) {
            int matchingNumber = matchingNumbersPerCard(listOfNumbersPerCard.get(i));
            listOfNumbersPerCard.get(i).setMatchingNumbers(matchingNumber);
        }
    }

    public void setNumberOfTotalPerCard(List<NumbersPerCard> listOfNumbersPerCard) {


        for (NumbersPerCard numbersPerCard : listOfNumbersPerCard) {
            numbersPerCard.addNumberOfTotalCards(1);
        }

        for (int i = 0; i < listOfNumbersPerCard.size(); i++) {
            for (int j = i + 1; j <= i + listOfNumbersPerCard.get(i).getMatchingNumbers(); j++) {
                listOfNumbersPerCard.get(j).addNumberOfTotalCards(listOfNumbersPerCard.get(i).getNumberOfTotalCards());
            }
        }
    }

    public int totalSumOfNumbersOfTotalPerCard(List<NumbersPerCard> listOfNumbersPerCard) {
        int totalSum = 0;

        for (int i = 0; i < listOfNumbersPerCard.size(); i++) {
            totalSum += listOfNumbersPerCard.get(i).getNumberOfTotalCards();
        }

        return totalSum;
    }

    public int totalSumOfAllExponentialValues(List<NumbersPerCard> listOfNumbersPerCard) {
        int totalValue = 0;
        for (int i = 0; i < listOfNumbersPerCard.size(); i++) {
            totalValue += exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame(listOfNumbersPerCard.get(i));
        }
        return totalValue;
    }

    public List<NumbersPerCard> listOfAllNumbersPerCard(List<String> listOfCutStrings) {
        List<NumbersPerCard> listOfNumbersPerCard= new ArrayList<>();
        for (String listOfCutString : listOfCutStrings) {
            listOfNumbersPerCard.add(numbersPerCard(listOfCutString));
        }
        return listOfNumbersPerCard;
    }

    public NumbersPerCard numbersPerCard(String cutString) {
        NumbersPerCard numbers = new NumbersPerCard();

        String winningString = cutString.split("\\|")[0];
        String numbersYouHaveString = cutString.split("\\|")[1];
        List<Integer> listOfWinningNumbers = listOfNumbers(winningString);
        List<Integer> listOfNumbersYouHave = listOfNumbers(numbersYouHaveString);
        numbers.setWinningNumbers(listOfWinningNumbers);
        numbers.setNumbersYouHave(listOfNumbersYouHave);

        return numbers;
    }

    public List<Integer> listOfNumbers(String numbersString) {
        String[] numberStrings = numbersString.trim().split("\\s+");
        List<Integer> integerList = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString);
            integerList.add(number);
        }

        return integerList;
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
