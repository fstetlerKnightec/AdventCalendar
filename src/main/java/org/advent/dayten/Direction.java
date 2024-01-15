package org.advent.dayten;

public enum Direction {

    UP(new Coordinate(0, -1)),
    DOWN(new Coordinate(0, 1)),
    LEFT(new Coordinate(-1, 0)),
    RIGHT(new Coordinate(1, 0));

    private final Coordinate coordinate;

    Direction(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }
}
