package com.codecool.battle;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {
    private String name;
    private Map<String, Integer> attributes;
    private String[] image;

    Card(String name) {
        this.name = name;
        this.attributes = new HashMap<>();
    }

    private Card(String name, Map<String, Integer> attributes, String[] image) {
        this.name = name;
        this.attributes = new HashMap<>();
        for (String key : attributes.keySet()) {
            this.attributes.put(key, attributes.get(key));
        }
        this.image = new String[image.length];
        for (int i=0; i<image.length; i++) {
            this.image[i] = image[i];
        }
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
        return new Card(this.getName(), this.getAttributes(), this.getImage());
    }

    @Override
    public int compareTo(Card card) {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "\n");
        for (CardAttribute ca : CardAttribute.values()) {
            sb.append(ca.name() + ": " + attributes.get(ca.name()) + "\n");
        }
        return sb.toString();
    }
}
