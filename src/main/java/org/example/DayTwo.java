package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DayTwo {
    public static Integer ALLOWED_RED = 12;
    public static Integer ALLOWED_GREEN = 13;
    public static Integer ALLOWED_BLUE = 14;
    List<String> listOfGames = readSentencesFromFile("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayTwo.txt");

    public Integer numberOfAllAddedGames() {
        int totalGameNumber = 0;
        for (int i = 0; i < listOfGames.size(); i++) {
            if (isAllowedGame(listOfGames.get(i))) {
                totalGameNumber += (i+1);
            }
        }
        return totalGameNumber;
    }

    public boolean isAllowedGame(String currentGame) {

        currentGame = currentGame + ";";
        System.out.println(currentGame);
        int totalRedPerGame = 0;
        int totalBluePerGame = 0;
        int totalGreenPerGame = 0;

        boolean allowedGame = true;

        for (int i = 0; i < currentGame.length(); i++) {

            if (currentGame.startsWith("green", i)) {
                totalGreenPerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 2)));
                if (!String.valueOf(currentGame.charAt(i - 3)).isBlank()) {
                    totalGreenPerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 3))) * 10;
                }
            }
            if (currentGame.startsWith("red", i)) {
                totalRedPerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 2)));
                if (!String.valueOf(currentGame.charAt(i - 3)).isBlank()) {
                    totalRedPerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 3))) * 10;
                }
            }
            if (currentGame.startsWith("blue", i)) {
                totalBluePerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 2)));
                if (!String.valueOf(currentGame.charAt(i - 3)).isBlank()) {
                    totalBluePerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 3))) * 10;
                }
            }

            if (String.valueOf(currentGame.charAt(i)).equals(";")) {
                if (totalGreenPerGame > ALLOWED_GREEN || totalBluePerGame > ALLOWED_BLUE || totalRedPerGame > ALLOWED_RED) {
                    allowedGame = false;
                }
                totalRedPerGame = 0;
                totalBluePerGame = 0;
                totalGreenPerGame = 0;
            }
        }
        return allowedGame;
    }

    private static List<String> readSentencesFromFile(String filePath) {
        List<String> sentences = null;
        try {
            Path path = Paths.get(filePath);
            sentences = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentences;
    }
}
