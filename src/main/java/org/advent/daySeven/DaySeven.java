package org.advent.daySeven;

import org.advent.PrintSolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.advent.daySeven.Hand.*;

public class DaySeven implements PrintSolution {


    public ArrayList<Hand> getListOfHands(List<String> listOfStrings) {
        ArrayList<Hand> arrayList = new ArrayList<>();
        for (String listOfString : listOfStrings) {
            arrayList.add(getHandFromString(listOfString));
        }
        return arrayList;
    }

    public List<Hand> sortedHandsByRank(ArrayList<Hand> listOfHands, boolean isPartOne) {
        listOfHands.sort(new HandComparatorByRank(isPartOne));
        return listOfHands;
    }

    public int totalWinnings(ArrayList<Hand> listOfSortedHands) {
        int value = 0;

        for (int i = 0; i < listOfSortedHands.size(); i++) {
            value += listOfSortedHands.get(i).getBid()*(i+1);
        }

        return value;
    }

    @Override
    public void printPartOne(int result) {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total winnings are = " + result);
    }

    @Override
    public void printPartTwo(int result) {

    }


//
//    public int setCardValue(char card) {
//
//        ))
//    }



}
