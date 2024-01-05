package org.advent.daySeven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand {
    String handString;
    List<Character> relevantCards;
    List<Character> restOfHand;
    int bid;
    Type type;

    public Hand(String fullString, boolean isPartTwo) {
        this.handString = handOfString(fullString);
        this.relevantCards = listOfRelevantCards();
        this.restOfHand = findNonRelevantCardsInHand();
        this.type = typeOfHand(isPartTwo);
        this.bid = bidOfHand(fullString);
    }

    public static Hand getHandFromString(String string, boolean isPartTwo) {
        return new Hand(string, isPartTwo);
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

    private int bidOfHand(String string) {
        return Integer.parseInt(string.substring(string.indexOf(" ") + 1));
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

    private List<Character> listOfRelevantCards() {
        List<Character> listOfCards = new ArrayList<>();
        Map<Character, Integer> mapOfLettersAndHowMany = findMultipleLetters(handString);
        for (Character character : mapOfLettersAndHowMany.keySet()) {
            for (int i = 0; i < mapOfLettersAndHowMany.get(character); i++) {
                listOfCards.add(character);
            }
        }
        return listOfCards;
    }

    private Type includeJokers(Type type) {
        if (type == Type.TWO_PAIR) {
            if (relevantCards.stream().anyMatch(ch -> ch.equals('J'))) {
                return Type.FOUR_OF_A_KIND;
            }
            if (restOfHand.stream().anyMatch(ch -> ch.equals('J'))) {
                return Type.FULL_HOUSE;
            }
        }

        if (type == Type.FULL_HOUSE) {
            if (relevantCards.stream().anyMatch(ch -> ch.equals('J'))) {
                return Type.FIVE_OF_A_KIND;
            }
        }

        if (type == Type.FOUR_OF_A_KIND) {
            if (restOfHand.stream().anyMatch(ch -> ch.equals('J')) || relevantCards.stream().allMatch(ch -> ch.equals('J'))) {
                return Type.FIVE_OF_A_KIND;
            }
        }

        if (type == Type.THREE_OF_A_KIND) {
            if (relevantCards.stream().allMatch(ch -> ch.equals('J')) || restOfHand.stream().filter(ch -> ch.equals('J')).count() == 1) {
                return Type.FOUR_OF_A_KIND;
            }
        }

        if (type == Type.ONE_PAIR) {
            if (relevantCards.stream().allMatch(ch -> ch.equals('J')) || restOfHand.stream().anyMatch(ch -> ch.equals('J'))) {
                return Type.THREE_OF_A_KIND;
            }
        }

        if (type == Type.HIGH_CARD) {
            if (restOfHand.stream().anyMatch(ch -> ch.equals('J'))) {
                return Type.ONE_PAIR;
            }
        }

        return type;
    }

    private Type typeOfHand(boolean isPartTwo) {

        Type type = null;
        if (!allCardsMatch() && isListSize(4)) {
            type = Type.TWO_PAIR;
            if (isPartTwo) {
                type = includeJokers(type);
            }
        }

        if (!allCardsMatch() && isListSize(5)) {
            type = Type.FULL_HOUSE;
            if (isPartTwo) {
                type = includeJokers(type);
            }
        }

        if (allCardsMatch() && isListSize(5)) {
            type = Type.FIVE_OF_A_KIND;
        }

        if (allCardsMatch() && isListSize(4)) {
            type = Type.FOUR_OF_A_KIND;
            if (isPartTwo) {
                type = includeJokers(type);
            }
        }

        if (allCardsMatch() && isListSize(3)) {
            type = Type.THREE_OF_A_KIND;
            if (isPartTwo) {
                type = includeJokers(type);
            }
        }

        if (allCardsMatch() && isListSize(2)) {
            type = Type.ONE_PAIR;
            if (isPartTwo) {
                type = includeJokers(type);
            }
        }

        if (relevantCards.isEmpty()) {
            type = Type.HIGH_CARD;
            if (isPartTwo) {
                type = includeJokers(type);
            }
        }

        return type;
    }

    private boolean isListSize(int size) {
        return relevantCards.size() == size;
    }

    private boolean allCardsMatch() {
        return relevantCards.stream().allMatch(ch -> ch.equals(relevantCards.get(0)));
    }

    private String handOfString(String string) {
        return string.substring(0, string.indexOf(" "));
    }

    private List<Character> findNonRelevantCardsInHand() {
        List<Character> listOfNonRelevantCards = new ArrayList<>(handString.chars().mapToObj(ch -> (char) ch).toList());
        List<Character> listOfRelevantCards = listOfRelevantCards();
        for (Character character : listOfRelevantCards) {
            listOfNonRelevantCards.remove(character);
        }
        return listOfNonRelevantCards;
    }

}
