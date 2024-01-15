package org.advent.dayten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridOfPipes {
    private List<List<Position>> grid;
    private Position startPosition;

    public void setUpGrid(List<String> listOfStrings) {
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

    public List<Position> loopThroughPositionsToFindS(Position position, Position previousPosition) {
        List<Position> listOfPositions = new ArrayList<>(Arrays.asList(previousPosition, position));
        while (position.character() != 'S') {
            Direction direction = position.nextDirection(previousPosition);
            previousPosition = position;
            position = getPositionFromGrid(position.nextX(direction), position.nextY(direction));
            listOfPositions.add(position);
        }
        return listOfPositions;
    }

    public Position findFirstValidStepFromS() {
        Position positionCandidate = getPositionAfterStep(startPosition, Direction.UP);
        if (List.of('|', 'F', '7').contains(positionCandidate.character())) {
            return positionCandidate;
        }
        positionCandidate = getPositionAfterStep(startPosition, Direction.RIGHT);
        if (List.of('-', '7', 'J').contains(positionCandidate.character())) {
            return positionCandidate;
        }
        positionCandidate = getPositionAfterStep(startPosition, Direction.DOWN);
        if (List.of('|', 'J', 'L').contains(positionCandidate.character())) {
            return positionCandidate;
        }
        positionCandidate = getPositionAfterStep(startPosition, Direction.LEFT);
        return positionCandidate;
    }

    private Position getPositionAfterStep(Position currentPosition, Direction direction) {
        int x = currentPosition.nextX(direction);
        int y = currentPosition.nextY(direction);
        return getPositionFromGrid(x, y);
    }

    public Position getPositionOfS() {
        return startPosition;
    }

    public Position getPositionFromGrid(int x, int y) {
        return grid.get(y).get(x);
    }
}
