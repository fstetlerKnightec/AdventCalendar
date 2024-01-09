package org.advent.daynine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pyramid {

    private final String startString;

    public List<List<Integer>> listOfLists = new ArrayList<>();

    public Pyramid(String startString) {
        this.startString = startString;
    }

    public List<Integer> differencesBetweenValuesInList(List<Integer> listOfIntegers) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < listOfIntegers.size() - 1; i++) {
            newList.add(listOfIntegers.get(i+1) - listOfIntegers.get(i));
        }
        return newList;
    }

    public List<Integer> getListOfIntegerFromString() {
        return Arrays.stream(startString.split(" ")).toList().stream().map(Integer::parseInt).toList();
    }

    public void setListOfListsUntilZero() {
        List<Integer> listOfIntegerFromString = getListOfIntegerFromString();
        listOfLists.add(listOfIntegerFromString);
        for (int i = 0; i < listOfIntegerFromString.size(); i++) {
            List<Integer> newList = differencesBetweenValuesInList(listOfIntegerFromString);
            listOfLists.add(newList);
            listOfIntegerFromString = newList;
        }
    }
}
