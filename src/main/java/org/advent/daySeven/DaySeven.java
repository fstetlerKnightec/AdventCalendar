package org.advent.daySeven;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.advent.daySeven.Hand.getHandFromString;

public class DaySeven implements PrintSolution {

    public List<Hand> getListOfHands(List<String> listOfStrings, boolean isPartTwo) {
        ArrayList<Hand> arrayList = new ArrayList<>();
        for (String listOfString : listOfStrings) {
            arrayList.add(getHandFromString(listOfString, isPartTwo));
        }
        return arrayList;
    }

    public List<Hand> sortedHandsByRank(List<Hand> listOfHands, boolean isPartTwo) {
        listOfHands.sort(new HandComparatorByRank(isPartTwo));
        return listOfHands;
    }

    public int totalWinnings(List<Hand> listOfSortedHands) {
        int value = 0;
        for (int i = 0; i < listOfSortedHands.size(); i++) {
            value += listOfSortedHands.get(i).getBid()*(i+1);
        }
        return value;
    }

    @Override
    public void printPartOne() {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total winnings are = " + results(false));
    }

    @Override
    public void printPartTwo() {
        System.out.println("Total winnings from part two are = " + results(true));
    }

    public int results(boolean isPartTwo) {
        List<String> listOfStrings;
        try {
            listOfStrings = Util.readStringsFromFile(Paths.get("src/main/resources/daySeven.txt").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Hand> listOfHands;
        if (!isPartTwo) {
            listOfHands = getListOfHands(listOfStrings, false);
            return totalWinnings(sortedHandsByRank(listOfHands, false));
        }
        listOfHands = getListOfHands(listOfStrings, true);
        return totalWinnings(sortedHandsByRank(listOfHands, true));
    }
}
