package org.example;

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


    public Integer maxNumberOfBallsPerGame(String currentGame, String color) {
        int maxBallsPerGame = 0;
        for (int i = 0; i < currentGame.length(); i++) {
            maxBallsPerGame += numberOfBallsPerHand(currentGame, color, i);
        }
        return maxBallsPerGame;
    }

    public Integer multiplyNumberOfEachColorBalls(int blueBallsPerGame, int redBallsPerGame, int greenBallsPerGame) {
        return blueBallsPerGame * redBallsPerGame * greenBallsPerGame;
    }




    public static boolean isAllowedGame(String currentGame) {
        int numberOfGreenBalls = 0;
        int numberOfBlueBalls = 0;
        int numberOfRedBalls = 0;

        boolean allowedGame = true;

        for (int i = 0; i < currentGame.length(); i++) {
            if (String.valueOf(currentGame.charAt(i)).equals(";")) {
                if (numberOfGreenBalls > ALLOWED_GREEN || numberOfBlueBalls > ALLOWED_BLUE || numberOfRedBalls > ALLOWED_RED) {
                    allowedGame = false;
                }
                numberOfGreenBalls = 0;
                numberOfRedBalls = 0;
                numberOfBlueBalls = 0;
            }

            numberOfGreenBalls += numberOfBallsPerHand(currentGame, "green", i);
            numberOfBlueBalls += numberOfBallsPerHand(currentGame, "blue", i);
            numberOfRedBalls += numberOfBallsPerHand(currentGame, "red", i);
        }

        return allowedGame;
    }

    public List<String> readGamesFromFileAndPutInList(String filePath) throws FileNotFoundException {
        List<String> sentences;
        try {
            Path path = Paths.get(filePath);
            sentences = Files.readAllLines(path);
        } catch (IOException e) {
            throw new FileNotFoundException("Could not find a file under path " + filePath);
        }

        List<String> sentecesWithAddedSemicolon = sentences.stream().map(s -> s + ";").toList();

        return sentecesWithAddedSemicolon;
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
