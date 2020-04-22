package com.codecool.battle;

public class HumanPlayer extends Player {
    private UI ui;

    public HumanPlayer(UI ui){
        super();
        this.ui = ui;
    }

    public UI getUi() {
        return ui;
    }

    @Override
    public String chooseAttribute() {
        int userInput = ui.getIo().gatherIntInput("Enter the attribute number you choose", 1, 4);
        
        for (CardAttribute attribute : CardAttribute.values()) {
            if (userInput == attribute.getValue()) {
                return attribute.name();
            }
        }
		return null;
    }
}