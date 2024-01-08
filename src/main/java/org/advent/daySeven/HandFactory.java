package org.advent.daySeven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HandFactory {

    public Hand createHand(String fullString, boolean isPartTwo, int bid) {
        return new Hand(
                fullString,
                isPartTwo,
                bid
                );
    }


}
