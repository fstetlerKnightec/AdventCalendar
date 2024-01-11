package org.advent.daynine;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DayNine implements PrintSolution {

    private final PyramidFactory pyramidFactory = new PyramidFactory();

    public int sumOfHighestValueFromEachPyramid(List<String> listOfStrings, boolean isPartTwo) {
        List<Pyramid> listOfPyramids = createListOfPyramids(listOfStrings);
        setPyramidRowUntilZero(listOfPyramids);
        List<Integer> highestValues = addAllHighestValuesFromPyramidToList(listOfPyramids, isPartTwo);
        return addValuesFromListTogether(highestValues);
    }

    private int addValuesFromListTogether(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).sum();
    }

    private List<Integer> addAllHighestValuesFromPyramidToList(List<Pyramid> listOfPyramids, boolean isPartTwo) {
        return listOfPyramids.stream().map(p -> p.resultList(isPartTwo).getFirst()).toList();
    }

    private void setPyramidRowUntilZero(List<Pyramid> listOfPyramids) {
        listOfPyramids.forEach(Pyramid::setListOfRowsUntilZero);
    }

    private List<Pyramid> createListOfPyramids(List<String> listOfStrings) {
        return listOfStrings.stream().map(pyramidFactory::createPyramid).toList();
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

    private String getClassName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void printPartOne() throws IOException {
        System.out.println(" ");
        System.out.println(getClassName() + " ---------------------------");
        System.out.println();
        System.out.println("The total sum of all highest values from each pyramid in part one is " + sumOfHighestValueFromEachPyramid(listOfStringsFromFile(), false));
    }

    @Override
    public void printPartTwo() throws IOException {
        System.out.println("The total sum of all highest values from each pyramid in part two is " + sumOfHighestValueFromEachPyramid(listOfStringsFromFile(), true));
    }
}
