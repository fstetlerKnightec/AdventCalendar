package org.advent.daytwo;

public class Game {
    private int maxNumberOfGreenNeeded;
    private int maxNumberOfBlueNeeded;
    private int maxNumberOfRedNeeded;
    private final int gameIndex;

    public Game(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public boolean canGameBePlayedWithFollowingBalls(int allowedGreen, int allowedBlue, int allowedRed) {
        return getMaxNumberOfGreenNeeded() <= allowedGreen && getMaxNumberOfBlueNeeded() <= allowedBlue && getMaxNumberOfRedNeeded() <= allowedRed;
    }

    public void maxNumberOfBall(Round currentRound, String color) {
        if (color.equals("blue")) {
            if (getMaxNumberOfBlueNeeded() < currentRound.getNumberOfBlue()) {
                setMaxNumberOfBlueNeeded(currentRound.getNumberOfBlue());
            }
        }
        if (color.equals("green")) {
            if (getMaxNumberOfGreenNeeded() < currentRound.getNumberOfGreen()) {
                setMaxNumberOfGreenNeeded(currentRound.getNumberOfGreen());
            }
        }
        if (color.equals("red")) {
            if (getMaxNumberOfRedNeeded() < currentRound.getNumberOfRed()) {
                setMaxNumberOfRedNeeded(currentRound.getNumberOfRed());
            }
        }
    }

    public void setMaxNumberOfGreenNeeded(int maxNumberOfGreenNeeded) {
        this.maxNumberOfGreenNeeded = maxNumberOfGreenNeeded;
    }

    public void setMaxNumberOfBlueNeeded(int maxNumberOfBlueNeeded) {
        this.maxNumberOfBlueNeeded = maxNumberOfBlueNeeded;
    }

    public void setMaxNumberOfRedNeeded(int maxNumberOfRedNeeded) {
        this.maxNumberOfRedNeeded = maxNumberOfRedNeeded;
    }

    public int getGameIndex() {
        return gameIndex;
    }

    public int getMaxNumberOfGreenNeeded() {
        return maxNumberOfGreenNeeded;
    }

    public int getMaxNumberOfBlueNeeded() {
        return maxNumberOfBlueNeeded;
    }

    public int getMaxNumberOfRedNeeded() {
        return maxNumberOfRedNeeded;
    }

}
