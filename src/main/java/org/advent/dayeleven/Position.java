package org.advent.dayeleven;

public class Position {

    // making this into a record SIGNIFICANTLY increases run time, from about 33 seconds to more than a minute. Curious.

    public final Coordinate coordinate;
    public final char character;

    public Position(Coordinate coordinate, char character) {
        this.coordinate = coordinate;
        this.character = character;
    }

    public boolean isGalaxy() {
        return character == '#'; // is this allowed by simply not setting isGalaxy in the field, but only
        // calling isGalaxy depending on another field. Less constructor work and field assignment
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public char getCharacter() {
        return character;
    }
}
