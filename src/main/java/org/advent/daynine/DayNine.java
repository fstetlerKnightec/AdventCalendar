package org.advent.daynine;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayNine implements PrintSolution {

    private final PyramidFactory pyramidFactory = new PyramidFactory();

    public int sumOfHighestValueFromEachPyramid(List<String> listOfStrings, boolean isPartTwo) {
        List<Pyramid> listOfPyramids = createListOfPyramids(listOfStrings);
        setPyramidRowUntilZero(listOfPyramids);
        List<Integer> highestValues = addAllHighestValuesFromPyramidToList(listOfPyramids, isPartTwo);
        return highestValues.stream().mapToInt(Integer::intValue).sum();
    }

    private List<Integer> addAllHighestValuesFromPyramidToList(List<Pyramid> listOfPyramids, boolean isPartTwo) {
        List<Integer> listOfAllHighestValues = new ArrayList<>();
        for (Pyramid pyramid : listOfPyramids) {
            listOfAllHighestValues.add(pyramid.resultList(isPartTwo).getFirst());
        }
        return listOfAllHighestValues;
    }

    private void setPyramidRowUntilZero(List<Pyramid> listOfPyramids) {
        for (Pyramid pyramid : listOfPyramids) {
            pyramid.setListOfRowsUntilZero();
        }
    }

    private List<Pyramid> createListOfPyramids(List<String> listOfStrings) {
        List<Pyramid> listOfPyramids = new ArrayList<>();
        for (String listOfString : listOfStrings) {
            listOfPyramids.add(pyramidFactory.createPyramid(listOfString));
        }
        return listOfPyramids;
    }

    private List<String> listOfStringsFromFile() {
        List<String> listOfStrings;
        try {
            listOfStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayNine.txt").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfStrings;
    }

    @Override
    public void printPartOne() throws IOException {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println();
        System.out.println("The total sum of all highest values from each pyramid in part one is " + sumOfHighestValueFromEachPyramid(listOfStringsFromFile(), false));
    }

    @Override
    public void printPartTwo() throws IOException {
        System.out.println("The total sum of all highest values from each pyramid in part two is " + sumOfHighestValueFromEachPyramid(listOfStringsFromFile(), true));
    }
}
