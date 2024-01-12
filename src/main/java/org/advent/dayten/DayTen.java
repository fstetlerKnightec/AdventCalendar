package org.advent.dayten;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayTen implements PrintSolution {

    public List<Position> listOfPositionsToReachS(List<String> strings) {
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

    public int numberOfStepsToReachFurthestAwayFromS(List<String> strings) {
        return (listOfPositionsToReachS(strings).size() - 1) / 2;
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
        System.out.println("Number of steps to reach furthest away = " + numberOfStepsToReachFurthestAwayFromS(getStringsFromFile()));

    }

    @Override
    public void printPartTwo() throws IOException {

    }
}
