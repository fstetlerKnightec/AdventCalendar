package org.advent.dayten;

public record Position(int xPosition, int yPosition, char currentCharacter) {

    public int nextX(CoordinateDirection coordinateDirection) {
        return coordinateDirection.getX() + xPosition;
    }

    public int nextY(CoordinateDirection coordinateDirection) {
        return coordinateDirection.getY() + yPosition;
    }

    public boolean previousPositionWasAbove(Position previousPosition) {
        return previousPosition.yPosition == yPosition() - 1;
    }

    public boolean previousPositionWasToLeft(Position previousPosition) {
        return previousPosition.xPosition == xPosition() - 1;
    }

    public boolean previousPositionWasBelow(Position previousPosition) {
        return previousPosition.yPosition == yPosition() + 1;
    }

    public CoordinateDirection nextStep(Position previousPosition) {

        if (currentCharacter == 'L') {
            if (previousPositionWasAbove(previousPosition)) {
                return CoordinateDirection.RIGHT;
            }
            return CoordinateDirection.UP;
        }

        if (currentCharacter == '-') {
            if (previousPositionWasToLeft(previousPosition)) {
                return CoordinateDirection.RIGHT;
            }
            return CoordinateDirection.LEFT;
        }

        if (currentCharacter == '7') {
            if (previousPositionWasToLeft(previousPosition)) {
                return CoordinateDirection.DOWN;
            }
            return CoordinateDirection.LEFT;
        }

        if (currentCharacter == '|') {
            if (previousPositionWasAbove(previousPosition)) {
                return CoordinateDirection.DOWN;
            }
            return CoordinateDirection.UP;
        }

        if (currentCharacter == 'J') {
            if (previousPositionWasToLeft(previousPosition)) {
                return CoordinateDirection.UP;
            }
            return CoordinateDirection.LEFT;
        }

        if (currentCharacter == 'F') {
            if (previousPositionWasBelow(previousPosition)) {
                return CoordinateDirection.RIGHT;
            }
            return CoordinateDirection.DOWN;
        }

        return null;
    }

}
