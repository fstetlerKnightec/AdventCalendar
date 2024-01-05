package org.advent.daySeven;

import java.util.Comparator;
import java.util.List;

public class HandComparatorByRank implements Comparator<Hand> {

    private boolean isPartTwo;

    public HandComparatorByRank(boolean partOne) {
        this.isPartTwo = partOne;
    }


    @Override
    public int compare(Hand hand1, Hand hand2) {

        if (hand1.getType().getValue() != hand2.getType().getValue()) {
            if (hand1.getType().getValue() < hand2.getType().getValue()) {
                return -1;
            }
            if (hand1.getType().getValue() > hand2.getType().getValue()) {
                return 1;
            }
        } else {
            List<Character> listOfCards;
            if (isPartTwo) {
                listOfCards = List.of('J', '2', '3', '4', '5', '6', '7', '8', '9', 'T',  'Q', 'K', 'A');
            } else {
                listOfCards = List.of('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');
            }
            for (int i = 0; i < hand1.handString.length(); i++) {
                if (listOfCards.indexOf(hand1.handString.charAt(i)) > listOfCards.indexOf(hand2.handString.charAt(i))) {
                    return 1;
                }
                if (listOfCards.indexOf(hand1.handString.charAt(i)) < listOfCards.indexOf(hand2.handString.charAt(i))) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
