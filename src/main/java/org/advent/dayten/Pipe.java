package org.advent.dayten;

public enum Pipe {

    L_PIPE(Direction.UP, Direction.RIGHT),
    F_PIPE(Direction.DOWN, Direction.RIGHT),
    J_PIPE(Direction.LEFT, Direction.UP),
    SEVEN_PIPE(Direction.LEFT, Direction.DOWN),
    HOR_PIPE(Direction.LEFT, Direction.RIGHT),
    VERT_PIPE(Direction.DOWN, Direction.UP);


    private Direction oneDirection;
    private Direction otherDirection;

    private Pipe(Direction oneDirection, Direction otherDirection) {
        this.oneDirection = oneDirection;
        this.otherDirection = otherDirection;
    }

    public Direction getOneDirection() {
        return oneDirection;
    }

    public void setOneDirection(Direction oneDirection) {
        this.oneDirection = oneDirection;
    }

    public Direction getOtherDirection() {
        return otherDirection;
    }

    public void setOtherDirection(Direction otherDirection) {
        this.otherDirection = otherDirection;
    }

//    public Direction getDirectionToGoFromPipe(Pipe pipe, Position currentCoordinate, Position previousCoordinate) {
//        if (previousCoordinate.xPosition() == currentCoordinate.nextX(pipe.oneDirection)) {
//            return pipe.otherDirection;
//        }
//        return oneDirection;
//    }

//    public Pipe getDirectionFromCharacter(char character) {
//        if (character == '7') {
//            return SEVEN_PIPE;
//        }
//        if (character == 'L') {
//            return L_PIPE;
//        }
//        if (character == 'F') {
//            return F_PIPE;
//        }
//        if (character == 'J') {
//            return J_PIPE;
//        }
//        if (character == '-') {
//            return HOR_PIPE;
//        }
//        return VERT_PIPE;
//    }
}
