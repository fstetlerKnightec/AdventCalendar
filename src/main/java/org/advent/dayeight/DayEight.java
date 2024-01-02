package org.advent.dayeight;

import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DayEight {

    public String rightLeftDirectionFromFile() throws IOException {
        return Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString()).get(0);
    }

    public List<String> allLeftRightNodes(List<String> listOfStrings) {
        return listOfStrings.subList(2, listOfStrings.size());
    }

    public Map<String, Node> nodeMap(List<String> listOfStrings) {
        return listOfStrings.stream()
                .collect(Collectors.toMap(
                        s -> s.substring(0,3),
                        s -> new Node(listOfStrings.indexOf(s), s.substring(0, 3), s.substring(7, 10), s.substring(12,15))
                        ));
    }


    public Node findNodeMapFromPointer(Map<String, Node> nodeMap, Node node, char direction) {
        if (direction == 'L') {
            return nodeMap.get(node.getLeftPointer());
        } else {
            return nodeMap.get(node.getRightPointer());
        }
    }

    public int numberOfStepsToReachEnd(List<String> listOfStrings, String directions) throws IOException {
        Map<String, Node> nodeMap = nodeMap(listOfStrings);
        int finalIndex = nodeMap.get("ZZZ").getIndex();
        int numberOfSteps = 0;
        String startingString = "AAA";
        Node currentNode = nodeMap.get(startingString);

        while (currentNode.getIndex() != finalIndex) {
            for (int i = 0; i < directions.length(); i++) {
                if (currentNode.getIndex() == finalIndex) {
                    break;
                }
                currentNode = findNodeMapFromPointer(nodeMap, currentNode, directions.charAt(i));
                numberOfSteps += 1;
            }
        }

        return numberOfSteps;
    }
}
