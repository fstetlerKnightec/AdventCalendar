package org.example;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // DAY ONE OUTPUT
        DayOneClean dayOneClean = new DayOneClean();

        List<String> listOfStrings = dayOneClean.readFileAndReturnList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayOne.txt");

        List<String> listOfFirstNumbersFromLeft = listOfStrings.stream()
                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), false, true)).toList();
        List<String> listOfFirstNumbersFromRight = listOfStrings.stream()
                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), true, true)).toList();


        List<String> listOfCombinedNumbersFromLeftAndRight =
                IntStream.range(0, listOfFirstNumbersFromLeft.size())
                        .mapToObj(i -> listOfFirstNumbersFromLeft.get(i) + listOfFirstNumbersFromRight.get(i)).toList();

        int totalSum = dayOneClean.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight);
        System.out.println("Total sum of all values in list for day one = " + totalSum);


        // DAY TWO OUTPUT
        DayTwoClean dayTwoClean = new DayTwoClean();

        List<String> listOfGames = dayTwoClean.readGamesFromFileAndPutInList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayTwo.txt");

        System.out.println("Total sum of all acceptable IDs from day two = " + dayTwoClean.sumOfAllIDsFromAllowedGames(listOfGames));

        int totalValue = 0;
        for (String s : listOfGames) {
            totalValue += dayTwoClean.powerOfCurrentGame(s);
        }
        System.out.println("Total value of all powered values from day two = " + totalValue);



    }
}