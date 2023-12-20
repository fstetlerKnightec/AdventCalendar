package org.advent.dayfour;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DayFour {

    public void setMatchingNumberPerCard(List<NumbersPerCard> listOfNumbersPerCard) {
        listOfNumbersPerCard.forEach(n -> n.setMatchingNumbers(totalNumberOfMatchingNumbersPerCard(n)));
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
        AtomicInteger totalSum = new AtomicInteger();
        listOfNumbersPerCard.forEach(n -> totalSum.addAndGet(n.getNumberOfTotalCards()));
        return totalSum.get();
    }

    public int totalSumOfAllExponentialValues(List<NumbersPerCard> listOfNumbersPerCard) {
        AtomicInteger totalValue = new AtomicInteger();
        listOfNumbersPerCard.forEach(n -> totalValue.addAndGet(exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame(n)));
        return totalValue.get();
    }

    public List<NumbersPerCard> listOfAllNumbersPerCard(List<String> listOfCutStrings) {
        List<NumbersPerCard> listOfNumbersPerCard= new ArrayList<>();
        listOfCutStrings.forEach(s -> listOfNumbersPerCard.add(numbersPerCard(s)));
        return listOfNumbersPerCard;
    }

    public List<String> removeFrontPartOfStringAndReturnList(List<String> stringList) {
        return stringList.stream().map(s -> s.replaceAll(".*:", "")).toList();
    }

    private int exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame(NumbersPerCard numbersPerCard) {
        return (int) Math.pow(2, totalNumberOfMatchingNumbersPerCard(numbersPerCard) - 1);
    }

    private int totalNumberOfMatchingNumbersPerCard(NumbersPerCard numbersPerCard) {
        AtomicInteger numbersOfMatchingNumbers = new AtomicInteger();
        List<Integer> listOfWinning = numbersPerCard.getWinningNumbers();
        List<Integer> listOfNumbers = numbersPerCard.getNumbersYouHave();

        listOfWinning.forEach(wn -> { if (listOfNumbers.contains(wn)) {numbersOfMatchingNumbers.addAndGet(1);}});
        return numbersOfMatchingNumbers.get();

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
