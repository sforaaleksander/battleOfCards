package com.codecool.battle;

public class UI {
    private final int TABLE_WIDTH = 150;
    private final int TABLE_HEIGTH = 40;

    private final int startY = 2;
    private final int startX = 2;

    private IO io;

    UI(IO io) {
        this.io = io;
    }

    public IO getIo() {
        return io;
    }

    public void displayMenu() {
        printTable();

        printOnTable(startY, startX, new String[]{"(1) Start new game",
                                                  "(2) How to play",
                                                  "(3) About autors",
                                                  "(0) Exit"});
    }

    private void printTable() {
        // clearScreen();
        System.out.println("▊".repeat(TABLE_WIDTH));
        for (int i = 0; i < TABLE_HEIGTH; i++) {
            System.out.println("▊" + " ".repeat(TABLE_WIDTH - 2) + "▊");
        }
        System.out.println("▊".repeat(TABLE_WIDTH));
    }

    public void printOnTable(int y, int x, String[] toPrint) {
        setCursorPosition(y, x);
        for (String string : toPrint) {
            System.out.print(string);
            setCursorPosition(++y, x);
        }
    }

    public void printOnTable(int y, int x, String toPrint) {
        printOnTable(y, x, stringToArray(toPrint));
    }

    private String[] stringToArray(String str) {
        return str.split("\n");
    }

    public void displayPlayerTopCard(Player player) {
        displayPlayerTopCard(startY, startX, player);
    }

    public void displayPlayerTopCard(int y, int x, Player player) {
        // clearScreen();
        printOnTable(y, x, "PLAYER " + player.getName() + " num. of cards: " + player.getHand().getCards().size());
        printOnTable(++y, x, player.getHand().getTopCard().toString());
        // printOnTable(y, x + 20, player.getHand().getTopCard().getImage());
    }

    public void displayTable(Player[] players, CardsOnTable cardsOnTable) {
        for (Player player : players) {
            System.out.println("PLAYER " + player.getName() + " num. of cards: " + player.getHand().getCards().size());
            System.out.println("Top card " + player.getHand().getTopCard().toString());
            System.out.println(cardsOnTable.getCards().size() + " cards on table");
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void setCursorPosition(int y, int x) {
        // System.out.print("\033[" + y + ";" + x + "H");
    }

    private void moveCursorDown(int n) {
        System.out.print("\033[" + n + "B");
    }
}
