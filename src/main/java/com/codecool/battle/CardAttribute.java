package com.codecool.battle;

public enum CardAttribute {
    WEIGHT(1), 
    ROARVOLUME(2), 
    MAXSPEED(3), 
    NUMBEROFTEETH(4);

    private final int value;

    private CardAttribute(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}