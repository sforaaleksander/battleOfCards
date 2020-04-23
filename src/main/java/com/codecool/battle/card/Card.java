package com.codecool.battle.card;

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
        System.arraycopy(image, 0, this.image, 0, image.length);
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
        super.clone();
        return new Card(this.getName(), this.getAttributes(), this.getImage());
    }

    @Override
    public int compareTo(Card card) {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        for (CardAttribute ca : CardAttribute.values()) {
            sb.append(ca.name()).append(": ").append(attributes.get(ca.name())).append("\n");
        }
        return sb.toString();
    }
}
