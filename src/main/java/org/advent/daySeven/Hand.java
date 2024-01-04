package org.advent.daySeven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand {

    String fullString;
    String handString;
    String relevantCards;
    String restOfHand;
    int bid;
    Type type;
    int rank;
    boolean partOne;

    public Hand(String fullString) {
        this.fullString = fullString;
        this.handString = handOfString(fullString);
        this.relevantCards = stringOfRelevantCards();
//        this.restOfHand = findNonRelevantCardsInHand();
        this.type = typeOfHand(fullString);
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

    public String findNonRelevantCardsInHand() {
        List<Character> listOfNonRelevantCards = new ArrayList<>(handString.chars().mapToObj(ch -> (char) ch).toList());
        List<Character> listOfRelevantCards = stringOfRelevantCards().chars().mapToObj(ch -> (char) ch).toList();
        System.out.println(listOfRelevantCards);


        for (Character character : listOfRelevantCards) {
            listOfNonRelevantCards.remove(character);
        }

        System.out.println(listOfNonRelevantCards);
        return "hey";
    }


    public Map<Character, Integer> findAllMatchingLetters(String string) {

        Map<Character, Integer> charCounts = new HashMap<>();

        // Count occurrences of each character
        for (char c : string.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Print matching letters and their counts
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (entry.getValue() > 1) {
                return charCounts;
            }
        }
        return null;
    }

    public String stringOfRelevantCards() {
        List<Character> listOfCards = new ArrayList<>();

        Map<Character, Integer> mapOfLettersAndHowMany = findMultipleLetters(handString);

        for (Character character : mapOfLettersAndHowMany.keySet()) {
            for (int i = 0; i < mapOfLettersAndHowMany.get(character); i++) {
                listOfCards.add(character);
            }
        }
        return listOfCards.stream().map(String::valueOf).collect(Collectors.joining());
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

    public Type typeOfHand(String string) {
        Map<Character, Long> charCounts = handOfString(string).chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Map<Character, Integer> charactersAndHowMany = findAllMatchingLetters(handOfString(string));

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
