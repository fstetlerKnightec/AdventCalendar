package org.advent.daytwo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DayTwoClean {

    public final static Integer ALLOWED_RED = 12;
    public final static Integer ALLOWED_GREEN = 13;
    public final static Integer ALLOWED_BLUE = 14;

    public Integer sumOfAllIDsFromAllowedGames(List<String> listOfGames) {

        int totalSumOfIndexFromAllowedGames = 0;

        for (int i = 0; i < listOfGames.size(); i++) {
            if (isAllowedGame(listOfGames.get(i))) {
                totalSumOfIndexFromAllowedGames += i+1;
            }
        }
        return totalSumOfIndexFromAllowedGames;
    }

    public Integer powerOfCurrentGame(String currentGame) {

        int totalRedPerGame = 0;
        int totalBluePerGame = 0;
        int totalGreenPerGame = 0;

        int maxRedPerGame = 0;
        int maxBluePerGame = 0;
        int maxGreenPerGame = 0;

        for (int i = 0; i < currentGame.length(); i++) {
            maxGreenPerGame = maxNumberOfBallPerGame(currentGame, "green", i, totalGreenPerGame, maxGreenPerGame);
            maxRedPerGame = maxNumberOfBallPerGame(currentGame, "red", i, totalRedPerGame, maxRedPerGame);
            maxBluePerGame = maxNumberOfBallPerGame(currentGame, "blue", i, totalBluePerGame, maxBluePerGame);
        }

        return maxGreenPerGame * maxBluePerGame * maxRedPerGame;
    }

    public Integer maxNumberOfBallPerGame(String currentGame, String color, int index, int totalBallPerGame, int maxBallPerGame) {
        if (currentGame.startsWith(color, index)) {
            totalBallPerGame += Integer.parseInt(String.valueOf(currentGame.charAt(index - 2)));
            if (!String.valueOf(currentGame.charAt(index - 3)).isBlank()) {
                totalBallPerGame += Integer.parseInt(String.valueOf(currentGame.charAt(index - 3))) * 10;
            }

            if (totalBallPerGame > maxBallPerGame) {
                maxBallPerGame = totalBallPerGame;
            }
        }
        return maxBallPerGame;
    }

    public static boolean isAllowedGame(String currentGame) {
        int numberOfGreenBalls = 0;
        int numberOfBlueBalls = 0;
        int numberOfRedBalls = 0;


        for (int i = 0; i < currentGame.length(); i++) {
            if (String.valueOf(currentGame.charAt(i)).equals(";")) {
                if (numberOfGreenBalls > ALLOWED_GREEN || numberOfBlueBalls > ALLOWED_BLUE || numberOfRedBalls > ALLOWED_RED) {
                    return false;
                }
                numberOfGreenBalls = 0;
                numberOfRedBalls = 0;
                numberOfBlueBalls = 0;
            }

            numberOfGreenBalls += numberOfBallsPerHand(currentGame, "green", i);
            numberOfBlueBalls += numberOfBallsPerHand(currentGame, "blue", i);
            numberOfRedBalls += numberOfBallsPerHand(currentGame, "red", i);
        }

        return true;
    }

    public List<String> readGamesFromFileAndPutInList(String filePath) throws FileNotFoundException {
        List<String> sentences;
        try {
            Path path = Paths.get(filePath);
            sentences = Files.readAllLines(path);
        } catch (IOException e) {
            throw new FileNotFoundException("Could not find a file under path " + filePath);
        }

        return sentences.stream().map(s -> s + ";").toList();
    }

    public static Integer numberOfBallsPerHand(String currentGame, String color, int index) { //Make an enum for color
        int totalBallsPerHand = 0;
        if (currentGame.startsWith(color, index)) {
            totalBallsPerHand += Integer.parseInt(String.valueOf(currentGame.charAt(index - 2)));
            if (!String.valueOf(currentGame.charAt(index - 3)).isBlank()) {
                totalBallsPerHand += Integer.parseInt(String.valueOf(currentGame.charAt(index - 3))) * 10;
            }
        }

        return totalBallsPerHand;
    }
}
