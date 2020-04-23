package com.codecool.battle;

public enum CardAttribute {
    NUMBEROFTEETH(1), ROARVOLUME(2), MAXSPEED(3), WEIGHT(4);

    private final int value;

    private CardAttribute(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // public static String getAttrByInt(int index) {
    //     for (CardAttribute element : CardAttribute.values()) {
    //         if (element.value == index) {
    //             return element.name();
    //         }
    //     }
    //     return null;
    // }
}