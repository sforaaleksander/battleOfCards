package com.codecool.battle;

public class HumanPlayer extends Player {
    private IO io;

    public HumanPlayer(IO io){
        super();
    }

    public IO getIo() {
        return io;
    }

    @Override
    public String chooseAttribute() {
        // TODO
        return null;
    }
}