package org.advent.daySeven;

public enum Type {

    HIGH_CARD(1),
    ONE_PAIR(2),
    TWO_PAIR(3),
    THREE_OF_A_KIND(4),
    FULL_HOUSE(5),
    FOUR_OF_A_KIND(6),
    FIVE_OF_A_KIND(7);

    public Type next() {
        return values()[ordinal() + 1];
    }

    private int value;

    private Type(int value) {
        this.value = value;
    }



    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
