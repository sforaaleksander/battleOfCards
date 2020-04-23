package com.codecool.battle;

import com.github.tomaslanger.chalk.Chalk;

public abstract class Player {
    private String name;
    private Hand hand;

    public Player() {
        this.hand = new Hand();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String chooseAttribute() {
        return null;
    }

    public Chalk getName() {
        return Chalk.on(name).red();
    }

    public Hand getHand() {
        return hand;
    }
}
