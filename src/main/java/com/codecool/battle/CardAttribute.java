package com.codecool.battle;

public enum CardAttribute {
    WEIGHT("Weight", 1), 
    ROARVOLUME("RoarVolume", 2), 
    MAXSPEED("MaxSpeed", 3), 
    NUMBEROFTEETH("NumberOfTeeth", 4);

    private final String attributeName;
    private final int value;
    
    private CardAttribute(String attributeName, int value) {
        this.attributeName = attributeName;
        this.value = value;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public int getValue() {
        return value;
    }
}