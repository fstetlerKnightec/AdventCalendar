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
    public Map<String, Node> nodeMap;

    public void setNodeMap(List<String> listOfStrings) {
        nodeMap = listOfStrings.stream()
                .collect(Collectors.toMap(
                        s -> s.substring(0, 3),
                        s -> new Node(s.substring(0, 3), s.substring(7, 10), s.substring(12, 15))
                ));
    }

    public long numberOfStepsToReachZZZ(String directions) {
        String startingAddress = "AAA";
        Node currentNode = nodeMap.get(startingAddress);
        return numberOfStepsToFindString(currentNode, directions, "ZZZ");
    }

    public long LCMOfAllPaths(String directions) {
        Map<String, Node> filteredMapStarting = getFilteredMap(nodeMap);
        List<Node> listOfNodes = new ArrayList<>(filteredMapStarting.values());
        List<Long> numberOfStepsList = new ArrayList<>();

        for (Node currentNode : listOfNodes) {
            numberOfStepsList.add(numberOfStepsToFindString(currentNode, directions, "Z"));
        }
        long lcmOfAllValues = lcm(numberOfStepsList.get(0), numberOfStepsList.get(1));
        if (numberOfStepsList.size() > 2) {
            for (int i = 2; i < numberOfStepsList.size(); i++) {
                lcmOfAllValues = lcm(lcmOfAllValues, numberOfStepsList.get(i));
            }
        }
        return lcmOfAllValues;
    }

    private long numberOfStepsToFindString(Node currentNode, String directions, String stringToFind) {
        long numberOfSteps = 0;
        for (int i = 0; i < directions.length(); i++) {
            if (currentNode.address().endsWith(stringToFind)) {
                break;
            }
            String foundNodeString = currentNode.findNodeMapFromPointer(directions.charAt(i));
            currentNode = nodeMap.get(foundNodeString);
            if (i == directions.length() - 1) {
                i = -1;
            }
            numberOfSteps += 1;
        }
        return numberOfSteps;
    }

    private Map<String, Node> getFilteredMap(Map<String, Node> nodeMap) {
        return nodeMap.entrySet().stream().filter(entry ->
                entry.getValue().address().endsWith("A")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private List<String> getStringsFromFile() {
        List<String> allStrings;
        try {
            allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allStrings;
    }

    private long results(boolean isPartOne) {
        List<String> allStringsFromList = getStringsFromFile();
        List<String> leftRightNodeStrings = allLeftRightNodes(allStringsFromList);
        String directions = allStringsFromList.getFirst();
        setNodeMap(leftRightNodeStrings);
        if (isPartOne) {
            return numberOfStepsToReachZZZ(directions);
        }
        return LCMOfAllPaths(directions);
    }

    private List<String> allLeftRightNodes(List<String> listOfStrings) {
        return listOfStrings.subList(2, listOfStrings.size());
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public void printPartOne() {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total number of steps for part one = " + results(true));
    }

    @Override
    public void printPartTwo() {
        System.out.println("Total number of steps for part two = " + results(false));
    }
}
