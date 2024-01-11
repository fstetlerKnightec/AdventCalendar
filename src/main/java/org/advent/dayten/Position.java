package org.advent.dayten;

public record Position(int xPosition, int yPosition, char character) {

    public int nextX(CoordinateDirection coordinateDirection) {
        return coordinateDirection.getX() + xPosition;
    }

    public int nextY(CoordinateDirection coordinateDirection) {
        return coordinateDirection.getY() + yPosition;
    }

}
