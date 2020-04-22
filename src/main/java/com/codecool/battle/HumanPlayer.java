package com.codecool.battle;

public class HumanPlayer extends Player {
    private IO io;

    public HumanPlayer(IO io){
        super();
        this.io = io;
    }

    public IO getIo() {
        return io;
    }

    @Override
    public String chooseAttribute() {
        int userInput = io.gatherIntInput("Enter the attribute number you choose", 1, 4);
        
        for (CardAttribute attribute : CardAttribute.values()) {
            if (userInput == attribute.getValue()) {
                return attribute.name();
            }
        }
		return null;
    }
}