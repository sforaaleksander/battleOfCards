package com.codecool.battle;

public abstract class Player {
    private String name;
    private Hand hand;

    public Player(String name, Hand hand){
        this.name = name;
        this.hand = hand;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean hasCards() {
        return this.getHand().getCards().isEmpty();
    }

    public String chooseAttribute() {
        return null;
    }
    
    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }
}