package org.advent.dayten;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTen implements PrintSolution {

    @Override
    public void printPartOne() throws IOException {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Number of steps to reach furthest away = " + numberOfStepsToReachFurthestAwayFromS(getStringsFromFile()));
    }

    @Override
    public void printPartTwo() throws IOException {

    }

    public List<Position> listOfPositionsToReachS(List<String> strings) {
        GridOfPipes grid = grid(strings);

        Position previousPosition = grid.getPositionOfS();
        Position position = grid.findFirstValidStepFromS();
        return loopThroughPositions(grid, position, previousPosition);
    }

    public List<Position> loopThroughPositions(GridOfPipes grid, Position position, Position previousPosition) {
        List<Position> listOfPositions = new ArrayList<>(Arrays.asList(previousPosition, position));
        while (position.character() != 'S') {
            CoordinateDirection direction = position.nextStep(previousPosition);
            assert direction != null;
            char nextCharacter = getNextCharacter(grid, position, direction);
            previousPosition = position;
            position = new Position(position.nextX(direction), position.nextY(direction), nextCharacter);
            listOfPositions.add(position);
        }
        return listOfPositions;
    }

    private Character getNextCharacter(GridOfPipes grid, Position position, CoordinateDirection direction) {
        return grid.getPositionFromGrid(position.nextX(direction), position.nextY(direction)).character();
    }

    public int numberOfStepsToReachFurthestAwayFromS(List<String> strings) {
        return (listOfPositionsToReachS(strings).size() - 1) / 2;
    }

    private GridOfPipes grid(List<String> strings) {
        GridOfPipes gridOfPipes = new GridOfPipes();
        gridOfPipes.setUpGrid(strings);
        return gridOfPipes;
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
}
