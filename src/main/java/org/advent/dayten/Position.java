package org.advent.dayten;

public record Position(int xPosition, int yPosition, char character) {

    public int nextX(CoordinateDirection coordinateDirection) {
        return coordinateDirection.getX() + xPosition;
    }

    public int nextY(CoordinateDirection coordinateDirection) {
        return coordinateDirection.getY() + yPosition;
    }

    public CoordinateDirection nextStep(Position previousPosition) {

        if (character == 'L') {
            if (previousPositionWasAbove(previousPosition)) {
                return CoordinateDirection.RIGHT;
            }
            return CoordinateDirection.UP;
        }

        if (character == '-') {
            if (previousPositionWasToLeft(previousPosition)) {
                return CoordinateDirection.RIGHT;
            }
            return CoordinateDirection.LEFT;
        }

        if (character == '7') {
            if (previousPositionWasToLeft(previousPosition)) {
                return CoordinateDirection.DOWN;
            }
            return CoordinateDirection.LEFT;
        }

        if (character == '|') {
            if (previousPositionWasAbove(previousPosition)) {
                return CoordinateDirection.DOWN;
            }
            return CoordinateDirection.UP;
        }

        if (character == 'J') {
            if (previousPositionWasToLeft(previousPosition)) {
                return CoordinateDirection.UP;
            }
            return CoordinateDirection.LEFT;
        }

        if (character == 'F') {
            if (previousPositionWasBelow(previousPosition)) {
                return CoordinateDirection.RIGHT;
            }
            return CoordinateDirection.DOWN;
        }

        return null;
    }

    private boolean previousPositionWasAbove(Position previousPosition) {
        return previousPosition.yPosition == yPosition() - 1;
    }

    private boolean previousPositionWasToLeft(Position previousPosition) {
        return previousPosition.xPosition == xPosition() - 1;
    }

    private boolean previousPositionWasBelow(Position previousPosition) {
        return previousPosition.yPosition == yPosition() + 1;
    }

}
