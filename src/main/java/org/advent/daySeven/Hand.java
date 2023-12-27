package org.advent.daySeven;

import java.util.Map;
import java.util.stream.Collectors;

public class Hand {

    String fullString;
    String handString;
    int bid;
    Type type;
    int rank;

    public Hand(String fullString) {
        this.fullString = fullString;
        this.handString = handOfString(fullString);
        this.type = typeOfHand(fullString);
        this.bid = bidOfHand(fullString);
    }

    public int bidOfHand(String string) {
        return Integer.parseInt(string.substring(string.indexOf(" ") + 1));
    }

    public String handOfString(String string) {
        return string.substring(0, string.indexOf(" "));
    }

    public Type typeOfHand(String string) {
        Map<Character, Long> charCounts = handOfString(string).chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));


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

    public void setHandString(String handString) {
        this.handString = handString;
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
