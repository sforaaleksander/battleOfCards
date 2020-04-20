package com.codecool.battle;

public class Main {

    public static void main(String[] args) {
        new CardParser("resources/dinosaurs.xml");
        UI ui = new UI();
        ui.displayMenu();
    }
}
