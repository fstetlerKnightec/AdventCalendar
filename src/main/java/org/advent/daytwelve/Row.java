package org.advent.daytwelve;

import java.util.List;

public class Row {

    private final List<Integer> setupRule;

    private final List<Character> originalArrangement;

    private List<SpringArrangement> possibleArrangements;

    public Row(List<Integer> setupRule, List<Character> originalArrangement) {
        this.setupRule = setupRule;
        this.originalArrangement = originalArrangement;
    }

    public List<Integer> getSetupRule() {
        return setupRule;
    }

    public List<Character> getOriginalArrangement() {
        return originalArrangement;
    }

    public List<SpringArrangement> getPossibleArrangements() {
        return possibleArrangements;
    }

    public void setPossibleArrangements(List<SpringArrangement> possibleArrangements) {
        this.possibleArrangements = possibleArrangements;
    }
}
