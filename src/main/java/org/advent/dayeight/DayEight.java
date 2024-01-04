package org.advent.dayeight;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DayEight implements PrintSolution {

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

        List<Node> listOfNodes = new ArrayList<>(filteredMapStarting.values());
        List<Integer> numberOfStepsList = new ArrayList<>();

        for (Node currentNode : listOfNodes) {
        int number = 0;
            for (int j = 0; j < directions.length(); j++) {
                if (currentNode.getAddress().endsWith("Z")) {
                    break;
                }
                currentNode = findNodeMapFromPointer(nodeMap(listOfStrings), currentNode, directions.charAt(j));
                number += 1;
                if (j == directions.length() - 1) {
                    j = -1;
                }
            }
            numberOfStepsList.add(number);
        }

        long lcm1 = lcm(numberOfStepsList.get(0), numberOfStepsList.get(1));

        if (numberOfStepsList.size() > 2) {
            for (int i = 2; i < numberOfStepsList.size(); i++) {
                lcm1 = lcm(lcm1, numberOfStepsList.get(i));
            }
        }
        return lcm1;
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

    private Map<String, Node> getFilteredMap(Map<String, Node> nodeMap, String letter) {
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

    private static long lcm(long a, long b) {
        return ((long) a * b) / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private String rightLeftDirectionFromFile() throws IOException {
        return Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString()).get(0);
    }

    private List<String> allLeftRightNodes(List<String> listOfStrings) {
        return listOfStrings.subList(2, listOfStrings.size());
    }
}
