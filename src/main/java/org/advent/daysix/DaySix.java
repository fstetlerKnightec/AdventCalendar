package org.advent.daysix;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DaySix implements PrintSolution {

    public int totalNumberOfButtonHoldsThatBeatRecordMultiplied(List<TimeDistance> timeDistances) {
        return timeDistances.stream().map(TimeDistance::numberOfButtonHoldsBeatRecord).reduce(1, (a, b) -> a * b);
    }

    public List<TimeDistance> listOfTimeAndDistances(List<String> stringsWithoutLabels) {
        List<TimeDistance> listOfTimeAndDistance = new ArrayList<>();

        List<String> listOfTimes = splitStringIntoNumbers(stringsWithoutLabels, 0);
        List<String> listOfDistance = splitStringIntoNumbers(stringsWithoutLabels, 1);

        for (int i = 0; i < listOfTimes.size(); i++) {
            listOfTimeAndDistance.add(
                    new TimeDistance(
                            Long.parseLong(listOfTimes.get(i)),
                            Long.parseLong(listOfDistance.get(i))));
        }

        return listOfTimeAndDistance;
    }

    public List<String> stringOfAllNumbersCombined(List<String> listOfStrings) {
        return listOfStrings.stream().map(s -> s.trim().replaceAll("\\s+", "")).toList();
    }

    public List<String> removeLabelsFromFrontPartOfString(List<String> listOfStrings) {
        return listOfStrings.stream().map(s -> s.substring(s.indexOf(":") + 1)).toList();
    }

    private List<String> splitStringIntoNumbers(List<String> listOfStrings, int index) {
        return List.of(listOfStrings.get(index).trim().split("\\s+"));
    }

    public int results(boolean isPartOne) throws IOException {
        List<String> list6 = Util.readStringsFromFile(Paths.get("src/main/resources/daySix.txt").toString());
        List<String> removedLabelString = removeLabelsFromFrontPartOfString(list6);
        List<String> allNumbersCombined = stringOfAllNumbersCombined(removedLabelString);
        List<TimeDistance> listOfTimeAndDistances = listOfTimeAndDistances(removedLabelString);
        List<TimeDistance> combinedRaceTimeDistance = listOfTimeAndDistances(allNumbersCombined);

        if (isPartOne) {
            return totalNumberOfButtonHoldsThatBeatRecordMultiplied(listOfTimeAndDistances);
        }

        return totalNumberOfButtonHoldsThatBeatRecordMultiplied(combinedRaceTimeDistance);
    }

    @Override
    public void printPartOne() throws IOException {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total multiplied number of all possible settings is = " + results(true));
    }

    @Override
    public void printPartTwo() throws IOException {
        System.out.println("Total number of ways to beat the record with a combined race = " + results(false));
    }
}