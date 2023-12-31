package org.advent.daySeven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record Hand(String fullString, boolean isPartTwo) implements Comparable<Hand> {

    public int getBid() {
        return bidOfHand(fullString);
    }

    public Type getTypeOfHand() {

        Type type = null;
        boolean allCardsMatch = allCardsMatch(fullString);
        if (!allCardsMatch && isListSize(fullString, 4)) {
            type = Type.TWO_PAIR;
        }

        if (!allCardsMatch && isListSize(fullString, 5)) {
            type = Type.FULL_HOUSE;
        }

        if (allCardsMatch && isListSize(fullString, 5)) {
            type = Type.FIVE_OF_A_KIND;
        }

        if (allCardsMatch && isListSize(fullString, 4)) {
            type = Type.FOUR_OF_A_KIND;
        }

        if (allCardsMatch && isListSize(fullString, 3)) {
            type = Type.THREE_OF_A_KIND;
        }

        if (allCardsMatch && isListSize(fullString, 2)) {
            type = Type.ONE_PAIR;
        }

        if (typeCards(fullString).isEmpty()) {
            type = Type.HIGH_CARD;
        }

        if (isPartTwo) {
            type = includeJokers(fullString, type);
        }

        return type;
    }

    public boolean isListSize(String fullString, int size) {
        return typeCards(fullString).size() == size;
    }

    public int bidOfHand(String string) {
        return Integer.parseInt(string.substring(string.indexOf(" ") + 1));
    }

    public boolean allCardsMatch(String fullString) {
        return typeCards(fullString).stream().allMatch(ch -> ch.equals(typeCards(fullString).get(0)));
    }

    public Type includeJokers(String fullString, Type type) {

        if (type == Type.TWO_PAIR
                && anyEqualsJ(typeCards(fullString))) {
            return Type.FOUR_OF_A_KIND;
        }

        if (type == Type.TWO_PAIR
                && anyEqualsJ(nonTypeCardsInHand(fullString))) {
            return Type.FULL_HOUSE;
        }

        if (type == Type.FULL_HOUSE
                && anyEqualsJ(typeCards(fullString))) {
            return Type.FIVE_OF_A_KIND;
        }

        if (type == Type.FOUR_OF_A_KIND
                && (anyEqualsJ(nonTypeCardsInHand(fullString)) || allEqualsJ(typeCards(fullString)))) {
            return Type.FIVE_OF_A_KIND;
        }

        if (type == Type.THREE_OF_A_KIND
                && (allEqualsJ(typeCards(fullString)) || anyEqualsJ(nonTypeCardsInHand(fullString)))) {
            return Type.FOUR_OF_A_KIND;
        }

        if (type == Type.ONE_PAIR
                && (allEqualsJ(typeCards(fullString)) || anyEqualsJ(nonTypeCardsInHand(fullString)))) {
            return Type.THREE_OF_A_KIND;
        }

        if (type == Type.HIGH_CARD
                && anyEqualsJ(nonTypeCardsInHand(fullString))) {
            return Type.ONE_PAIR;
        }

        return type;
    }

    public boolean anyEqualsJ(List<Character> chars) {
        return chars.stream().anyMatch(ch -> ch.equals('J'));
    }

    public boolean allEqualsJ(List<Character> chars) {
        return chars.stream().allMatch(ch -> ch.equals('J'));
    }

    public String handOfString(String string) {
        return string.substring(0, string.indexOf(" "));
    }

    public List<Character> nonTypeCardsInHand(String fullString) {
        List<Character> listOfNonTypeCards = new ArrayList<>(handOfString(fullString).chars().mapToObj(ch -> (char) ch).toList());
        for (Character character : typeCards(fullString)) {
            listOfNonTypeCards.remove(character);
        }
        return listOfNonTypeCards;
    }

    public List<Character> typeCards(String fullString) {
        List<Character> listOfCards = new ArrayList<>();
        Map<Character, Integer> mapOfLettersAndHowMany = findMultipleLetters(handOfString(fullString));
        for (Character character : mapOfLettersAndHowMany.keySet()) {
            for (int i = 0; i < mapOfLettersAndHowMany.get(character); i++) {
                listOfCards.add(character);
            }
        }
        return listOfCards;
    }

    public Map<Character, Integer> findMultipleLetters(String string) {
        char[] charArray = string.toCharArray();

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : charArray) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public List<Character> listOfCards(boolean isPartTwo) {
        if (isPartTwo) {
            return List.of('J', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'Q', 'K', 'A');
        }
        return List.of('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');
    }

    @Override
    public int compareTo(Hand other) {

        if (other == null) {
            return 1;
        }
        String handString1 = this.fullString.substring(0, 6);
        String handString2 = other.fullString.substring(0, 6);

        if (this.getTypeOfHand().ordinal() > other.getTypeOfHand().ordinal()) {
            return 1;
        }
        if (this.getTypeOfHand().ordinal() < other.getTypeOfHand().ordinal()) {
            return -1;
        } else {
            List<Character> listOfCards = listOfCards(isPartTwo);
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
