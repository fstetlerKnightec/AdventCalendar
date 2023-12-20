package org.advent.day6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaySix {


    public List<TimeDistance> listOfTimeAndDistances(List<String> listOfStrings) {

        List<TimeDistance> listOfTimeAndDistance = new ArrayList<>();

        List<String> listOfTimes = new ArrayList<>(List.of(listOfStrings.get(0).split("\\s+")));
        listOfTimes.remove(0);
        List<String> listOfDistance = new ArrayList<>(List.of(listOfStrings.get(1).split("\\s+")));
        listOfDistance.remove(0);

        for (int i = 0; i < listOfTimes.size(); i++) {
            listOfTimeAndDistance.add(
                    new TimeDistance(
                            Integer.parseInt(listOfTimes.get(i)),
                            Integer.parseInt(listOfDistance.get(i))));
        }

        return listOfTimeAndDistance;

    }

    public List<String> removeLabels(List<String> listOfStrings) {
        List<String> cutString = new ArrayList<>();
        for (String s : listOfStrings) {
            int colonIndex = s.indexOf(":");
            String resultString = s.substring(colonIndex + 1);
            cutString.add(resultString);
        }
        return cutString;
    }

}
