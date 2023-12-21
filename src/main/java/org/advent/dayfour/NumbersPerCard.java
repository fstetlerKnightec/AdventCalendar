package org.advent.dayfour;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NumbersPerCard {
    private List<Integer> numbersYouHave;
    private List<Integer> winningNumbers;
    private int matchingNumbers;
    private int numberOfTotalCards;

    public int totalNumberOfMatchingNumbersPerCard(NumbersPerCard numbersPerCard) {
        AtomicInteger numbersOfMatchingNumbers = new AtomicInteger();
        List<Integer> listOfWinning = numbersPerCard.getWinningNumbers();
        List<Integer> listOfNumbers = numbersPerCard.getNumbersYouHave();

        listOfWinning.forEach(wn -> { if (listOfNumbers.contains(wn)) {numbersOfMatchingNumbers.addAndGet(1);}});
        return numbersOfMatchingNumbers.get();

    }

    public int exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame(NumbersPerCard numbersPerCard) {
        return (int) Math.pow(2, totalNumberOfMatchingNumbersPerCard(numbersPerCard) - 1);
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public void setMatchingNumbers(int matchingNumbers) {
        this.matchingNumbers = matchingNumbers;
    }

    public int getNumberOfTotalCards() {
        return numberOfTotalCards;
    }

    public void addNumberOfTotalCards(int numberOfTotalCards) {
        this.numberOfTotalCards += numberOfTotalCards;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getNumbersYouHave() {
        return numbersYouHave;
    }

    public void setNumbersYouHave(List<Integer> numbersYouHave) {
        this.numbersYouHave = numbersYouHave;
    }

}