package com.codecool.battle;

import java.util.Map;

public class ComputerPlayer extends Player {
    
    public ComputerPlayer() {
        super();
    }

    @Override
    public String chooseAttribute() {
        Map.Entry<String, Integer> first = this.getHand().getTopCard().getAttributes().entrySet().iterator().next();
        String attribute = first.getKey();
        int maxCardValue = first.getValue();

        for (Map.Entry<String, Integer> entry : this.getHand().getTopCard().getAttributes().entrySet()) {
            if (entry.getValue() > maxCardValue) {
                maxCardValue = entry.getValue();
                attribute = entry.getKey();
            }
        }
        return attribute;
    }
}