package com.codecool.battle;

public class Player implements Playing {
    private String name;
    private Hand hand;

    public Player(){}

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean hasCards() {
        return this.getHand().getCards().isEmpty();
    }

    @Override
    public void chooseAttribute() {
        // TODO
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Hand getHand() {
        return hand;
    }
}