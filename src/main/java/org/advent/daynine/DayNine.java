package org.advent.daynine;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayNine implements PrintSolution {


    List<Pyramid> createPyramidClasses(List<String> listOfStrings) {
        List<Pyramid> listOfPyramids = new ArrayList<>();
        for (String listOfString : listOfStrings) {
            listOfPyramids.add(new Pyramid(listOfString));
        }
        return listOfPyramids;
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
