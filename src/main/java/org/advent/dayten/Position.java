package org.advent.dayten;

public record Position(Coordinate coordinate, char character) {

    public int nextX(Direction coordinateDirection) {
        return coordinateDirection.getX() + coordinate().x;
    }

    public int nextY(Direction coordinateDirection) {
        return coordinateDirection.getY() + coordinate().y;
    }

    public Direction nextStep(Position previousPosition) {
        return getDirectionToGoFromPipe(previousPosition);

    }

    public Direction getDirectionToGoFromPipe(Position previousCoordinate) {
        Pipe pipe = getDirectionFromCharacter(character);
        if (previousCoordinate.coordinate().x == nextX(pipe.getOneDirection())
                && previousCoordinate.coordinate().y == nextY(pipe.getOneDirection())) {
            return pipe.getOtherDirection();
        }
        return pipe.getOneDirection();
    }

    public Pipe getDirectionFromCharacter(char character) {
        if (character == '7') {
            return Pipe.SEVEN_PIPE;
        }
        if (character == 'L') {
            return Pipe.L_PIPE;
        }
        if (character == 'F') {
            return Pipe.F_PIPE;
        }
        if (character == 'J') {
            return Pipe.J_PIPE;
        }
        if (character == '-') {
            return Pipe.HOR_PIPE;
        }
        return Pipe.VERT_PIPE;
    }
}
