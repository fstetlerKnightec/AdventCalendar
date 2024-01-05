package org.advent.daySeven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand {

    String fullString;
    String handString;
    List<Character> relevantCards;
    List<Character> restOfHand;
    int bid;
    Type type;

    public Hand(String fullString, boolean isPartTwo) {
        this.fullString = fullString;
        this.handString = handOfString(fullString);
        this.relevantCards = stringOfRelevantCards();
        this.restOfHand = findNonRelevantCardsInHand();
        this.type = typeOfHand(isPartTwo);
        this.bid = bidOfHand(fullString);
    }

    public int bidOfHand(String string) {
        return Integer.parseInt(string.substring(string.indexOf(" ") + 1));
    }

    public static Hand getHandFromString(String string, boolean isPartTwo) {
        return new Hand(string, isPartTwo);
    }

    public Type typeOfHand(boolean isPartTwo) {

        Type type = null;
        if (!allCardsMatch() && listIsSize(4)) {
            type = Type.TWO_PAIR;
            if (isPartTwo) {
                if (relevantCards.stream().anyMatch(ch -> ch.equals('J'))) {
                    type = Type.FOUR_OF_A_KIND;
                }
                else if (restOfHand.stream().anyMatch(ch -> ch.equals('J'))) {
                    type = Type.FULL_HOUSE;
                }
            }
        }

        if (!allCardsMatch() && listIsSize(5)) {
            type = Type.FULL_HOUSE;
            if (isPartTwo && relevantCards.stream().anyMatch(ch -> ch.equals('J'))) {
                type = Type.FIVE_OF_A_KIND;
            }
        }

        if (allCardsMatch() && listIsSize(5)) {
            type = Type.FIVE_OF_A_KIND;
        }

        if (allCardsMatch() && listIsSize(4)) {
            type = Type.FOUR_OF_A_KIND;
            if (isPartTwo) {
                if (restOfHand.stream().anyMatch(ch -> ch.equals('J')) || relevantCards.stream().allMatch(ch -> ch.equals('J'))) {
                    type = Type.FIVE_OF_A_KIND;
                }
            }
        }


        if (allCardsMatch() && listIsSize(3)) {
            type =  Type.THREE_OF_A_KIND;
            if (isPartTwo) {
                if (relevantCards.stream().allMatch(ch -> ch.equals('J')) || restOfHand.stream().filter(ch -> ch.equals('J')).count() == 1) {
                    type = Type.FOUR_OF_A_KIND;
                }
            }
        }

        if (allCardsMatch() && listIsSize(2)) {
            type =  Type.ONE_PAIR;
            if (isPartTwo) {
                if (relevantCards.stream().allMatch(ch -> ch.equals('J')) || restOfHand.stream().anyMatch(ch -> ch.equals('J'))) {
                    type = Type.THREE_OF_A_KIND;
                }
            }
        }

        if (relevantCards.isEmpty()) {
            type =  Type.HIGH_CARD;
            if (isPartTwo ) {
                if (restOfHand.stream().anyMatch(ch -> ch.equals('J')))
                    type = Type.ONE_PAIR;
            }
        }

        return type;
    }

    public boolean allCardsMatch() {
        return relevantCards.stream().allMatch(ch -> ch.equals(relevantCards.get(0)));
    }

    public Type getType() {
        return type;
    }

    public String getHandString() {
        return handString;
    }

    public int getBid() {
        return bid;
    }

    private Map<Character, Integer> findMultipleLetters(String string) {
        char[] charArray = string.toCharArray();

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : charArray) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    private List<Character> stringOfRelevantCards() {
        List<Character> listOfCards = new ArrayList<>();

        Map<Character, Integer> mapOfLettersAndHowMany = findMultipleLetters(handString);

        for (Character character : mapOfLettersAndHowMany.keySet()) {
            for (int i = 0; i < mapOfLettersAndHowMany.get(character); i++) {
                listOfCards.add(character);
            }
        }
        return listOfCards;
    }

    private boolean listIsSize(int size) {
        return relevantCards.size() == size;
    }


    private String handOfString(String string) {
        return string.substring(0, string.indexOf(" "));
    }

    private List<Character> findNonRelevantCardsInHand() {
        List<Character> listOfNonRelevantCards = new ArrayList<>(handString.chars().mapToObj(ch -> (char) ch).toList());
        List<Character> listOfRelevantCards = stringOfRelevantCards();
        for (Character character : listOfRelevantCards) {
            listOfNonRelevantCards.remove(character);
        }
        return listOfNonRelevantCards;
    }

}
