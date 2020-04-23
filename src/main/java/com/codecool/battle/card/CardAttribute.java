package com.codecool.battle.card;

public enum CardAttribute {
    NUMBEROFTEETH(1), ROARVOLUME(2), MAXSPEED(3), WEIGHT(4);

    private final int value;

    CardAttribute(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
