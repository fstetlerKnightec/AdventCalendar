package org.advent.daynine;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayNine implements PrintSolution {


    public List<Integer> differencesBetweenValuesInList(List<Integer> listOfIntegers) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < listOfIntegers.size() - 1; i++) {
            newList.add(listOfIntegers.get(i+1) - listOfIntegers.get(i));
        }
        return newList;
    }

    private int results() {
        try {
            List<String> listOfStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayNine.txt").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public void printPartOne() throws IOException {

    }

    @Override
    public void printPartTwo() throws IOException {

    }
}
