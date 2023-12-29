package org.advent.dayeight;

import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DayEight {

    public String rightLeftDirectionFromFile() throws IOException {
        return Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString()).get(0);
    }

    public List<String> allLeftRightNodes() throws IOException {
        List<String> allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString());
        return allStrings.subList(2, allStrings.size());
    }

}
