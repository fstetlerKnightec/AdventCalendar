package org.advent;

import org.advent.dayfour.DayFour;
import org.advent.dayfour.NumbersPerCard;
import org.advent.dayone.DayOne;
import org.advent.daysix.TimeDistance;
import org.advent.daythree.DayThree;
import org.advent.daythree.Number;
import org.advent.daytwo.DayTwo;
import org.advent.daysix.DaySix;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        Util util = new Util();

        // DAY ONE OUTPUT
        DayOne dayOne = new DayOne();
        dayOne.printPartOne();
        dayOne.printPartTwo();

        // DAY TWO OUTPUT
        DayTwo dayTwo = new DayTwo();
        dayTwo.printPartOne();
        dayTwo.printPartTwo();

        // DAY THREE OUTPUT
        DayThree dayThree = new DayThree();
        dayThree.printPartOne();
        dayThree.printPartTwo();

        // DAY FOUR OUTPUT
        DayFour dayFour = new DayFour();
        List<String> listOfCards = util.readStringsFromFile(Paths.get("src/main/resources/dayFour.txt").toString());
        List<String> listOfCutStrings = dayFour.removeFrontPartOfStringAndReturnList(listOfCards);
        List<NumbersPerCard> listOfAllNumbersPerCard = dayFour.listOfAllNumbersPerCard(listOfCutStrings);
        dayFour.setMatchingNumberPerCard(listOfAllNumbersPerCard);
        dayFour.setNumberOfTotalPerCard(listOfAllNumbersPerCard);

        int totalSumOfAllExponentialValues = dayFour.totalSumOfAllExponentialValues(listOfAllNumbersPerCard);
        int totalSumOfTotalNumberOfCards = dayFour.totalSumOfNumbersOfTotalPerCard(listOfAllNumbersPerCard);
//        dayFour.printPartOne(totalSumOfAllExponentialValues);
//        dayFour.printPartTwo(totalSumOfTotalNumberOfCards);

        // DAY SIX OUTPUT
        DaySix daySix = new DaySix();

        List<String> list6 = util.readStringsFromFile(Paths.get("src/main/resources/daySix.txt").toString());
        List<String> removedLabelString = daySix.removeLabelsFromFrontPartOfString(list6);
        List<String> allNumbersCombined = daySix.stringOfAllNumbersCombined(removedLabelString);
        List<TimeDistance> listOfTimeAndDistances = daySix.listOfTimeAndDistances(removedLabelString);
        List<TimeDistance> combinedRaceTimeDistance = daySix.listOfTimeAndDistances(allNumbersCombined);

        int totalNumberOfButtonHoldsBeatingRecords = daySix.totalNumberOfButtonHoldsThatBeatRecordMultiplied(listOfTimeAndDistances);
        int totalNumberWithOnlyCombinedRace = daySix.totalNumberOfButtonHoldsThatBeatRecordMultiplied(combinedRaceTimeDistance);
//        daySix.printPartOne(totalNumberOfButtonHoldsBeatingRecords);
//        daySix.printPartTwo(totalNumberWithOnlyCombinedRace);


    }
}