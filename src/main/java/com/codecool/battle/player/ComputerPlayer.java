package com.codecool.battle.player;

import java.util.Map;

import com.codecool.battle.card.CardAttribute;
import com.codecool.battle.ui.UI;

public class ComputerPlayer extends Player {
    private String smartOrLucky;

    public ComputerPlayer(UI ui) {
        super(ui);
        this.smartOrLucky = getComputerSmartness();
    }

    private String getComputerSmartness() {
        return ui.getGenerator().nextInt(2) == 0 ? "SMART" : "LUCKY";
    }

    private String chooseSmart() {
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
        ui.gatherEmptyInput("chosen attribute: " + attribute);
        return attribute;
    }

    private String chooseLucky() {
        int randomInt = ui.getGenerator().nextInt(4);
        String randomAttribute = CardAttribute.values()[randomInt].name();
        ui.gatherEmptyInput("chosen attribute: " + randomAttribute);
        return randomAttribute;
    }

    @Override
    public String chooseAttribute() {
        if (smartOrLucky.equals("SMART")) {
            return chooseSmart();
        }
        return chooseLucky();
    }
}
