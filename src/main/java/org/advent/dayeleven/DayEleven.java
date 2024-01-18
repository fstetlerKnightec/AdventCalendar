package org.advent.dayeleven;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DayEleven implements PrintSolution {


    @Override
    public void printPartOne() throws IOException {
        System.out.println("part one = " + solutionForPartOne());
    }

    @Override
    public void printPartTwo() throws IOException {
        System.out.println("part two = " + solutionForPartTwo());
    }


    public long solutionForPartOne() {
        Space space = new Space();

        space.makeRows(getStringsFromFile(), 2);
        space.makeColumnsFromExistingRows(2);

        List<Position> positions = space.galaxyPositions();

        return space.loopPositionsAndFindSum(positions);
    }

    public long solutionForPartTwo() {
        Space space = new Space();

        space.makeRows(getStringsFromFile(), 1000000);
        space.makeColumnsFromExistingRows(1000000);

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
