package org.advent.daySeven;

public class HandFactory {

    public Hand createHand(String fullString, boolean isPartTwo) {
        return new Hand(
                fullString,
                isPartTwo
                );
    }


}
