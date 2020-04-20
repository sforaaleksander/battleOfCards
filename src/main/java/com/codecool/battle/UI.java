package com.codecool.battle;

public class UI {
    Game game;

    public void displayMenu() {
        System.out.println("(1) Start new game");
        System.out.println("(2) How to play");
        System.out.println("(3) About autors");
        System.out.println("(0) Exit");
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void displayPlayerTopCard() {
    }

    public void displayTable() {
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void setCursorPosition(int y, int x) {
        System.out.print("\033[" + y + ";" + x + "H");
    }
}
