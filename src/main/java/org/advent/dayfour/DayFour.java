package org.advent.dayfour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayFour {

    public void setMatchingNumberPerCard(List<NumbersPerCard> listOfNumbersPerCard) {
        for (NumbersPerCard numbersPerCard : listOfNumbersPerCard) {
            int matchingNumber = totalNumberOfMatchingNumbersPerCard(numbersPerCard);
            numbersPerCard.setMatchingNumbers(matchingNumber);
        }
    }

    public void setNumberOfTotalPerCard(List<NumbersPerCard> listOfNumbersPerCard) {
        for (NumbersPerCard numbersPerCard : listOfNumbersPerCard) {
            numbersPerCard.addNumberOfTotalCards(1);
        }
        for (int i = 0; i < listOfNumbersPerCard.size(); i++) {
            for (int j = i + 1; j <= i + listOfNumbersPerCard.get(i).getMatchingNumbers(); j++) {
                int numberOfTotalCards = listOfNumbersPerCard.get(i).getNumberOfTotalCards();
                listOfNumbersPerCard.get(j).addNumberOfTotalCards(numberOfTotalCards);
            }
        }
    }

    public int totalSumOfNumbersOfTotalPerCard(List<NumbersPerCard> listOfNumbersPerCard) {
        int totalSum = 0;
        for (NumbersPerCard numbersPerCard : listOfNumbersPerCard) {
            totalSum += numbersPerCard.getNumberOfTotalCards();
        }
        return totalSum;
    }

    public int totalSumOfAllExponentialValues(List<NumbersPerCard> listOfNumbersPerCard) {
        int totalValue = 0;
        for (NumbersPerCard numbersPerCard : listOfNumbersPerCard) {
            totalValue += exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame(numbersPerCard);
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

    public List<String> removeFrontPartOfStringAndReturnList(List<String> stringList) {
        return stringList.stream().map(s -> s.replaceAll(".*:", "")).toList();
    }

    private int exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame(NumbersPerCard numbersPerCard) {
        return (int) Math.pow(2, totalNumberOfMatchingNumbersPerCard(numbersPerCard) - 1);
    }

    private int totalNumberOfMatchingNumbersPerCard(NumbersPerCard numbersPerCard) {
        int numberOfMatchingNumbers = 0;
        for (int i = 0; i < numbersPerCard.getWinningNumbers().size(); i++) {
            for (int j = 0; j < numbersPerCard.getNumbersYouHave().size(); j++) {
                Integer currentWinningNumber = numbersPerCard.getWinningNumbers().get(i);
                Integer currentNumberYouHave = numbersPerCard.getNumbersYouHave().get(j);
                if (currentWinningNumber.equals(currentNumberYouHave)) {
                    numberOfMatchingNumbers += 1;
                }
            }
        }
        return numberOfMatchingNumbers;
    }

    private NumbersPerCard numbersPerCard(String cutString) {
        NumbersPerCard numbers = new NumbersPerCard();

        String winningString = cutString.split("\\|")[0];
        String numbersYouHaveString = cutString.split("\\|")[1];
        List<Integer> listOfWinningNumbers = listOfNumbers(winningString);
        List<Integer> listOfNumbersYouHave = listOfNumbers(numbersYouHaveString);
        numbers.setWinningNumbers(listOfWinningNumbers);
        numbers.setNumbersYouHave(listOfNumbersYouHave);

        return numbers;
    }

    private List<Integer> listOfNumbers(String numbersString) {
        String[] numberStrings = numbersString.trim().split("\\s+");
        List<Integer> integerList = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString);
            integerList.add(number);
        }

        return integerList;
    }
}
