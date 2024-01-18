package org.advent.dayeleven;

public class Position {

    public boolean isGalaxy;
    public Coordinate coordinate;
    public char character;

    public Position(Coordinate coordinate, char character) {
        this.coordinate = coordinate;
        this.character = character;
    }

    public boolean isGalaxy() {
        return character == '#';
    }

    public void setGalaxy(boolean isGalaxy) {
        this.isGalaxy = isGalaxy;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public char getCharacter() {
        return character;
    }
}
