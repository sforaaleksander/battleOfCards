package com.codecool.battle;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String name;
    private Map<String, Integer> attributes;

    Card(String name) {
        this.name = name;
        this.attributes = new HashMap<>();
    }


    public void setAttributeByType(String type, Integer value){
        attributes.put(type, value);
    }

    public String getName() {
        return name;
    }

    public int getValueByType(String type){
        return attributes.get(type);
    }
}
