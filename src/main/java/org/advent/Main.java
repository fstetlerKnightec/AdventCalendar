package org.advent;

import org.advent.day6.DaySix;
import org.advent.day6.TimeDistance;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Util util = new Util();

//        // DAY ONE OUTPUT
//        DayOne dayOne = new DayOne();
//        List<String> listOfStrings = util.readStringsFromFile("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayOne.txt");
//        List<String> listOfFirstNumbersFromLeft = listOfStrings.stream()
//                .map(s -> dayOne.returnFirstNumberFromString(String.valueOf(s), false, true)).toList();
//        List<String> listOfFirstNumbersFromRight = listOfStrings.stream()
//                .map(s -> dayOne.returnFirstNumberFromString(String.valueOf(s), true, true)).toList();
//        List<String> listOfFirstNumbersFromLeft2 = listOfStrings.stream()
//                .map(s -> dayOne.returnFirstNumberFromString(String.valueOf(s), false, false)).toList();
//        List<String> listOfFirstNumbersFromRight2 = listOfStrings.stream()
//                .map(s -> dayOne.returnFirstNumberFromString(String.valueOf(s), true, false)).toList();
//        List<String> listOfCombinedNumbersFromLeftAndRight =
//                IntStream.range(0, listOfFirstNumbersFromLeft.size())
//                        .mapToObj(i -> listOfFirstNumbersFromLeft.get(i) + listOfFirstNumbersFromRight.get(i)).toList();
//        List<String> listOfCombinedNumbersFromLeftAndRight2 =
//                IntStream.range(0, listOfFirstNumbersFromLeft.size())
//                        .mapToObj(i -> listOfFirstNumbersFromLeft2.get(i) + listOfFirstNumbersFromRight2.get(i)).toList();
//
//        int totalSum = dayOne.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight);
//        int totalSum2 = dayOne.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight2);
//        System.out.println("Day One ----------------------------------");
//        System.out.println("Total sum of all values in list = " + totalSum);
//        System.out.println("Total sum of all numbers, even the text ones, in list = " + totalSum2);
//
//        // DAY TWO OUTPUT
//        DayTwo dayTwo = new DayTwo();
//        List<String> listOfGames = util.readStringsFromFile("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayTwo.txt");
//        System.out.println("");
//        System.out.println("Day Two ----------------------------------");
//        System.out.println("Sum of all valid IDs for day two = " + dayTwo.sumOfAllValidIDs(listOfGames, 13, 14, 12));
//        System.out.println("Total power of all games for day two = " + dayTwo.totalPowerOfAllGames(listOfGames));
//
//        // DAY THREE OUTPUT
//        DayThree dayThree = new DayThree();
//        List<String> readList = util.readStringsFromFile("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayThree.txt");
//        List<String> list3 = dayThree.addCushionLinesAndColumnsOnStringsInList(readList);
//        List<Number> listOfAllNumbers = dayThree.listOfAllNumbers(list3);
//        dayThree.setAdjacentToSymbolForNumber(listOfAllNumbers, list3);
//
//        System.out.println(" ");
//        System.out.println("Day Three ----------------------------------");
//        System.out.println("Total value of numbers adjacent to symbol = " + dayThree.getTotalAddedNumbersAdjacentToSymbol(listOfAllNumbers));
//        System.out.println("TotalValue for two values adjacent to a star = " + dayThree.calculateTotalValueOfAllAdjacentValuesToStar(listOfAllNumbers));
//
//        // DAY FOUR OUTPUT
//        DayFour dayFour = new DayFour();
//        List<String> listOfCards = util.readStringsFromFile("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayFour.txt");
//        List<String> listOfCutStrings = dayFour.removeFrontPartOfStringAndReturnList(listOfCards);
//        List<NumbersPerCard> listOfAllNumbersPerCard = dayFour.listOfAllNumbersPerCard(listOfCutStrings);
//        dayFour.setMatchingNumberPerCard(listOfAllNumbersPerCard);
//        dayFour.setNumberOfTotalPerCard(listOfAllNumbersPerCard);
//
//        System.out.println(" ");
//        System.out.println("Day Four -------------------------------------");
//        System.out.println("Total value of all exponential values is = " + dayFour.totalSumOfAllExponentialValues(listOfAllNumbersPerCard));
//        System.out.println("Total sum of all added extra cards are = " + dayFour.totalSumOfNumbersOfTotalPerCard(listOfAllNumbersPerCard));

        DaySix daySix = new DaySix();

        List<String> list6 = util.readStringsFromFile("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\daySix.txt");

        List<String> removedLabelString = daySix.removeLabelsFromFrontPartOfString(list6);
        List<TimeDistance> listOfTimeAndDistances = daySix.listOfTimeAndDistances(removedLabelString);
        System.out.println(listOfTimeAndDistances.get(0).getTimeRaceLasts());
        System.out.println(listOfTimeAndDistances.get(0).getTotalDistanceTraveled());




    }
}