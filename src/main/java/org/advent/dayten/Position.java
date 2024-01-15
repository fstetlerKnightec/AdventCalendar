package org.advent.dayten;

import static org.advent.dayten.Pipe.getDirectionFromCharacter;

public record Position(Coordinate coordinate, char character) {

    public int nextX(Direction coordinateDirection) {
        return coordinateDirection.getX() + coordinate().getX();
    }

    public int nextY(Direction coordinateDirection) {
        return coordinateDirection.getY() + coordinate().getY();
    }

    public Direction nextDirection(Position previousPosition) {
        return getDirectionToGoFromPipe(previousPosition);
    }

    public Direction getDirectionToGoFromPipe(Position previousCoordinate) {
        Pipe pipe = getDirectionFromCharacter(character);
        if (previousCoordinate.coordinate().getX() == nextX(pipe.getOneDirection())
                && previousCoordinate.coordinate().getY() == nextY(pipe.getOneDirection())) {
            return pipe.getOtherDirection();
        }
        return pipe.getOneDirection();
    }
}
