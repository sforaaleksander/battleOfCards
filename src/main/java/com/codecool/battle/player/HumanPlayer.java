package com.codecool.battle.player;

import com.codecool.battle.card.CardAttribute;
import com.codecool.battle.ui.UI;

public class HumanPlayer extends Player {

    public HumanPlayer(UI ui) {
        super(ui);
    }

    @Override
    public String chooseAttribute() {
        int userInput = ui.gatherIntInput("Enter the attribute number you choose", 1, 4);

        for (CardAttribute attribute : CardAttribute.values()) {
            if (userInput == attribute.getValue()) {
                return attribute.name();
            }
        }
        return null;
    }
}
