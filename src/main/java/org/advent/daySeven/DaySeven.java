package org.advent.daySeven;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.advent.daySeven.Hand.*;

public class DaySeven {


    public List<Hand> getListOfHands(List<String> listOfStrings) {
        return listOfStrings.stream().map(this::getHandFromString).toList();
    }

    public Hand getHandFromString(String string) {
        return new Hand(string);
    }










//
//    public int setCardValue(char card) {
//        List<Character> listOfCards = new ArrayList<>(Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'));
//        ))
//    }



}
