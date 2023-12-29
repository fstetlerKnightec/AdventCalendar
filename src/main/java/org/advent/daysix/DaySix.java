package org.advent.daysix;

import org.advent.PrintSolution;

import java.util.ArrayList;
import java.util.List;

public class DaySix {

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

//    @Override
//    public void printPartOne(int result) {
//        System.out.println(" ");
//        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
//        System.out.println("Total multiplied number of all possible settings is = " + result);
//    }
//
//    @Override
//    public void printPartTwo(int result) {
//        System.out.println("Total number of ways to beat the record with a combined race = " + result);
//    }
}