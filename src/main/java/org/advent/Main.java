package org.advent;

import org.advent.dayone.DayOneClean;
import org.advent.daythree.DayThree;
import org.advent.daythree.Number;
import org.advent.daytwo.DayTwoReworked;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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

        List<String> listOfFirstNumbersFromLeft2 = listOfStrings.stream()
                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), false, false)).toList();
        List<String> listOfFirstNumbersFromRight2 = listOfStrings.stream()
                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), true, false)).toList();


        List<String> listOfCombinedNumbersFromLeftAndRight =
                IntStream.range(0, listOfFirstNumbersFromLeft.size())
                        .mapToObj(i -> listOfFirstNumbersFromLeft.get(i) + listOfFirstNumbersFromRight.get(i)).toList();

        List<String> listOfCombinedNumbersFromLeftAndRight2 =
                IntStream.range(0, listOfFirstNumbersFromLeft.size())
                        .mapToObj(i -> listOfFirstNumbersFromLeft2.get(i) + listOfFirstNumbersFromRight2.get(i)).toList();

        int totalSum = dayOneClean.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight);
        int totalSum2 = dayOneClean.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight2);
        System.out.println("Day One ----------------------------------");
        System.out.println("Total sum of all values in list = " + totalSum);
        System.out.println("Total sum of all numbers, even the text ones, in list = " + totalSum2);

        // DAY TWO REWORKED OUTPUT
        DayTwoReworked dayTwoReworked = new DayTwoReworked();
        List<String> listOfGames = dayTwoReworked.readGamesFromFileAndPutInList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayTwo.txt");
        System.out.println("");
        System.out.println("Day Two ----------------------------------");
        System.out.println("Sum of all valid IDs for day two = " + dayTwoReworked.sumOfAllValidIDs(listOfGames, 13, 14, 12));
        System.out.println("Total power of all games for day two = " + dayTwoReworked.totalPowerOfAllGames(listOfGames));

        // DAY THREE OUTPUT

        DayThree dayThree = new DayThree();
        List<String> list3 = DayThree.readFileAndReturnList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayThree.txt");
        List<Number> listOfAllNumbers = dayThree.listOfAllNumbers(list3);

        dayThree.setAdjacentToSymbolForNumber(listOfAllNumbers, list3);

        int totalValue = 0;
        for (int i = 0; i < listOfAllNumbers.size(); i++) {
            Number currentNumber = listOfAllNumbers.get(i);
            for (int j = 0; j < listOfAllNumbers.size(); j++) {
                Number secondNumber = listOfAllNumbers.get(j);
                if (currentNumber != secondNumber) {
                    if (currentNumber.getAdjacantStarCoordinates() != null && secondNumber.getAdjacantStarCoordinates() != null) {
                        if (currentNumber.getAdjacantStarCoordinates().getColumnIndex() == secondNumber.getAdjacantStarCoordinates().getColumnIndex() && currentNumber.getAdjacantStarCoordinates().getRowIndex() == secondNumber.getAdjacantStarCoordinates().getRowIndex()) {
                            if (!currentNumber.isHasBeenUsed() || !secondNumber.isHasBeenUsed()) {
                                totalValue += currentNumber.getNumberValue() * secondNumber.getNumberValue();
                                currentNumber.setHasBeenUsed(true);
                                secondNumber.setHasBeenUsed(true);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(" ");
        System.out.println("Day Three ----------------------------------");
        System.out.println("Total value of numbers adjacant to symbol = " + dayThree.getTotalAddedNumbersAdjacantToSymbol(listOfAllNumbers));
        System.out.println("TotalValue for two values adjacant to a star = " + totalValue);






    }
}