package org.advent.dayeight;

import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DayEight {

    public String rightLeftDirectionFromFile() throws IOException {
        return Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString()).get(0);
    }

    public List<String> allLeftRightNodes(List<String> listOfStrings) {
        return listOfStrings.subList(2, listOfStrings.size());
    }

    public List<Node> nodeList(List<String> listOfStrings) {
        return listOfStrings.stream().map(s -> new Node(listOfStrings.indexOf(s), s.substring(0, 3), s.substring(7, 10), s.substring(12, 15))).toList();
    }


    public Node findNodeFromPointer(List<String> listOfStrings, Node node, char direction) {
        if (direction == 'L') {
            return nodeList(listOfStrings).stream().filter(n -> Objects.equals(n.getAddress(), node.leftPointer)).toList().get(0);
        }
        return nodeList(listOfStrings).stream().filter(n -> Objects.equals(n.getAddress(), node.rightPointer)).toList().get(0);
    }

    public int numberOfStepsToReachEnd(List<String> listOfStrings, String directions) throws IOException {
        List<Node> listOfNodes = nodeList(listOfStrings);
        int currentIndex = 0;
        int finalIndex = listOfNodes.size() - 1;
        int numberOfSteps = 0;
        Node currentNode = listOfNodes.get(currentIndex);

        while (currentNode.getIndex() != finalIndex) {
            for (int i = 0; i < directions.length(); i++) {
                currentNode = findNodeFromPointer(listOfStrings, currentNode, directions.charAt(i));
                numberOfSteps += 1;
                if (currentNode.getIndex() == finalIndex) {
                    break;
                }
            }
        }

        return numberOfSteps;
    }



}
