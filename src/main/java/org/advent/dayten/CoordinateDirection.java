package org.advent.dayten;

public enum CoordinateDirection {

    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int x;
    private final int y;

    CoordinateDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static CoordinateDirection getDirection(char c, Position position, int x, int y) {
        if (c == 'L') {
            if (DOWN.previousPositionWasAbove(position, x, y)) {
                return RIGHT;
            }
            return UP;
        }

        if (c == '-') {
            if (DOWN.previousPositionWasToLeft(position, x, y)) {
                return CoordinateDirection.RIGHT;
            }
            return CoordinateDirection.LEFT;
        }

        if (c == '7') {
            if (DOWN.previousPositionWasToLeft(position, x, y)) {
                return CoordinateDirection.DOWN;
            }
            return CoordinateDirection.LEFT;
        }

        if (c == '|') {
            if (DOWN.previousPositionWasAbove(position, x, y)) {
                return CoordinateDirection.DOWN;
            }
            return CoordinateDirection.UP;
        }

        if (c == 'J') {
            if (DOWN.previousPositionWasToLeft(position, x, y)) {
                return CoordinateDirection.UP;
            }
            return CoordinateDirection.LEFT;
        }

        if (DOWN.previousPositionWasBelow(position, x, y)) {
            return CoordinateDirection.RIGHT;
        }
        return CoordinateDirection.DOWN;
    }

    private boolean previousPositionWasAbove(Position previousPosition, int x, int y) {
        return previousPosition.yPosition() == y - 1;
    }

    private boolean previousPositionWasToLeft(Position previousPosition, int x, int y) {
        return previousPosition.xPosition() == x - 1;
    }

    private boolean previousPositionWasBelow(Position previousPosition, int x, int y) {
        return previousPosition.yPosition() == y + 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
