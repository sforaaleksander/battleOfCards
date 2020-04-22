package com.codecool.battle;

public class UI {
    Game game;
    private final int TABLE_WIDTH = 150;
    private final int TABLE_HEIGTH = 40;

    private final int startY = 2;
    private final int startX = 2;

    public void displayMenu() {
        printTable();

        printOnTable(startY, startX, new String[]{"(1) Start new game",
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


    public void printOnTable(int y, int x, String[] toPrint) {
        for (String string : toPrint) {
            setCursorPosition(++y, x);
            System.out.print(string);
        }
    }

    public void printOnTable(int y, int x, String toPrint) {
        printOnTable(x, y, stringToArray(toPrint));
    }

    private String[] stringToArray(String str) {
        return str.split("\n");
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void displayPlayerTopCard(Player player) {
        clearScreen();
        printOnTable(startY, startX, player.getHand().getTopCard().toString());
    }

    public void displayPlayerTopCard(int y, int x, Player player) {
        clearScreen();
        printOnTable(y, x, player.getHand().getTopCard().toString());
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
