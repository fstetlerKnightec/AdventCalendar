package org.advent.dayten;

import static org.advent.dayten.Pipe.getDirectionFromCharacter;

public record Position(Coordinate coordinate, char character) {

    public int nextX(Direction direction) {
        return direction.getX() + coordinate().x();
    }

    public int nextY(Direction direction) {
        return direction.getY() + coordinate().y();
    }

    public Direction nextDirection(Position previousPosition) {
        Pipe pipe = getDirectionFromCharacter(character);
        Coordinate previousCoordinate = previousPosition.coordinate();
        Direction direction = pipe.getOneDirection();
        if (previousCoordinate.x() == nextX(direction)
                && previousCoordinate.y() == nextY(direction)) {
            return pipe.getOtherDirection();
        }
        return pipe.getOneDirection();
    }
}
