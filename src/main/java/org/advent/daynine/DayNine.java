package org.advent.daynine;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayNine implements PrintSolution {

    PyramidFactory pyramidFactory = new PyramidFactory();

    public long sumOfHighestValueFromEachPyramid(List<String> listOfStrings) {
        List<Pyramid> listOfPyramids = new ArrayList<>();
        List<Integer> listOfAllHighestValues = new ArrayList<>();

        for (int i = 0; i < listOfStrings.size(); i++) {
            listOfPyramids.add(pyramidFactory.createPyramid(listOfStrings.get(i)));
            listOfAllHighestValues.add(listOfPyramids.get(i).resultList().getFirst());
        }
        return listOfAllHighestValues.stream().mapToLong(Integer::longValue).sum();

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
        System.out.println("The total sum of all highest values from each pyramid in part one is " + sumOfHighestValueFromEachPyramid(listOfStringsFromFile()));
    }

    @Override
    public void printPartTwo() throws IOException {

    }
}
