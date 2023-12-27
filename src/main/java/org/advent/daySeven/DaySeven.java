package org.advent.daySeven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DaySeven {



    public boolean isNumberOfUniqueCards(String handOfString, int uniqueCards) {
        return handOfString.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size() == uniqueCards;
    }

    public Type typeOfHand(String string) {
        String handOfString = string.substring(0, string.indexOf(" "));

        if (hasTwoPairsOrFullHouse(handOfString, TwoPairsOrFullHouse.TWO_PAIRS)) {
            return Type.TWO_PAIR;
        }

        if (hasTwoPairsOrFullHouse(handOfString, TwoPairsOrFullHouse.FULL_HOUSE)) {
            return Type.FULL_HOUSE;
        }

        if (isNumberOfUniqueCards(handOfString, 1)) {
            return Type.FIVE_OF_A_KIND;
        }

        if (isNumberOfUniqueCards(handOfString, 2)) {
            return Type.FOUR_OF_A_KIND;
        }

        if (isNumberOfUniqueCards(handOfString, 3)) {
            return Type.THREE_OF_A_KIND;
        }

        if (isNumberOfUniqueCards(handOfString, 4)) {
            return Type.ONE_PAIR;
        }

        if (isNumberOfUniqueCards(handOfString, 5)) {
            return Type.HIGH_CARD;
        }

        return null;
    }

    public boolean hasTwoPairsOrFullHouse(String handOfString, TwoPairsOrFullHouse twoPairsOrFullHouse) {
        Map<Character, Long> charCounts = handOfString.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        if (twoPairsOrFullHouse == TwoPairsOrFullHouse.TWO_PAIRS) {
            return charCounts.containsValue(1L) && charCounts.containsValue(2L) && charCounts.size() == 3;
        } else {
            return charCounts.containsValue(3L) && charCounts.containsValue(2L);
        }
    }
//
//    public int setCardValue(char card) {
//        List<Character> listOfCards = new ArrayList<>(Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'));
//        ))
//    }



}
