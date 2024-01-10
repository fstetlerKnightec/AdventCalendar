package org.advent.daynine;

import java.util.ArrayList;
import java.util.List;

public record Row(List<Integer> integerList) {

    public List<Integer> differencesBetweenValuesInList(List<Integer> listOfIntegers) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < listOfIntegers.size() - 1; i++) {
            newList.add(listOfIntegers.get(i + 1) - listOfIntegers.get(i));
        }
        return newList;
    }
}
