package org.advent.dayten;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTen implements PrintSolution {

    // FOR PART TWO
//     Go around the edges of the pipes and find every ., that will be a a O (replace with O)
//    Go through every dot, and see if any dot is connected to a O. If so, repeat the "go through every dot"
//    once no more dots are made into O, finish the loop. The rest of the dots are now tiles that are enclosed

    @Override
    public void printPartOne() throws IOException {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Number of steps to reach furthest away = " + numberOfStepsToReachFurthestAwayFromS(getStringsFromFile()));
    }

    @Override
    public void printPartTwo() throws IOException {

    }

    public List<Position> loopThroughPositions(GridOfPipes grid, Position position, Position previousPosition) {
        List<Position> listOfPositions = new ArrayList<>(Arrays.asList(previousPosition, position));
        while (position.character() != 'S') {
            Direction direction = position.nextStep(previousPosition);
            assert direction != null;
            char nextCharacter = getNextCharacter(grid, position, direction);
            previousPosition = position;
            position = new Position(position.nextX(direction), position.nextY(direction), nextCharacter);
            listOfPositions.add(position);
        }
        return listOfPositions;
    }

    public int numberOfStepsToReachFurthestAwayFromS(List<String> strings) {
        return (listOfPositionsToReachS(strings).size() - 1) / 2;
    }

    private List<Position> listOfPositionsToReachS(List<String> strings) {
        GridOfPipes grid = grid(strings);

        Position previousPosition = grid.getPositionOfS();
        Position position = grid.findFirstValidStepFromS();
        return loopThroughPositions(grid, position, previousPosition);
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

    private Character getNextCharacter(GridOfPipes grid, Position position, Direction direction) {
        return grid.getPositionFromGrid(position.nextX(direction), position.nextY(direction)).character();
    }
}
