package org.advent.dayten;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DayTen implements PrintSolution {

//    public int numberOfStepsToReachFurthestAway(List<String> strings) {
//        createPipeGridNetOfStrings
//        find coordinates of startposition
//        check all positions around and see if a certain symbol, update the coordinate to that position
//        repeat while excluding the previous coordinate from loop, updating stepCount along the way
//        do until youre back at S
//        divide step by 2 and return
//    }

    public void numberOfStepsToReachFurthestAway() {
        List<String> strings = getStringsFromFile();
        GridOfPipes gridOfPipes = new GridOfPipes(strings);

        Position currentPosition = gridOfPipes.getPositionOfS();

        currentPosition = gridOfPipes.setNextPositionOnPipePath(currentPosition);


//        System.out.println("x position is = " + gridOfPipes.getPositionOfS().xPosition);
//        System.out.println("y position is = " + gridOfPipes.getPositionOfS().yPosition);
//        System.out.println(gridOfPipes.getCharacterFromGrid(new Position(0,1)));
    }




    private List<String> getStringsFromFile() {
        List<String> allStrings;
        try {
            allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayTen.txt").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allStrings;
    }

    @Override
    public void printPartOne() throws IOException {
        numberOfStepsToReachFurthestAway();
    }

    @Override
    public void printPartTwo() throws IOException {

    }
}
