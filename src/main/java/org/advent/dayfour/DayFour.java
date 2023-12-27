package org.advent.dayfour;

import org.advent.PrintSolution;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DayFour implements PrintSolution {

    public int totalSumOfAllExponentialValues(List<NumbersPerCard> listOfNumbersPerCard) {
        return listOfNumbersPerCard.stream().mapToInt(NumbersPerCard::exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame).sum();
    }

    public void setMatchingNumberPerCard(List<NumbersPerCard> listOfNumbersPerCard) {
        listOfNumbersPerCard.forEach(n -> n.setMatchingNumbers(n.totalNumberOfMatchingNumbersPerCard()));
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
        return listOfNumbersPerCard.stream().mapToInt(NumbersPerCard::getNumberOfTotalCards).sum();
    }

    public List<NumbersPerCard> listOfAllNumbersPerCard(List<String> listOfCutStrings) {
        return listOfCutStrings.stream().map(this::numbersPerCard).collect(Collectors.toList());
    }

    public List<String> removeFrontPartOfStringAndReturnList(List<String> stringList) {
        return stringList.stream().map(s -> s.replaceAll(".*:", "")).toList();
    }

    private NumbersPerCard numbersPerCard(String cutString) {
        String winningString = cutString.split("\\|")[0];
        String numbersYouHaveString = cutString.split("\\|")[1];
        return new NumbersPerCard(listOfNumbers(winningString), listOfNumbers(numbersYouHaveString));
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

    @Override
    public void printPartOne(int result) {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total value of all exponential values is = " + result);
    }

    @Override
    public void printPartTwo(int result) {
        System.out.println("Total sum of all added extra cards are = " + result);
    }
}