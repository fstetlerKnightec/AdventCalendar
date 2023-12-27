package org.advent.daySeven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.advent.daySeven.Hand.*;

public class DaySeven {


    public ArrayList<Hand> getListOfHands(List<String> listOfStrings) {
        ArrayList<Hand> arrayList = new ArrayList<>();
        for (String listOfString : listOfStrings) {
            arrayList.add(getHandFromString(listOfString));
        }
        return arrayList;
    }

    public List<Hand> sortedHandsByRank(ArrayList<Hand> listOfHands) {
        listOfHands.sort(new HandComparatorByRank());
        return listOfHands;
    }












//
//    public int setCardValue(char card) {
//
//        ))
//    }



}
