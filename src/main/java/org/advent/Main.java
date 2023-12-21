package org.advent;

import org.advent.dayone.DayOne;
import org.advent.daythree.DayThree;
import org.advent.daythree.Number;
import org.advent.daytwo.DayTwo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        Util util = new Util();

        // DAY ONE OUTPUT
        DayOne dayOne = new DayOne();
        List<String> listOfStrings = util.readStringsFromFile(Paths.get("src/main/resources/dayOne.txt").toString());
        List<String> listOfFirstNumbersFromLeft = listOfStrings.stream()
                .map(s -> dayOne.returnFirstNumberFromString(String.valueOf(s), false, true)).toList();
        List<String> listOfFirstNumbersFromRight = listOfStrings.stream()
                .map(s -> dayOne.returnFirstNumberFromString(String.valueOf(s), true, true)).toList();
        List<String> listOfFirstNumbersFromLeft2 = listOfStrings.stream()
                .map(s -> dayOne.returnFirstNumberFromString(String.valueOf(s), false, false)).toList();
        List<String> listOfFirstNumbersFromRight2 = listOfStrings.stream()
                .map(s -> dayOne.returnFirstNumberFromString(String.valueOf(s), true, false)).toList();
        List<String> listOfCombinedNumbersFromLeftAndRight =
                IntStream.range(0, listOfFirstNumbersFromLeft.size())
                        .mapToObj(i -> listOfFirstNumbersFromLeft.get(i) + listOfFirstNumbersFromRight.get(i)).toList();
        List<String> listOfCombinedNumbersFromLeftAndRight2 =
                IntStream.range(0, listOfFirstNumbersFromLeft.size())
                        .mapToObj(i -> listOfFirstNumbersFromLeft2.get(i) + listOfFirstNumbersFromRight2.get(i)).toList();

        int totalSum = dayOne.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight);
        int totalSum2 = dayOne.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight2);
        System.out.println("Day One ----------------------------------");
        System.out.println("Total sum of all values in list = " + totalSum);
        System.out.println("Total sum of all numbers, even the text ones, in list = " + totalSum2);

        // DAY TWO OUTPUT
        DayTwo dayTwo = new DayTwo();
        List<String> listOfGames = util.readStringsFromFile(Paths.get("src/main/resources/dayTwo.txt").toString());
        System.out.println(" ");
        System.out.println("Day Two ----------------------------------");
        System.out.println("Sum of all valid IDs for day two = " + dayTwo.sumOfAllValidIDs(listOfGames, 13, 14, 12));
        System.out.println("Total power of all games for day two = " + dayTwo.totalPowerOfAllGames(listOfGames));

        // DAY THREE OUTPUT
        DayThree dayThree = new DayThree();
        List<String> readList = util.readStringsFromFile(Paths.get("src/main/resources/dayThree.txt").toString());
        List<String> list3 = dayThree.addCushionLinesAndColumnsOnStringsInList(readList);
        List<Number> listOfAllNumbers = dayThree.listOfAllNumbers(list3);
        dayThree.setAdjacentToSymbolForNumber(listOfAllNumbers, list3);

        System.out.println(" ");
        System.out.println("Day Three ----------------------------------");
        System.out.println("Total value of numbers adjacent to symbol = " + dayThree.getTotalAddedNumbersAdjacentToSymbol(listOfAllNumbers));
        System.out.println("TotalValue for two values adjacent to a star = " + dayThree.calculateTotalValueOfAllAdjacentValuesToStar(listOfAllNumbers));


    }
}