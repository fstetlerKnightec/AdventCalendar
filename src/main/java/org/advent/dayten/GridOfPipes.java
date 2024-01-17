package org.advent.dayten;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridOfPipes {
    public List<List<Position>> grid;
    public Position startPosition;
    public Position firstValidPosition;
    public List<Position> positionsToS;

    public void setUpGridWithPositionOfS(List<String> listOfStrings) {
        List<List<Position>> grid = new ArrayList<>();
        for (int i = 0; i < listOfStrings.size(); i++) {
            List<Position> rowPositions = new ArrayList<>();
            String currentLine = listOfStrings.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                Coordinate currentCoordinate = new Coordinate(j, i);
                Position currentPosition = new Position(currentCoordinate, currentLine.charAt(j));
                rowPositions.add(currentPosition);
                if (currentLine.charAt(j) == 'S') {
                    startPosition = currentPosition;
                }
            }
            grid.add(rowPositions);
        }
        this.grid = grid;
    }

    public int numberOfStepsToReachFurthestAwayFromS() {
        return (positionsToS.size() - 1) / 2;
    }

    public void setLoopThroughPositionsToFindS() {
        Position position = firstValidPosition;
        Position previousPosition = startPosition;
        List<Position> listOfPositions = new ArrayList<>(Arrays.asList(previousPosition, position));
        while (position.character() != 'S') {
            Direction direction = position.nextDirection(previousPosition);
            previousPosition = position;
            position = getPositionFromGrid(position.nextX(direction), position.nextY(direction));
            listOfPositions.add(position);
        }
        positionsToS = listOfPositions;
    }

    public int numberOfDotsInsidePath() {
        int numberOfDots = 0;

//        for (int j = 0; j < grid.size(); j++) {

            List<Position> currentRow = grid.get(0);

            boolean insideLoop = false;
            for (int i = 0; i < currentRow.size() - 1; i++) {
                Position currentPosition = currentRow.get(i);

                int index = positionsToS.indexOf(currentPosition);

                if (positionsToS.contains(currentPosition)) {
                    if (index >= 0) {
                        if (positionsToS.indexOf(currentRow.get(i)) + 1 != positionsToS.indexOf(currentRow.get(i + 1))) {
                            insideLoop = !insideLoop;

                        }
                    }
                }

                if (insideLoop) {
                    if (currentRow.get(i).character() == '.') {
                        numberOfDots += 1;
                    }
                }
            }
//        }

        System.out.println(numberOfDots);
        return numberOfDots;
    }

    public void setFirstValidStepFromS() {
        Position positionCandidate = getPositionAfterStep(startPosition, Direction.UP);
        if (List.of('|', 'F', '7').contains(positionCandidate.character())) {
            firstValidPosition = positionCandidate;
            return;
        }
        positionCandidate = getPositionAfterStep(startPosition, Direction.RIGHT);
        if (List.of('-', '7', 'J').contains(positionCandidate.character())) {
            firstValidPosition = positionCandidate;
            return;
        }
        positionCandidate = getPositionAfterStep(startPosition, Direction.DOWN);
        if (List.of('|', 'J', 'L').contains(positionCandidate.character())) {
            firstValidPosition = positionCandidate;
            return;
        }
        positionCandidate = getPositionAfterStep(startPosition, Direction.LEFT);
        firstValidPosition = positionCandidate;
    }

    private Position getPositionAfterStep(Position currentPosition, Direction direction) {
        int x = currentPosition.nextX(direction);
        int y = currentPosition.nextY(direction);
        return getPositionFromGrid(x, y);
    }

    private Position getPositionFromGrid(int x, int y) {
        return grid.get(y).get(x);
    }

    public Position getPositionOfS() {
        return startPosition;
    }
}
