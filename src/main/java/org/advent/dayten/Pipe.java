package org.advent.dayten;

public enum Pipe {

    L_PIPE(Direction.UP, Direction.RIGHT),
    F_PIPE(Direction.DOWN, Direction.RIGHT),
    J_PIPE(Direction.LEFT, Direction.UP),
    SEVEN_PIPE(Direction.LEFT, Direction.DOWN),
    HOR_PIPE(Direction.LEFT, Direction.RIGHT),
    VERT_PIPE(Direction.DOWN, Direction.UP);

    private final Direction oneDirection;
    private final Direction otherDirection;

    Pipe(Direction oneDirection, Direction otherDirection) {
        this.oneDirection = oneDirection;
        this.otherDirection = otherDirection;
    }

    public static Pipe getDirectionFromCharacter(char character) {
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

    public Direction getOneDirection() {
        return oneDirection;
    }

    public Direction getOtherDirection() {
        return otherDirection;
    }
}
