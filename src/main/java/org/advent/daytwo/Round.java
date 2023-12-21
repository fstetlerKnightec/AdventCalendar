package org.advent.daytwo;

public class Round {
    public String roundString;
    public int roundNumber;
    public int gameNumber;
    public int numberOfGreen;
    public int numberOfRed;
    public int numberOfBlue;

    public Round(String roundString, int roundNumber, int gameNumber, int numberOfGreen, int numberOfRed, int numberOfBlue) {
        this.roundString = roundString;
        this.roundNumber = roundNumber;
        this.gameNumber = gameNumber;
        this.numberOfGreen = numberOfGreen;
        this.numberOfRed = numberOfRed;
        this.numberOfBlue = numberOfBlue;
    }

    public int getNumberOfRed() {
        return numberOfRed;
    }

    public int getNumberOfBlue() {
        return numberOfBlue;
    }

    public int getNumberOfGreen() {
        return numberOfGreen;
    }


}
