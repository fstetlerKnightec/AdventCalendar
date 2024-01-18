package org.advent.dayeleven;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DayEleven implements PrintSolution {
    @Override
    public void printPartOne() throws IOException {
        System.out.println(getStringsFromFile().get(0));
    }

    @Override
    public void printPartTwo() throws IOException {

    }

    private List<String> getStringsFromFile() {
        List<String> allStrings;
        try {
            allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayEleven.txt").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allStrings;
    }

}
