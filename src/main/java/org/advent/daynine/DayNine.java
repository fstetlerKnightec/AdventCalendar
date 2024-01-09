package org.advent.daynine;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DayNine implements PrintSolution {

    PyramidFactory pyramidFactory = new PyramidFactory();

    private int sumOfHighestValueFromEachPyramid(List<String> listOfStrings) {
        List<Pyramid> listOfPyramids = new ArrayList<>();
        List<Integer> listOfAllHighestValues = new ArrayList<>();

        for (int i = 0; i < listOfStrings.size(); i++) {
            listOfPyramids.add(pyramidFactory.createPyramid(listOfStrings.get(i)));
            listOfAllHighestValues.add(listOfPyramids.get(i).resultList().getFirst());
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
        List<String> list = List.of("4 3 2 1 0 -1 -2 -3 -4 -5 -6 -7 -8 -9 -10 -11 -12 -13 -14 -15 -16");
        System.out.println(sumOfHighestValueFromEachPyramid(list));
    }

    @Override
    public void printPartTwo() throws IOException {

    }
}
