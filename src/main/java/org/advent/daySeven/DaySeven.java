package org.advent.daySeven;

import java.util.Map;
import java.util.stream.Collectors;

public class DaySeven {


    public Type typeOfHand(String string) {
        String handOfString = string.substring(0, string.indexOf(" "));
        Map<Character, Long> charCounts = handOfString.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));


        if (charCounts.containsValue(1L) && charCounts.containsValue(2L) && charCounts.size() == 3) {
            return Type.TWO_PAIR;
        }

        if (charCounts.containsValue(3L) && charCounts.containsValue(2L)) {
            return Type.FULL_HOUSE;
        }

        if (charCounts.containsValue(5L) && charCounts.size() == 1) {
            return Type.FIVE_OF_A_KIND;
        }

        if (charCounts.containsValue(4L) && charCounts.size() == 2) {
            return Type.FOUR_OF_A_KIND;
        }

        if (charCounts.containsValue(3L) && charCounts.size() == 3) {
            return Type.THREE_OF_A_KIND;
        }

        if (charCounts.containsValue(2L) && charCounts.size() == 4) {
            return Type.ONE_PAIR;
        }

        if (charCounts.containsValue(1L) && charCounts.size() == 5) {
            return Type.HIGH_CARD;
        }

        return null;
    }


//
//    public int setCardValue(char card) {
//        List<Character> listOfCards = new ArrayList<>(Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'));
//        ))
//    }



}
