package com.codecool.battle.player;

import java.util.Map;

import com.codecool.battle.ui.UI;

public class ComputerPlayer extends Player {
    private UI ui;
    private String smartOrLucky;

    public ComputerPlayer(UI ui) {
        super();
        this.ui = ui;
        this.smartOrLucky = getComputerSmartness();

    }

    private String getComputerSmartness(){
        return ui.getGenerator().nextInt(2) == 0 ? "SMART" : "LUCKY";
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
        ui.gatherEmptyInput("Press enter to continue.");
        return attribute;
    }
}
