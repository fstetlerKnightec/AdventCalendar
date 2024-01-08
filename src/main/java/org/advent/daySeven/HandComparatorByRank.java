package org.advent.daySeven;

import java.util.Comparator;
import java.util.List;

public class HandComparatorByRank implements Comparator<Hand> {

    private final boolean isPartTwo;

    public HandComparatorByRank(boolean isPartTwo) {

        this.isPartTwo = isPartTwo;
    }

    @Override
    public int compare(Hand hand1, Hand hand2) {

        int value1 = hand1.getTypeOfHand(isPartTwo).getValue();
        int value2 = hand2.getTypeOfHand(isPartTwo).getValue();

        String handString1 = hand1.getFullString().substring(0,6);
        String handString2 = hand2.getFullString().substring(0,6);
        if (value1 != value2) {
            if (value1 < value2) {
                return -1;
            }
            return 1;
        } else {
            List<Character> listOfCards;
            if (isPartTwo) {
                listOfCards = List.of('J', '2', '3', '4', '5', '6', '7', '8', '9', 'T',  'Q', 'K', 'A');
            } else {
                listOfCards = List.of('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');
            }
            for (int i = 0; i < handString1.length(); i++) {
                if (listOfCards.indexOf(handString1.charAt(i)) > listOfCards.indexOf(handString2.charAt(i))) {
                    return 1;
                }
                if (listOfCards.indexOf(handString1.charAt(i)) < listOfCards.indexOf(handString2.charAt(i))) {
                    return -1;
                }
            }
        }
        return 0;

    }
}
