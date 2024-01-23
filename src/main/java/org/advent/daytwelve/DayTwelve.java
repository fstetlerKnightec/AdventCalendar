package org.advent.daytwelve;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DayTwelve implements PrintSolution {
    @Override
    public void printPartOne() throws IOException {

    }

    @Override
    public void printPartTwo() throws IOException {

    }


    private List<String> getStringsFromFile() {
        List<String> allStrings;
        try {
            allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayTwelve.txt").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allStrings;
    }

}
