package org.advent.dayten;

public record Position(int xPosition, int yPosition, char character) {

    public int nextX(Direction coordinateDirection) {
        return coordinateDirection.getX() + xPosition;
    }

    public int nextY(Direction coordinateDirection) {
        return coordinateDirection.getY() + yPosition;
    }

    public Direction nextStep(Position previousPosition) {
        return Direction.getDirection(character, previousPosition, xPosition, yPosition);

    }
}
