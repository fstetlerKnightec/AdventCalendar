package org.advent.daySeven;

public class Hand {

    String card;
    int bid;
    Type type;
    int firstCardValue;
    int secondCardValue;
    int thirdCardValue;
    int fourthCardValue;
    int fifthCardValue;
    int rank;

    public Hand(Type type, int firstCardValue, int secondCardValue, int thirdCardValue, int fourthCardValue, int fifthCardValue, int rank) {
        this.type = type;
        this.firstCardValue = firstCardValue;
        this.secondCardValue = secondCardValue;
        this.thirdCardValue = thirdCardValue;
        this.fourthCardValue = fourthCardValue;
        this.fifthCardValue = fifthCardValue;
        this.rank = rank;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getFirstCardValue() {
        return firstCardValue;
    }

    public void setFirstCardValue(int firstCardValue) {
        this.firstCardValue = firstCardValue;
    }

    public int getSecondCardValue() {
        return secondCardValue;
    }

    public void setSecondCardValue(int secondCardValue) {
        this.secondCardValue = secondCardValue;
    }

    public int getThirdCardValue() {
        return thirdCardValue;
    }

    public void setThirdCardValue(int thirdCardValue) {
        this.thirdCardValue = thirdCardValue;
    }

    public int getFourthCardValue() {
        return fourthCardValue;
    }

    public void setFourthCardValue(int fourthCardValue) {
        this.fourthCardValue = fourthCardValue;
    }

    public int getFifthCardValue() {
        return fifthCardValue;
    }

    public void setFifthCardValue(int fifthCardValue) {
        this.fifthCardValue = fifthCardValue;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
