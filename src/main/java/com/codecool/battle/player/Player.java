package com.codecool.battle.player;

import com.github.tomaslanger.chalk.Chalk;
import com.codecool.battle.card.CardAttribute;
import com.codecool.battle.ui.UI;


public abstract class Player {
    private String name;
    private Hand hand;
    protected UI ui;


    public Player(UI ui) {
        this.hand = new Hand();
        this.ui = ui;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract CardAttribute chooseAttribute();

    public Chalk getName() {
        return Chalk.on(name).red();
    }

    public Hand getHand() {
        return hand;
    }
}
