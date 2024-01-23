package org.advent.daytwelve;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DayTwelve implements PrintSolution {
    @Override
    public void printPartOne() {
        System.out.println(getStringsFromFile().getFirst());
    }

    @Override
    public void printPartTwo() {

    }

    public List<Integer> getSetupRuleFromString(String s) {
        String sub = s.split(" ")[1];
        sub = sub.replaceAll(",", "");
        return sub.chars().mapToObj(c -> Character.valueOf((char) c)).toList();
    }

    public List<Character> getOriginalArrangementFromString(String s) {
        String sub = s.split(" ")[0];
        return sub.chars().mapToObj(c -> (char) c).toList();
    }


    public List<Row> getRows(List<String> strings) {
        return strings.stream().map(s ->
                new Row(getSetupRuleFromString(s), getOriginalArrangementFromString(s))).toList();
    }


    private List<String> getStringsFromFile() {
        List<String> allStrings;
        try {
            allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayTwelve.txt").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allStrings;
    }

}
