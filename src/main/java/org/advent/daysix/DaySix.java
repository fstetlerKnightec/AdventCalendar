package org.advent.daysix;

import java.util.ArrayList;
import java.util.List;

public class DaySix {

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
                            Integer.parseInt(listOfTimes.get(i)),
                            Integer.parseInt(listOfDistance.get(i))));
        }

        return listOfTimeAndDistance;
    }

    public List<String> splitStringIntoNumbers(List<String> listOfStrings, int index) {
        List<String> list = new ArrayList<>(List.of(listOfStrings.get(index).split("\\s+")));
        list.remove(0);
        return list;
    }

    public List<String> removeLabelsFromFrontPartOfString(List<String> listOfStrings) {
        List<String> cutString = new ArrayList<>();
        for (String s : listOfStrings) {
            int colonIndex = s.indexOf(":");
            String resultString = s.substring(colonIndex + 1);
            cutString.add(resultString);
        }
        return cutString;
    }
}