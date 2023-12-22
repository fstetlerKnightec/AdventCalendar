package org.advent.daysix;

import org.advent.PrintSolution;

import java.util.ArrayList;
import java.util.List;

public class DaySix implements PrintSolution {

    public int totalNumberOfButtonHoldsThatBeatRecord(List<TimeDistance> timeDistances) {
        int totalNumber = 1;
        for (TimeDistance timeDistance : timeDistances) {
            totalNumber *= timeDistance.numberOfButtonHoldsBeatRecord();
        }
        return totalNumber;
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

    public List<String> splitStringIntoNumbers(List<String> listOfStrings, int index) {
        return new ArrayList<>(List.of(listOfStrings.get(index).trim().split("\\s+")));
    }

    public List<String> stringOfAllNumbersCombined(List<String> listOfStrings) {
        return listOfStrings.stream().map(s -> s.trim().replaceAll("\\s+", "")).toList();
    }

    public List<String> removeLabelsFromFrontPartOfString(List<String> listOfStrings) {
        return listOfStrings.stream().map(s -> s.substring(s.indexOf(":") + 1)).toList();
    }

    @Override
    public void printPartOne(int result) {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total multiplied number of all possible settings is = " + result);
    }

    @Override
    public void printPartTwo(int result) {
        System.out.println("Total number of ways to beat the record with a combined race = " + result);
    }
}