package com.codecool.battle;

import java.util.Map;

public class ComputerPlayer extends Player {
    private UI ui;

    public ComputerPlayer(UI ui) {
        super();
        this.ui = ui;
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
                ui.printOnTable("chosen attribute: " + attribute);
            }
        }
        ui.getIo().gatherEmptyInput();
        return attribute;
    }
}
