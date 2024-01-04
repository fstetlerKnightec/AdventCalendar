package org.advent.dayeight;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

        for (int i = 0; i < directions.length(); i++) {
            if (currentNode.getIndex() == finalIndex) {
                break;
            }

            currentNode = findNodeMapFromPointer(nodeMap, currentNode, directions.charAt(i));

            if (i == directions.length() - 1) {
                i = -1;
            }

            numberOfSteps += 1;
        }

        return numberOfSteps;
    }

    public Long numberOfStepsToReachAddressesEndingInZ(List<String> listOfStrings, String directions) {
        Map<String, Node> filteredMapStarting = getFilteredMap(nodeMap(listOfStrings), "A");

        Map<String, Node> nodeMap = nodeMap(listOfStrings);
        List<Node> listOfNodes = new ArrayList<>(filteredMapStarting.values());
        long numberOfSteps = 0L;

        for (int j = 0; j < directions.length(); j++) {
            boolean makeCalculation = false;
            for (Node node : listOfNodes) {
                if (!node.getAddress().endsWith("Z")) {
                    makeCalculation = true;
                    break;
                }
            }

            if (makeCalculation) {
                for (int i = 0; i < listOfNodes.size(); i++) {
                    Node currentNode = listOfNodes.get(i);
                    listOfNodes.set(i, findNodeMapFromPointer(nodeMap, currentNode, directions.charAt(j)));
                }

                if (j == directions.length() - 1) {
                    j = -1;
                }
                numberOfSteps += 1;
            }
        }
        return numberOfSteps;
    }



    public Map<String, Node> getFilteredMap(Map<String, Node> nodeMap, String letter) {
        return nodeMap.entrySet().stream().filter(entry -> entry.getValue().getAddress().endsWith(letter)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }



    private Long results(boolean isPartOne) throws IOException {
        List<String> allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString());
        List<String> leftRightNodeStrings = allLeftRightNodes(allStrings);
        String directions = rightLeftDirectionFromFile();

        if (isPartOne) {
            return (long) numberOfStepsToReachZZZ(leftRightNodeStrings, directions);
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
        System.out.println("Current time is " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("Total number of steps for part two = " + results(false));
        System.out.println("After calculation the time is " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
