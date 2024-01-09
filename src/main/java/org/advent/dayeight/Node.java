package org.advent.dayeight;

public record Node(String address, String leftPointer, String rightPointer) {

    public String findNodeMapFromPointer(char direction) {
        if (direction == 'L') {
            return leftPointer;
        }
        return rightPointer;

    }
}
