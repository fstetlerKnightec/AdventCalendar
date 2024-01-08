package org.advent.daySeven;

public class HandFactory {

    public Hand createHand(String fullString, boolean isPartTwo, int bid) {
        return new Hand(
                fullString,
                isPartTwo,
                bid
                );
    }


}
