package org.advent.dayeight;

import java.util.Map;

public record Node(String address, String leftPointer, String rightPointer) {

    public String findNodeMapFromPointer(char direction) {
        if (direction == 'L') {
            return leftPointer;
        }
        return rightPointer;

    }
}
