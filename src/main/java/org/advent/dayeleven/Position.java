package org.advent.dayeleven;

public record Position(Coordinate coordinate, char character) {

    public boolean isGalaxy() {
        return character == '#';
    }
}
