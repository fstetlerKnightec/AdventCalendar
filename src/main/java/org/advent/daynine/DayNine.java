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
        List<Pyramid> listOfPyramids = new ArrayList<>();
        List<Integer> listOfAllHighestValues = new ArrayList<>();

        for (int i = 0; i < listOfStrings.size(); i++) {
            listOfPyramids.add(pyramidFactory.createPyramid(listOfStrings.get(i)));
            listOfAllHighestValues.add(listOfPyramids.get(i).resultList(isPartTwo).getFirst());
        }
        return listOfAllHighestValues.stream().mapToInt(Integer::intValue).sum();

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
