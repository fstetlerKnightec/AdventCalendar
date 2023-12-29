package org.advent.dayeight;

import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DayEight {
    Util util = new Util();

    public String rightLeftDirectionFromFile() throws IOException {
        return util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString()).get(0);
    }

    public List<String> allLeftRightNodes() throws IOException {
        List<String> allStrings = util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString());
        return allStrings.subList(2, allStrings.size());
    }

}
