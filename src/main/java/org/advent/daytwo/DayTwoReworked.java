package org.advent.daytwo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwoReworked {

    public String getCutString(String currentGame) {
        return " " + currentGame.substring(currentGame.indexOf(": ") + 2);
    }
    public List<Round> getListOfRoundsFromCurrentGame(String currentGame, int gameIndex) {

        Round round;
        String cutString = getCutString(currentGame);
        List<String> listOfStringsForGame = new ArrayList<>(Arrays.asList(cutString.split(";")));
        String roundString;
        List<Round> listOfRounds = new ArrayList<>();

        for (int i = 0; i < listOfStringsForGame.size(); i++) {
            roundString = listOfStringsForGame.get(i);
            round = new Round(
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

        for (int i = 0; i < gameObjects.size(); i++) {
            if (gameObjects.get(i).canGameBePlayedWithFollowingBalls(allowedGreen, allowedBlue, allowedRed)) {
                totalSum += gameObjects.get(i).gameIndex + 1;
            }
        }
        return totalSum;
    }

    public int totalPowerOfAllGames(List<String> gameStrings) {
        int totalPower = 0;

        List<Game> gameObjects = getListOfAllGames(gameStrings);

        for (int i = 0; i < gameObjects.size(); i++) {
            totalPower += gameObjects.get(i).getMaxNumberOfBlueNeeded() * gameObjects.get(i).getMaxNumberOfRedNeeded() * gameObjects.get(i).getMaxNumberOfGreenNeeded();
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
        Game game = new Game(index, rounds);
        game.setGameString(currentGameAsString);

        int totalBlue = 0;
        int totalGreen = 0;
        int totalRed = 0;
        Round currentRound;
        for (int i = 0; i < rounds.size(); i++) {
            currentRound = rounds.get(i);
            totalBlue += currentRound.getNumberOfBlue();
            totalGreen += currentRound.getNumberOfGreen();
            totalRed += currentRound.getNumberOfRed();


            game.maxNumberOfBall(currentRound, "green");
            game.maxNumberOfBall(currentRound, "blue");
            game.maxNumberOfBall(currentRound, "red");
        }

        game.setTotalNumberOfBlue(totalBlue);
        game.setTotalNumberOfGreen(totalGreen);
        game.setTotalNumberOfRed(totalRed);
        game.setNumberOfRounds(rounds.size());

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

    public List<String> readGamesFromFileAndPutInList(String filePath) throws FileNotFoundException {
        List<String> sentences;
        try {
            Path path = Paths.get(filePath);
            sentences = Files.readAllLines(path);
        } catch (IOException e) {
            throw new FileNotFoundException("Could not find a file under path " + filePath);
        }

        return sentences;
    }

    public static boolean characterAtIndexNotBlank(String currentGame, int index) {
        return !String.valueOf(currentGame.charAt(index - 3)).isBlank();
    }

    public static int convertCharacterAtIndexToInt(String currentGame, int index, int offset) {
        return Integer.parseInt(String.valueOf(currentGame.charAt(index - offset)));
    }

}
