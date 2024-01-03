package org.advent.dayeight;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DayEight implements PrintSolution {

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

    public int numberOfStepsToReachZZZ(List<String> listOfStrings, String directions) throws IOException {
        Map<String, Node> nodeMap = nodeMap(listOfStrings);
        int finalIndex = nodeMap.get("ZZZ").getIndex();
        int numberOfSteps = 0;
        String startingAddress = "AAA";
        Node currentNode = nodeMap.get(startingAddress);

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

    public int numberOfStepsToReachAddressesEndingInZ(List<String> listOfStrings, String directions) {
        Map<String, Node> filteredMapStarting = getFilteredMap(nodeMap(listOfStrings), "A");

        List<Node> listOfNodes = new ArrayList<>(filteredMapStarting.values());
        int numberOfSteps = 0;
        while (!listOfNodes.stream().map(Node::getAddress).allMatch(s -> s.endsWith("Z"))) {
            for (int j = 0; j < directions.length(); j++) {
                if (listOfNodes.stream().allMatch(s -> s.getAddress().endsWith("Z"))) {
                    break;
                }
                for (int i = 0; i < listOfNodes.size(); i++) {
                    Node currentNode = listOfNodes.get(i);
                    listOfNodes.set(i, findNodeMapFromPointer(nodeMap(listOfStrings), currentNode, directions.charAt(j)));

                }

                numberOfSteps += 1;

            }

        }
        return numberOfSteps;
    }

    public Map<String, Node> getFilteredMap(Map<String, Node> nodeMap, String letter) {
        return nodeMap.entrySet().stream().filter(entry -> entry.getValue().getAddress().endsWith(letter)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }



    private int results(boolean isPartOne) throws IOException {
        List<String> allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString());
        List<String> leftRightNodeStrings = allLeftRightNodes(allStrings);
        String directions = rightLeftDirectionFromFile();

        List<String> listOfStrings = allLeftRightNodes(allStrings);
        System.out.println(numberOfStepsToReachAddressesEndingInZ(listOfStrings, directions));

        if (isPartOne) {
            return numberOfStepsToReachZZZ(leftRightNodeStrings, directions);
        }
        return numberOfStepsToReachAddressesEndingInZ(leftRightNodeStrings, directions);
    }

    @Override
    public void printPartOne() throws IOException {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total number of steps for part one = " + results(true));
    }

    @Override
    public void printPartTwo() throws IOException {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total number of steps for part two = " + results(false));
    }
}
