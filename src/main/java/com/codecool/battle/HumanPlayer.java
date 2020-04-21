package com.codecool.battle;

import java.util.Map;

public class HumanPlayer extends Player {
    private IO io;
    
    public HumanPlayer(IO io){
        super();
        this.io = io;
    }

    @Override
    public String chooseAttribute() {
        int userInput = io.gatherIntInput("Enter the attribute number you choose", 4);
        String attribute = "Error";
        int index = 0;
        for (Map.Entry<String, Integer> entry : this.getHand().getTopCard().getAttributes().entrySet()) {
            if (index == userInput) {
                attribute = entry.getKey();
                return attribute;
            }
            index++;
        }
		return attribute;
    }
}