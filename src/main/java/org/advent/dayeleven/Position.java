package org.advent.dayeleven;

public record Position(Coordinate coordinate, char character) {

    // making this into a record SIGNIFICANTLY increases run time, from about 33 seconds to more than a minute. Curious.

    public boolean isGalaxy() {
        return character == '#'; // is this allowed by simply not setting isGalaxy in the field, but only
        // calling isGalaxy depending on another field. Less constructor work and field assignment
    }
}
