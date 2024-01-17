package org.advent.dayeleven;

public class Position {

    public boolean isGalaxy;

    public Coordinate coordinate;

    public char character;


    public boolean isGalaxy() {
        return isGalaxy;
    }

    public void setGalaxy(boolean galaxy) {
        isGalaxy = galaxy;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}
