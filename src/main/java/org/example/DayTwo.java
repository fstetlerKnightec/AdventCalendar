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


    public Integer totalSumOfPowerValues(List<String> listOfGames) {

        int totalValue = 0;
        for (int i = 0; i < listOfGames.size(); i++) {
            totalValue += powerOfCurrentGame(listOfGames.get(i));
        }
        return totalValue;
    }

//    public Integer numberOfAllAddedGames() {
//        int totalGameNumber = 0;
//        for (int i = 0; i < listOfGames.size(); i++) {
//            if (isAllowedGame(listOfGames.get(i))) {
//                totalGameNumber += (i+1);
//            }
//        }
//        return totalGameNumber;
//    }

    public Integer powerOfCurrentGame(String currentGame) {

        currentGame = currentGame + ";";
        System.out.println(currentGame);
        int totalRedPerGame = 0;
        int totalBluePerGame = 0;
        int totalGreenPerGame = 0;

        int maxRedPerGame = 0;
        int maxBluePerGame = 0;
        int maxGreenPerGame = 0;

        boolean allowedGame = true;

        for (int i = 0; i < currentGame.length(); i++) {

            if (currentGame.startsWith("green", i)) {
                totalGreenPerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 2)));
                if (!String.valueOf(currentGame.charAt(i - 3)).isBlank()) {
                    totalGreenPerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 3))) * 10;
                }

                if (totalGreenPerGame > maxGreenPerGame) {
                    maxGreenPerGame = totalGreenPerGame;
                }
            }
            if (currentGame.startsWith("red", i)) {
                totalRedPerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 2)));
                if (!String.valueOf(currentGame.charAt(i - 3)).isBlank()) {
                    totalRedPerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 3))) * 10;
                }
                if (totalRedPerGame > maxRedPerGame) {
                    maxRedPerGame = totalRedPerGame;
                }
            }
            if (currentGame.startsWith("blue", i)) {
                totalBluePerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 2)));
                if (!String.valueOf(currentGame.charAt(i - 3)).isBlank()) {
                    totalBluePerGame += Integer.parseInt(String.valueOf(currentGame.charAt(i - 3))) * 10;
                }
                if (totalBluePerGame > maxBluePerGame) {
                    maxBluePerGame = totalBluePerGame;
                }
            }

            if (String.valueOf(currentGame.charAt(i)).equals(";")) {
                totalRedPerGame = 0;
                totalBluePerGame = 0;
                totalGreenPerGame = 0;
            }

        }
        System.out.println("maxgreenpergame = " + maxGreenPerGame);
        System.out.println("maxredpergame = " + maxRedPerGame);
        System.out.println("maxbluepergame = " + maxBluePerGame);



        int powerValue = maxGreenPerGame * maxBluePerGame * maxRedPerGame;

        System.out.println("powered value = " + powerValue);
        return powerValue;
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
