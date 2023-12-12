package org.advent.daytwo;

public class Round {

    public String roundString;
    public int roundNumber;
    public int gameNumber;
    public int numberOfGreen;
    public int numberOfRed;
    public int numberOfBlue;

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }


    public Round(int numberOfRed, int numberOfBlue, int numberOfGreen) {
        this.numberOfRed = numberOfRed;
        this.numberOfBlue = numberOfBlue;
        this.numberOfGreen = numberOfGreen;
    }

    public Round() {

    }

    public String getRoundString() {
        return roundString;
    }

    public void setRoundString(String roundString) {
        this.roundString = roundString;
    }

    public int getNumberOfRed() {
        return numberOfRed;
    }

    public void setNumberOfRed(int numberOfRed) {
        this.numberOfRed = numberOfRed;
    }

    public int getNumberOfBlue() {
        return numberOfBlue;
    }

    public void setNumberOfBlue(int numberOfBlue) {
        this.numberOfBlue = numberOfBlue;
    }

    public int getNumberOfGreen() {
        return numberOfGreen;
    }

    public void setNumberOfGreen(int numberOfGreen) {
        this.numberOfGreen = numberOfGreen;
    }


}
