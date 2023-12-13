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

//        // DAY ONE OUTPUT
//        DayOneClean dayOneClean = new DayOneClean();
//
//        List<String> listOfStrings = dayOneClean.readFileAndReturnList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayOne.txt");
//
//        List<String> listOfFirstNumbersFromLeft = listOfStrings.stream()
//                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), false, true)).toList();
//        List<String> listOfFirstNumbersFromRight = listOfStrings.stream()
//                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), true, true)).toList();
//
//        List<String> listOfFirstNumbersFromLeft2 = listOfStrings.stream()
//                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), false, false)).toList();
//        List<String> listOfFirstNumbersFromRight2 = listOfStrings.stream()
//                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), true, false)).toList();
//
//
//        List<String> listOfCombinedNumbersFromLeftAndRight =
//                IntStream.range(0, listOfFirstNumbersFromLeft.size())
//                        .mapToObj(i -> listOfFirstNumbersFromLeft.get(i) + listOfFirstNumbersFromRight.get(i)).toList();
//
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


        // DAY THREE OUTPUT

        DayThree dayThree = new DayThree();

        List<String> list3 = DayThree.readFileAndReturnList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayThree.txt");


        List<Number> listOfAllNumbers = new ArrayList<>();
        for (int i = 0; i < list3.size(); i++) {

            List<Number> numbers = dayThree.numbersOnCurrentLine(list3, list3.get(i), i);
            listOfAllNumbers.addAll(numbers);
        }

        List<String> symbols = new ArrayList<>(Arrays.asList("*", "#", "+", "$", "@", "/", "=", "-", "&"));

        for (int i = 0; i < listOfAllNumbers.size(); i++) {
            Number currentNumber = listOfAllNumbers.get(i);
            for (String s : symbols) {
                if (currentNumber.doesNumberHasAdjacantSymbol(list3, s, currentNumber.getRow(), currentNumber.getColumn(), String.valueOf(currentNumber.getNumberValue()).length())) {
                    currentNumber.setHasAdjacentToSymbol(true);
                    break;
                }
            }
        }


//        for (int i = 0; i < list3.size(); i++) {
//            System.out.println(list3.get(i));
//        }


        int totalValue = 0;

//        System.out.println(list3.size());
//        System.out.println(list3.get(141));

        for (int i = 0; i < listOfAllNumbers.size(); i++) {
            Number currentNumber = listOfAllNumbers.get(i);
            System.out.println(currentNumber.getNumberValue());
            System.out.println(currentNumber.getHasAdjacentToSymbol());
            System.out.println("");
            if (currentNumber.getHasAdjacentToSymbol()) {
                totalValue += currentNumber.getNumberValue();
            }
        }
        System.out.println(totalValue);




//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i).getNumberValue());
////            System.out.println(numbers.get(i).getRow());
////            System.out.println(numbers.get(i).getColumn());
//            System.out.println(numbers.get(i).getHasAdjacentToSymbol());
//        }

//        Number number = numbers.get(11);
//        System.out.println(number.doesNumberHasAdjacantSymbol(list3, "*", number.getRow(), number.getColumn(), String.valueOf(number.getNumberValue()).length()));









//
//
//        // DAY TWO OUTPUT
//        DayTwoClean dayTwoClean = new DayTwoClean();
//
//        List<String> listOfGames = dayTwoClean.readGamesFromFileAndPutInList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayTwo.txt");
//
//        System.out.println("Total sum of all acceptable IDs from day two = " + dayTwoClean.sumOfAllIDsFromAllowedGames(listOfGames));
//
//        int totalValue = 0;
//        for (String s : listOfGames) {
//            totalValue += dayTwoClean.powerOfCurrentGame(s);
//        }
//        System.out.println("Total value of all powered values from day two = " + totalValue);








    }
}