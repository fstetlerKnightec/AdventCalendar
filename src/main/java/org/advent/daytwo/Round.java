package org.advent.daytwo;

public class Round {

    public int numberOfGreen;
    public int numberOfRed;
    public int numberOfBlue;

    public Round(int numberOfRed, int numberOfBlue, int numberOfGreen) {
        this.numberOfRed = numberOfRed;
        this.numberOfBlue = numberOfBlue;
        this.numberOfGreen = numberOfGreen;
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
