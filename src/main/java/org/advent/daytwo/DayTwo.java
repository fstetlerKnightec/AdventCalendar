package org.advent.daytwo;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwo implements PrintSolution {

    public String getCutString(String currentGame) {
        return " " + currentGame.substring(currentGame.indexOf(": ") + 2);
    }
    public List<Round> getListOfRoundsFromCurrentGame(String currentGame, int gameIndex) {

        String cutString = getCutString(currentGame);
        List<String> listOfStringsForGame = new ArrayList<>(Arrays.asList(cutString.split(";")));
        List<Round> listOfRounds = new ArrayList<>();

        for (int i = 0; i < listOfStringsForGame.size(); i++) {
            String roundString = listOfStringsForGame.get(i);
            Round round = new Round(
                    roundString,
                    i,
                    gameIndex,
                    getNumberOfBall(roundString, "green"),
                    getNumberOfBall(roundString, "red"),
                    getNumberOfBall(roundString, "blue"));
            listOfRounds.add(round);
        }
        return listOfRounds;
    }

    public int sumOfAllValidIDs(List<String> gameStrings, int allowedGreen, int allowedBlue, int allowedRed) {
        int totalSum = 0;

        List<Game> gameObjects = getListOfAllGames(gameStrings);

        for (Game gameObject : gameObjects) {
            if (gameObject.canGameBePlayedWithFollowingBalls(allowedGreen, allowedBlue, allowedRed)) {
                totalSum += gameObject.getGameIndex() + 1;
            }
        }
        return totalSum;
    }

    public int totalPowerOfAllGames(List<String> gameStrings) {
        int totalPower = 0;

        List<Game> gameObjects = getListOfAllGames(gameStrings);

        for (Game gameObject : gameObjects) {
            totalPower += gameObject.getMaxNumberOfBlueNeeded() * gameObject.getMaxNumberOfRedNeeded() * gameObject.getMaxNumberOfGreenNeeded();
        }
        return totalPower;

    }

    public List<Game> getListOfAllGames(List<String> listOfGamesAsStrings) {
        List<Game> listOfGamesAsObjects = new ArrayList<>();
        for (int i = 0; i < listOfGamesAsStrings.size(); i++) {
            listOfGamesAsObjects.add(getGameObjectFromGameString(listOfGamesAsStrings.get(i), i));
        }

        return listOfGamesAsObjects;
    }

    public Game getGameObjectFromGameString(String currentGameAsString, int index) {

        List<Round> rounds = getListOfRoundsFromCurrentGame(currentGameAsString, index);
        Game game = new Game(index);

        for (Round round : rounds) {
            game.maxNumberOfBall(round, "green");
            game.maxNumberOfBall(round, "blue");
            game.maxNumberOfBall(round, "red");
        }
        return game;
    }


    public static int getNumberOfBall(String currentRound, String color) {
        for (int i = 0; i < currentRound.length(); i++) {
            if (currentRound.startsWith(color, i)) {
                if (characterAtIndexNotBlank(currentRound, i)) {
                    return 10 * convertCharacterAtIndexToInt(currentRound, i, 3) + convertCharacterAtIndexToInt(currentRound, i, 2);
                } else {
                    return convertCharacterAtIndexToInt(currentRound, i, 2);
                }
            }
        }
        return 0;
    }

    public static boolean characterAtIndexNotBlank(String currentGame, int index) {
        return !String.valueOf(currentGame.charAt(index - 3)).isBlank();
    }

    public static int convertCharacterAtIndexToInt(String currentGame, int index, int offset) {
        return Integer.parseInt(String.valueOf(currentGame.charAt(index - offset)));
    }

    public int results(boolean isPartOne) throws IOException {
        List<String> listOfGames = Util.readStringsFromFile(Paths.get("src/main/resources/dayTwo.txt").toString());
        if (isPartOne) {
            return sumOfAllValidIDs(listOfGames, 13, 14, 12);
        }
        return totalPowerOfAllGames(listOfGames);
    }

    @Override
    public void printPartOne() throws IOException {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Sum of all valid IDs for day two = " + results(true));

    }

    @Override
    public void printPartTwo() throws IOException {
        System.out.println("Total power of all games for day two = " + results(false));
    }

}
