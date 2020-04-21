package com.codecool.battle;

public class UI {
    Game game;
    private final int TABLE_WIDTH = 150;
    private final int TABLE_HEIGTH = 40;

    public void displayMenu() {
        clearScreen();
        printTable();
        printOnTable(2, 2, new String[]{"(1) Start new game",
                                        "(2) How to play",
                                        "(3) About autors",
                                        "(0) Exit"});
    }

    private void printTable() {
        System.out.println("▊".repeat(TABLE_WIDTH));
        for (int i = 0; i < TABLE_HEIGTH; i++) {
            System.out.println("▊" + " ".repeat(TABLE_WIDTH - 2) + "▊");
        }
        System.out.println("▊".repeat(TABLE_WIDTH));
    }

    private void printOnTable(int x, int y, String[] toPrint) {
        for (String string : toPrint) {
            setCursorPosition(y++, x);
            System.out.print(string);
        }
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
