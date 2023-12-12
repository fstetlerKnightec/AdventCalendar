package org.advent.daytwo;

public class Game {

    public int numberOfRed;

    public int numberOfGreen;

    public int numberOfBlue;

    public Game(int numberOfRed, int numberOfGreen, int numberOfBlue, int numberOfRounds) {
        this.numberOfRed = numberOfRed;
        this.numberOfGreen = numberOfGreen;
        this.numberOfBlue = numberOfBlue;
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfRed() {
        return numberOfRed;
    }

    public void setNumberOfRed(int numberOfRed) {
        this.numberOfRed = numberOfRed;
    }

    public int getNumberOfGreen() {
        return numberOfGreen;
    }

    public void setNumberOfGreen(int numberOfGreen) {
        this.numberOfGreen = numberOfGreen;
    }

    public int getNumberOfBlue() {
        return numberOfBlue;
    }

    public void setNumberOfBlue(int numberOfBlue) {
        this.numberOfBlue = numberOfBlue;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int numberOfRounds;
}
