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
    int rank;
    boolean partOne;

    public Hand(String fullString) {
        this.fullString = fullString;
        this.handString = handOfString(fullString);
        this.relevantCards = stringOfRelevantCards();
        this.restOfHand = findNonRelevantCardsInHand();
        this.type = typeOfHand();
        this.bid = bidOfHand(fullString);
    }

    public int bidOfHand(String string) {
        return Integer.parseInt(string.substring(string.indexOf(" ") + 1));
    }

    public static Hand getHandFromString(String string) {
        return new Hand(string);
    }

    public String handOfString(String string) {
        return string.substring(0, string.indexOf(" "));
    }

    public List<Character> findNonRelevantCardsInHand() {
        List<Character> listOfNonRelevantCards = new ArrayList<>(handString.chars().mapToObj(ch -> (char) ch).toList());
        List<Character> listOfRelevantCards = stringOfRelevantCards();
        for (Character character : listOfRelevantCards) {
            listOfNonRelevantCards.remove(character);
        }
        return listOfNonRelevantCards;
    }


    public List<Character> stringOfRelevantCards() {
        List<Character> listOfCards = new ArrayList<>();

        Map<Character, Integer> mapOfLettersAndHowMany = findMultipleLetters(handString);

        for (Character character : mapOfLettersAndHowMany.keySet()) {
            for (int i = 0; i < mapOfLettersAndHowMany.get(character); i++) {
                listOfCards.add(character);
            }
        }
        return listOfCards;
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

    public Type typeOfHand() {
        if (!relevantCards.stream().allMatch(ch -> ch.equals(relevantCards.get(0))) && relevantCards.size() == 4) {

            return Type.TWO_PAIR;
        }

        if (!relevantCards.stream().allMatch(ch -> ch.equals(relevantCards.get(0))) && relevantCards.size() == 5) {
            return Type.FULL_HOUSE;
        }

        if (relevantCards.stream().allMatch(ch -> ch.equals(relevantCards.get(0))) && relevantCards.size() == 5) {
            return Type.FIVE_OF_A_KIND;
        }

        if (relevantCards.stream().allMatch(ch -> ch.equals(relevantCards.get(0))) && relevantCards.size() == 4) {
            return Type.FOUR_OF_A_KIND;
        }

        if (relevantCards.stream().allMatch(ch -> ch.equals(relevantCards.get(0))) && relevantCards.size() == 3) {
            return Type.THREE_OF_A_KIND;
        }

        if (relevantCards.stream().allMatch(ch -> ch.equals(relevantCards.get(0))) && relevantCards.size() == 2) {
            return Type.ONE_PAIR;
        }

        if (relevantCards.isEmpty()) {
            return Type.HIGH_CARD;
        }
        return null;
    }


    public String getFullString() {
        return fullString;
    }

    public void setFullString(String fullString) {
        this.fullString = fullString;
    }

    public void setHandString(String handString) {
        this.handString = handString;
    }

    public List<Character> getRelevantCards() {
        return relevantCards;
    }

    public void setRelevantCards(List<Character> relevantCards) {
        this.relevantCards = relevantCards;
    }

    public List<Character> getRestOfHand() {
        return restOfHand;
    }

    public void setRestOfHand(List<Character> restOfHand) {
        this.restOfHand = restOfHand;
    }

    public boolean isPartOne() {
        return partOne;
    }

    public void setPartOne(boolean partOne) {
        this.partOne = partOne;
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

    public void setBid(int bid) {
        this.bid = bid;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
