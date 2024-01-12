package org.advent.dayten;

public record Position(int xPosition, int yPosition, char character) {

    public int nextX(CoordinateDirection coordinateDirection) {
        return coordinateDirection.getX() + xPosition;
    }

    public int nextY(CoordinateDirection coordinateDirection) {
        return coordinateDirection.getY() + yPosition;
    }

    public CoordinateDirection nextStep(Position previousPosition) {

//        return CoordinateDirection.getDirection(character, previousPosition);

        if (character == 'L') {
            return CoordinateDirection.getDirection('L', previousPosition, xPosition, yPosition);
        }

        if (character == '-') {
            return CoordinateDirection.getDirection('-', previousPosition, xPosition, yPosition);
        }

        if (character == '7') {
            return CoordinateDirection.getDirection('7', previousPosition, xPosition, yPosition);
        }

        if (character == '|') {
            return CoordinateDirection.getDirection('|', previousPosition, xPosition, yPosition);
        }

        if (character == 'J') {
            return CoordinateDirection.getDirection('J', previousPosition, xPosition, yPosition);
        }

        return CoordinateDirection.getDirection('F', previousPosition, xPosition, yPosition);
    }
}
