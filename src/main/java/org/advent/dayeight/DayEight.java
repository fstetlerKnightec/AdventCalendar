package org.advent.dayeight;

import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayEight {

    public String rightLeftDirectionFromFile() throws IOException {
        return Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString()).get(0);
    }

    public List<String> allLeftRightNodes() throws IOException {
        List<String> allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString());
        return allStrings.subList(2, allStrings.size());
    }

    public List<Node> nodeList(List<String> listOfStrings) {
        return listOfStrings.stream().map(s -> new Node(listOfStrings.indexOf(s), s.substring(0, 3), s.substring(7, 10), s.substring(12, 15))).toList();
    }
}
