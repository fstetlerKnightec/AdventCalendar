package org.advent.daytwo;

import java.util.List;

public class Game {
    public int numberOfRounds;
    public String gameString;

    public int totalNumberOfRed;

    public int totalNumberOfGreen;
    public int totalNumberOfBlue;
    public int maxNumberOfGreenNeeded;
    public int maxNumberOfBlueNeeded;
    public int maxNumberOfRedNeeded;
    public int gameIndex;
    public List<Round> listOfRoundsInGame;
    public Game(int gameIndex, List<Round> listOfRoundsInGame) {
        this.gameIndex = gameIndex;
        this.listOfRoundsInGame = listOfRoundsInGame;
    }

    public Game(int numberOfRed, int numberOfGreen, int numberOfBlue, int maxNumberOfGreenNeeded, int maxNumberOfBlueNeeded, int maxNumberOfRedNeeded, int numberOfRounds) {
        this.totalNumberOfRed = numberOfRed;
        this.totalNumberOfGreen = numberOfGreen;
        this.totalNumberOfBlue = numberOfBlue;
        this.maxNumberOfGreenNeeded = maxNumberOfGreenNeeded;
        this.maxNumberOfBlueNeeded = maxNumberOfBlueNeeded;
        this.maxNumberOfRedNeeded = maxNumberOfRedNeeded;
        this.numberOfRounds = numberOfRounds;
    }

    public boolean canGameBePlayedWithFollowingBalls(int allowedGreen, int allowedBlue, int allowedRed) {
        return maxNumberOfGreenNeeded <= allowedGreen && maxNumberOfBlueNeeded <= allowedBlue && maxNumberOfRedNeeded <= allowedRed;
    }

    public void maxNumberOfBall(Round currentRound, String color) {
        if (color.equals("blue")) {
            if (getMaxNumberOfBlueNeeded() < currentRound.getNumberOfBlue()) {
                this.maxNumberOfBlueNeeded = currentRound.getNumberOfBlue();
            }
        }
        if (color.equals("green")) {
            if (getMaxNumberOfGreenNeeded() < currentRound.getNumberOfGreen()) {
                this.maxNumberOfGreenNeeded = currentRound.getNumberOfGreen();
            }
        }
        if (color.equals("red")) {
            if (getMaxNumberOfRedNeeded() < currentRound.getNumberOfRed()) {
                this.maxNumberOfRedNeeded = currentRound.getNumberOfRed();
            }
        }
    }

    public String getGameString() {
        return gameString;
    }

    public void setGameString(String gameString) {
        this.gameString = gameString;
    }

    public List<Round> getListOfRoundsInGame() {
        return listOfRoundsInGame;
    }

    public void setListOfRoundsInGame(List<Round> listOfRoundsInGame) {
        this.listOfRoundsInGame = listOfRoundsInGame;
    }

    public int getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public int getMaxNumberOfGreenNeeded() {
        return maxNumberOfGreenNeeded;
    }

    public void setMaxNumberOfGreenNeeded(int maxNumberOfGreenNeeded) {
        this.maxNumberOfGreenNeeded = maxNumberOfGreenNeeded;
    }

    public int getMaxNumberOfBlueNeeded() {
        return maxNumberOfBlueNeeded;
    }

    public void setMaxNumberOfBlueNeeded(int maxNumberOfBlueNeeded) {
        this.maxNumberOfBlueNeeded = maxNumberOfBlueNeeded;
    }

    public int getMaxNumberOfRedNeeded() {
        return maxNumberOfRedNeeded;
    }
    public void setMaxNumberOfRedNeeded(int maxNumberOfRedNeeded) {
        this.maxNumberOfRedNeeded = maxNumberOfRedNeeded;
    }

    public int getTotalNumberOfRed() {
        return totalNumberOfRed;
    }

    public void setTotalNumberOfRed(int totalNumberOfRed) {
        this.totalNumberOfRed = totalNumberOfRed;
    }

    public int getTotalNumberOfGreen() {
        return totalNumberOfGreen;
    }

    public void setTotalNumberOfGreen(int totalNumberOfGreen) {
        this.totalNumberOfGreen = totalNumberOfGreen;
    }

    public int getTotalNumberOfBlue() {
        return totalNumberOfBlue;
    }

    public void setTotalNumberOfBlue(int totalNumberOfBlue) {
        this.totalNumberOfBlue = totalNumberOfBlue;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }
}
