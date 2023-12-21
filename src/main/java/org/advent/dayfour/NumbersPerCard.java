package org.advent.dayfour;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NumbersPerCard {
    private List<Integer> numbersYouHave;
    private List<Integer> winningNumbers;
    private int matchingNumbers;
    private int numberOfTotalCards;

    public NumbersPerCard(List<Integer> listOfWinningNumbers, List<Integer> listOfNumbersYouHave) {
        this.setWinningNumbers(listOfWinningNumbers);
        this.setNumbersYouHave(listOfNumbersYouHave);
    }

    public int totalNumberOfMatchingNumbersPerCard() {
        AtomicInteger numbersOfMatchingNumbers = new AtomicInteger();
        getWinningNumbers().forEach(wn -> { if (getNumbersYouHave().contains(wn)) {numbersOfMatchingNumbers.addAndGet(1);}});
        return numbersOfMatchingNumbers.get();

    }

    public int exponentialSumOfNumbersMatchingBetweenOnHandAndWinningPerGame() {
        return (int) Math.pow(2, totalNumberOfMatchingNumbersPerCard() - 1);
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