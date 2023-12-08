package org.example;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        DayTwoClean dayTwoClean = new DayTwoClean();

        List<String> listOfGames = dayTwoClean.readGamesFromFileAndPutInList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayTwo.txt");
        System.out.println(listOfGames.get(5));
        System.out.println(dayTwoClean.isAllowedGame(listOfGames.get(5)));

        System.out.println(dayTwoClean.sumOfAllIDsFromAllowedGames(listOfGames));



//        DayOneClean dayOneClean = new DayOneClean();
//        List<String> listOfStrings = dayOneClean.readFileAndReturnList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayOne.txt");
//
//        List<String> listOfFirstNumbersFromLeft = listOfStrings.stream()
//                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), false, true)).toList();
//        List<String> listOfFirstNumbersFromRight = listOfStrings.stream()
//                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), true, true)).toList();
//
//
//        List<String> listOfCombinedNumbersFromLeftAndRight =
//                IntStream.range(0, listOfFirstNumbersFromLeft.size())
//                        .mapToObj(i -> listOfFirstNumbersFromLeft.get(i) + listOfFirstNumbersFromRight.get(i)).toList();
//
//        int totalSum = dayOneClean.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight);
//        System.out.println(totalSum);

    }
}