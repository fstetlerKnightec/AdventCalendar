package org.advent;

import org.advent.dayfour.DayFour;
import org.advent.dayfour.NumbersPerCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

//        // DAY ONE OUTPUT
//        DayOneClean dayOneClean = new DayOneClean();
//        List<String> listOfStrings = dayOneClean.readFileAndReturnList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayOne.txt");
//        List<String> listOfFirstNumbersFromLeft = listOfStrings.stream()
//                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), false, true)).toList();
//        List<String> listOfFirstNumbersFromRight = listOfStrings.stream()
//                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), true, true)).toList();
//        List<String> listOfFirstNumbersFromLeft2 = listOfStrings.stream()
//                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), false, false)).toList();
//        List<String> listOfFirstNumbersFromRight2 = listOfStrings.stream()
//                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), true, false)).toList();
//        List<String> listOfCombinedNumbersFromLeftAndRight =
//                IntStream.range(0, listOfFirstNumbersFromLeft.size())
//                        .mapToObj(i -> listOfFirstNumbersFromLeft.get(i) + listOfFirstNumbersFromRight.get(i)).toList();
//        List<String> listOfCombinedNumbersFromLeftAndRight2 =
//                IntStream.range(0, listOfFirstNumbersFromLeft.size())
//                        .mapToObj(i -> listOfFirstNumbersFromLeft2.get(i) + listOfFirstNumbersFromRight2.get(i)).toList();
//
//        int totalSum = dayOneClean.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight);
//        int totalSum2 = dayOneClean.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight2);
//        System.out.println("Day One ----------------------------------");
//        System.out.println("Total sum of all values in list = " + totalSum);
//        System.out.println("Total sum of all numbers, even the text ones, in list = " + totalSum2);
//
//        // DAY TWO REWORKED OUTPUT
//        DayTwoReworked dayTwoReworked = new DayTwoReworked();
//        List<String> listOfGames = dayTwoReworked.readGamesFromFileAndPutInList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayTwo.txt");
//        System.out.println("");
//        System.out.println("Day Two ----------------------------------");
//        System.out.println("Sum of all valid IDs for day two = " + dayTwoReworked.sumOfAllValidIDs(listOfGames, 13, 14, 12));
//        System.out.println("Total power of all games for day two = " + dayTwoReworked.totalPowerOfAllGames(listOfGames));
//
//        // DAY THREE OUTPUT
//        DayThree dayThree = new DayThree();
//        List<String> list3 = DayThree.readFileAndReturnList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayThree.txt");
//        List<Number> listOfAllNumbers = dayThree.listOfAllNumbers(list3);
//        dayThree.setAdjacentToSymbolForNumber(listOfAllNumbers, list3);
//
//        System.out.println(" ");
//        System.out.println("Day Three ----------------------------------");
//        System.out.println("Total value of numbers adjacent to symbol = " + dayThree.getTotalAddedNumbersAdjacentToSymbol(listOfAllNumbers));
//        System.out.println("TotalValue for two values adjacent to a star = " + dayThree.calculateTotalValueOfAllAdjacentValuesToStar(listOfAllNumbers));


        // DAY FOUR OUTPUT
        DayFour dayFour = new DayFour();
        List<String> listOfCards = dayFour.readStringsFromFile("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayFour.txt");
        List<String> listOfCutStrings = dayFour.removeFrontPartOfStringAndReturnList(listOfCards);
        List<NumbersPerCard> listOfAllNumbersPerCard = dayFour.listOfAllNumbersPerCard(listOfCutStrings);
        dayFour.setMatchingNumberPerCard(listOfAllNumbersPerCard);
        dayFour.setNumberOfTotalPerCard(listOfAllNumbersPerCard);

        System.out.println(" ");
        System.out.println("Day Four -------------------------------------");
        System.out.println("Total value of all exponential values is = " + dayFour.totalSumOfAllExponentialValues(listOfAllNumbersPerCard));
        System.out.println("Total sum of all added extra cards are = " + dayFour.totalSumOfNumbersOfTotalPerCard(listOfAllNumbersPerCard));

    }
}