package org.advent.dayfour;

import java.util.List;

public class NumbersPerCard {
    private List<Integer> numbersYouHave;
    private List<Integer> winningNumbers;

    public NumbersPerCard(List<Integer> winningNumbers, List<Integer> numbersYouHave) {
        this.winningNumbers = winningNumbers;
        this.numbersYouHave = numbersYouHave;
    }

    public NumbersPerCard() {
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
