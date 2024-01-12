package org.advent.dayten;

import java.util.ArrayList;
import java.util.List;

public class GridOfPipes {


//    add field of grid here from grid()
    private List<List<Position>> grid;
    private Position startPosition;

    public GridOfPipes() {

    }


    public void createGrid(List<String> listOfStrings) {
        List<List<Position>> grid = new ArrayList<>();
        for (int i = 0; i < listOfStrings.size(); i++) {
            List<Position> rowPositions = new ArrayList<>();
            String currentLine = listOfStrings.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                Position currentPosition = new Position(j, i, currentLine.charAt(j));
                rowPositions.add(currentPosition);
                if (currentLine.charAt(j) == 'S') {
                    startPosition = currentPosition;
                }
            }
            grid.add(rowPositions);
        }
        this.grid = grid;
    }


    public Position getPositionFromGrid(int x, int y) {
        return grid.get(y).get(x);
    }

    public Position findFirstValidStepFromS() {
        Position positionCandidate = getPositionStep(startPosition, CoordinateDirection.UP);
        if (List.of('|', 'F', '7').contains(positionCandidate.character())) {
            return positionCandidate;
        }
        positionCandidate = getPositionStep(startPosition, CoordinateDirection.RIGHT);
        if (List.of('-', '7', 'J').contains(positionCandidate.character())) {
            return positionCandidate;
        }
        positionCandidate = getPositionStep(startPosition, CoordinateDirection.DOWN);
        if (List.of('|', 'J', 'L').contains(positionCandidate.character())) {
            return positionCandidate;
        }
        positionCandidate = getPositionStep(startPosition, CoordinateDirection.LEFT);
        return positionCandidate;
    }

    private Position getPositionStep(Position currentPosition, CoordinateDirection direction) {
        int x = currentPosition.nextX(direction);
        int y = currentPosition.nextY(direction);
        return getPositionFromGrid(x, y);
    }

    public Position getPositionOfS() {
        return startPosition;
    }
}
