package org.advent.daySeven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class DaySeven {

//    public List<Hand> createListOfHands(List<String> listOfStrings) {
//        List<Hand> listOfHands = new ArrayList<>();
//
//        for (int i = 0; i < listOfStrings.size(); i++) {
//
//
//
//            Hand hand = new Hand()
//        }
//    }

    public Type typeOfHand(String string) {
        String handOfString = string.substring(0, string.indexOf(" "));

        if (handOfString.chars().allMatch(c -> c == handOfString.charAt(0))) {
            return Type.FIVE_OF_A_KIND;
        }

        if (handOfString.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size() == 2) {
            return Type.FOUR_OF_A_KIND;
        }

        if (handOfString.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size() == 3) {
            return Type.THREE_OF_A_KIND;
        }

        if (handOfString.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size() == 4) {
            return Type.ONE_PAIR;
        }

        if (handOfString.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size() == handOfString.length()) {
            return Type.HIGH_CARD;
        }

//        HashSet uniqueValues = new HashSet();
//        for (int i = 0; i < handOfString.length(); i++) {
//            if (!uniqueValues.add(handOfString.charAt(i))) {
//                return Type.HIGH_CARD;
//            };
//        }





        return null;
    }

    public void setTypeOfHand(String hand) {





    }



}
