package com.codecool.battle;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String name;
    private Map<String, Integer> attributes;
    private String[] image;

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

    public String[] getImage() {
        return image;
    }

    public void setImage(String[] image) {
        this.image = image;
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
}
