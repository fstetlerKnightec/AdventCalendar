package org.advent.dayten;

public record Position(int xPosition, int yPosition, char character) {

    public int nextX(Direction coordinateDirection) {
        return coordinateDirection.getX() + xPosition;
    }

    public int nextY(Direction coordinateDirection) {
        return coordinateDirection.getY() + yPosition;
    }

    public Direction nextStep(Position previousPosition) {
        return getDirectionToGoFromPipe(previousPosition);

    }

    public Direction getDirectionToGoFromPipe(Position previousCoordinate) {
        Pipe pipe = getDirectionFromCharacter(character);
        if (previousCoordinate.xPosition() == nextX(pipe.getOneDirection()) && previousCoordinate.yPosition() == nextY(pipe.getOneDirection())) {
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
