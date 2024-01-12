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
            if (previousPosition.yPosition == yPosition() - 1) {
                return CoordinateDirection.RIGHT;
            }
            return CoordinateDirection.UP;

        }

        if (character == '-') {
            if (previousPosition.xPosition == xPosition() - 1) {
                return CoordinateDirection.RIGHT;
            }
            return CoordinateDirection.LEFT;
        }

        if (character == '7') {
            if (previousPosition.xPosition == xPosition() - 1) {
                return CoordinateDirection.DOWN;
            }
            return CoordinateDirection.LEFT;
        }

        if (character == '|') {
            if (previousPosition.yPosition == yPosition() - 1) {
                return CoordinateDirection.DOWN;
            }
            return CoordinateDirection.UP;
        }

        if (character == 'J') {
            if (previousPosition.xPosition == xPosition() - 1) {
                return CoordinateDirection.UP;
            }
            return CoordinateDirection.LEFT;
        }

        if (character == 'F') {
            if (previousPosition.yPosition == yPosition() + 1) {
                return CoordinateDirection.RIGHT;
            }
            return CoordinateDirection.DOWN;
        }

        return null;
    }

}
