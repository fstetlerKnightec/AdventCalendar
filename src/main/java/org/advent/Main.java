package org.advent;

import org.advent.dayfour.DayFour;
import org.advent.dayfour.NumbersPerCard;
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
        dayOne.printPartOne(totalSum);
        dayOne.printPartTwo(totalSum2);

        // DAY TWO OUTPUT
        DayTwo dayTwo = new DayTwo();
        List<String> listOfGames = util.readStringsFromFile(Paths.get("src/main/resources/dayTwo.txt").toString());
        int sumOfAllValidIds = dayTwo.sumOfAllValidIDs(listOfGames, 13, 14, 12);
        int totalPower = dayTwo.totalPowerOfAllGames(listOfGames);
        dayTwo.printPartOne(sumOfAllValidIds);
        dayTwo.printPartTwo(totalPower);

        // DAY THREE OUTPUT
        DayThree dayThree = new DayThree();
        List<String> readList = util.readStringsFromFile(Paths.get("src/main/resources/dayThree.txt").toString());
        List<String> list3 = dayThree.addCushionLinesAndColumnsOnStringsInList(readList);
        List<Number> listOfAllNumbers = dayThree.listOfAllNumbers(list3);
        dayThree.setAdjacentToSymbolForNumber(listOfAllNumbers, list3);

        int totalAddedNumbersAdjacentToSymbol = dayThree.getTotalAddedNumbersAdjacentToSymbol(listOfAllNumbers);
        int totalValueOfAllAdjacentToStar = dayThree.calculateTotalValueOfAllAdjacentValuesToStar(listOfAllNumbers);
        dayThree.printPartOne(totalAddedNumbersAdjacentToSymbol);
        dayThree.printPartTwo(totalValueOfAllAdjacentToStar);

        // DAY FOUR OUTPUT
        DayFour dayFour = new DayFour();
        List<String> listOfCards = util.readStringsFromFile(Paths.get("src/main/resources/dayFour.txt").toString());
        List<String> listOfCutStrings = dayFour.removeFrontPartOfStringAndReturnList(listOfCards);
        List<NumbersPerCard> listOfAllNumbersPerCard = dayFour.listOfAllNumbersPerCard(listOfCutStrings);
        dayFour.setMatchingNumberPerCard(listOfAllNumbersPerCard);
        dayFour.setNumberOfTotalPerCard(listOfAllNumbersPerCard);

        int totalSumOfAllExponentialValues = dayFour.totalSumOfAllExponentialValues(listOfAllNumbersPerCard);
        int totalSumOfTotalNumberOfCards = dayFour.totalSumOfNumbersOfTotalPerCard(listOfAllNumbersPerCard);
        dayFour.printPartOne(totalSumOfAllExponentialValues);
        dayFour.printPartTwo(totalSumOfTotalNumberOfCards);

    }
}