package org.advent.dayten;

public enum Direction {

    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    public static Direction getDirection(char c, Position position, int x, int y) {
//        if (c == 'L') {
//            if (previousPositionWasAbove(position, x, y)) {
//                return RIGHT;
//            }
//            return UP;
//        }
//
//        if (c == '-') {
//            if (previousPositionWasToLeft(position, x, y)) {
//                return Direction.RIGHT;
//            }
//            return Direction.LEFT;
//        }
//
//        if (c == '7') {
//            if (previousPositionWasToLeft(position, x, y)) {
//                return Direction.DOWN;
//            }
//            return Direction.LEFT;
//        }
//
//        if (c == '|') {
//            if (previousPositionWasAbove(position, x, y)) {
//                return Direction.DOWN;
//            }
//            return Direction.UP;
//        }
//
//        if (c == 'J') {
//            if (previousPositionWasToLeft(position, x, y)) {
//                return Direction.UP;
//            }
//            return Direction.LEFT;
//        }
//
//        if (previousPositionWasBelow(position, x, y)) {
//            return Direction.RIGHT;
//        }
//        return Direction.DOWN;
//    }
//
//    private static boolean previousPositionWasAbove(Position previousPosition, int x, int y) {
//        return previousPosition.yPosition() == y - 1;
//    }
//
//    private static boolean previousPositionWasToLeft(Position previousPosition, int x, int y) {
//        return previousPosition.xPosition() == x - 1;
//    }
//
//    private static boolean previousPositionWasBelow(Position previousPosition, int x, int y) {
//        return previousPosition.yPosition() == y + 1;
//    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
