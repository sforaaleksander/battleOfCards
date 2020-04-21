package com.codecool.battle;

public class UI {
    Game game;
    private final int TABLE_WIDTH = 150;
    private final int TABLE_HEIGTH = 40;
    public int x;
    public int y;
    private int startX = 1;
    private int startY = 1;

    public void displayMenu() {
        printTable();
        // clearScreen();
        x = startX + 1;
        y = startY;
        printOnTable(new String[]{"(1) Start new game",
                                  "(2) How to play",
                                  "(3) About autors",
                                  "(0) Exit"});
    }

    private void printTable() {
        clearScreen();
        System.out.println("▊".repeat(TABLE_WIDTH));
        for (int i = 0; i < TABLE_HEIGTH; i++) {
            System.out.println("▊" + " ".repeat(TABLE_WIDTH - 2) + "▊");
        }
        System.out.println("▊".repeat(TABLE_WIDTH));
    }

    public void printOnTable(String[] toPrint) {
        for (String string : toPrint) {
            setCursorPosition(++y, x);
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
        x = startX; 
        y = startY;
    }

    public void setCursorPosition(int y, int x) {
        System.out.print("\033[" + y + ";" + x + "H");
        this.y = y;
        this.x = x;
    }

    public void moveCursorDown() {
        System.out.print("\033[" + ++y + ";" + x + "H");
    }
}
