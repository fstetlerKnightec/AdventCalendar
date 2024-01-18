package org.advent.dayeleven;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DayEleven implements PrintSolution {

    Space space = new Space();

    @Override
    public void printPartOne() throws IOException {
        System.out.println(solutionForPartOne());
    }

    @Override
    public void printPartTwo() throws IOException {

    }


    public int solutionForPartOne() {
        space.makeRows(getStringsFromFile());
        space.makeColumnsFromExistingRows();

        List<Position> positions = space.galaxyPositions();

        return space.loopPositionsAndFindSum(positions);
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
