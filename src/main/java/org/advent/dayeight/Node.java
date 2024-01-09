package org.advent.dayeight;

import java.util.Map;

public record Node(String address, String leftPointer, String rightPointer) {

    public Node findNodeMapFromPointer(Map<String, Node> nodeMap, char direction) {
        if (direction == 'L') {
            return nodeMap.get(leftPointer);
        } else {
            return nodeMap.get(rightPointer);
        }
    }
}
