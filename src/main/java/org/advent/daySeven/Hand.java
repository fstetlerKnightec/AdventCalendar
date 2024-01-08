package org.advent.daySeven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand {
    private final String handString;
    private final List<Character> typeCards;
    private final List<Character> restOfHand;
    private final int bid;
    private final Type type;

    public Hand(String fullString, boolean isPartTwo) {
        this.handString = handOfString(fullString);
        this.typeCards = listOfTypeCards();
        this.restOfHand = findNonTypeCardsInHand();
        this.type = typeOfHand(isPartTwo);
        this.bid = bidOfHand(fullString);
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

    private List<Character> listOfTypeCards() {
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

        if (type == Type.TWO_PAIR
                && anyEqualsJ(typeCards)) {
            return Type.FOUR_OF_A_KIND;
        }

        if (type == Type.TWO_PAIR
                && anyEqualsJ(restOfHand)) {
            return Type.FULL_HOUSE;
        }

        if (type == Type.FULL_HOUSE
                && anyEqualsJ(typeCards)) {
            return Type.FIVE_OF_A_KIND;
        }

        if (type == Type.FOUR_OF_A_KIND
                && (anyEqualsJ(restOfHand) || allEqualsJ(typeCards))) {
            return Type.FIVE_OF_A_KIND;
        }

        if (type == Type.THREE_OF_A_KIND
                && (allEqualsJ(typeCards) || anyEqualsJ(restOfHand))) {
            return Type.FOUR_OF_A_KIND;
        }

        if (type == Type.ONE_PAIR
                && (allEqualsJ(typeCards) || anyEqualsJ(restOfHand))) {
            return Type.THREE_OF_A_KIND;
        }

        if (type == Type.HIGH_CARD
                && anyEqualsJ(restOfHand)) {
            return Type.ONE_PAIR;
        }

        return type;
    }

    private boolean anyEqualsJ(List<Character> chars) {
        return chars.stream().anyMatch(ch -> ch.equals('J'));
    }

    private boolean allEqualsJ(List<Character> chars) {
        return chars.stream().allMatch(ch -> ch.equals('J'));
    }

    private Type typeOfHand(boolean isPartTwo) {

        Type type = null;
        boolean allCardsMatch = allCardsMatch();
        if (!allCardsMatch && isListSize(4)) {
            type = Type.TWO_PAIR;
        }

        if (!allCardsMatch && isListSize(5)) {
            type = Type.FULL_HOUSE;
        }

        if (allCardsMatch && isListSize(5)) {
            type = Type.FIVE_OF_A_KIND;
        }

        if (allCardsMatch && isListSize(4)) {
            type = Type.FOUR_OF_A_KIND;
        }

        if (allCardsMatch && isListSize(3)) {
            type = Type.THREE_OF_A_KIND;
        }

        if (allCardsMatch && isListSize(2)) {
            type = Type.ONE_PAIR;
        }

        if (typeCards.isEmpty()) {
            type = Type.HIGH_CARD;
        }

        if (isPartTwo) {
            type = includeJokers(type);
        }

        return type;
    }

    private boolean isListSize(int size) {
        return typeCards.size() == size;
    }

    private boolean allCardsMatch() {
        return typeCards.stream().allMatch(ch -> ch.equals(typeCards.get(0)));
    }

    private String handOfString(String string) {
        return string.substring(0, string.indexOf(" "));
    }

    private List<Character> findNonTypeCardsInHand() {
        List<Character> listOfNonTypeCards = new ArrayList<>(handString.chars().mapToObj(ch -> (char) ch).toList());
        for (Character character : typeCards) {
            listOfNonTypeCards.remove(character);
        }
        return listOfNonTypeCards;
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
}
