package org.advent.dayten;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
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

//    F J - | 7 L

    public List<Position> listOfPositionsToReachS() {
        List<String> strings = getStringsFromFile();
        GridOfPipes gridOfPipes = new GridOfPipes();
        gridOfPipes.createGrid(strings);

        Position previousPosition = gridOfPipes.getPositionOfS();
        Position position = gridOfPipes.findFirstValidStepFromS();

        List<Position> listOfPositions = new ArrayList<>();
        listOfPositions.add(previousPosition);
        listOfPositions.add(position);
        while (position.character() != 'S') {
            CoordinateDirection direction = position.nextStep(previousPosition);
            char nextCharacter = gridOfPipes.getPositionFromGrid(position.nextX(direction), position.nextY(direction)).character();
            previousPosition = position;
            position = new Position(position.nextX(direction), position.nextY(direction), nextCharacter);
            listOfPositions.add(position);
        }

        return listOfPositions;
    }


    public int numberOfStepsToReachFurthestAwayFromS() {
        return (listOfPositionsToReachS().size() - 1) / 2;
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
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Number of steps to reach furthest away = " + numberOfStepsToReachFurthestAwayFromS());

    }

    @Override
    public void printPartTwo() throws IOException {

    }
}
