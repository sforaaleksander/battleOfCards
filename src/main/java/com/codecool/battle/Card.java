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

    public void setAttributeByType(String type, Integer value) {
        attributes.put(type, value);
    }

    public String getName() {
        return name;
    }

    public int getValueByType(String type) {
        return attributes.get(type);
    }

    public Map<String, Integer> getAttributes() {
        return attributes;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "\n");
        for (String key : attributes.keySet()) {
            sb.append(key + ": " + attributes.get(key) + "\n");
        }
        return sb.toString();
    }
}
