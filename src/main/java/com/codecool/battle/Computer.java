package com.codecool.battle;

public class Computer extends Player {
    
    public Computer(String name, Hand hand) {
        super(name, hand);
    }

    @Override
    public void chooseAttribute() {
        // i teraz jesli zostaje ujednolicanie cech to najwiekszy wynik ze wszystkich jesli nie to losowo
    }
}