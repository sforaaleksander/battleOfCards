package com.codecool.battle;

public class UI {
    private final int TABLE_WIDTH = 170;
    private final int TABLE_HEIGTH = 40;
    private Point cursorPosition = new Point(1, 1);
    private final int marginY = 3;
    private final int marginX = 3;

    private IO io;

    UI(IO io) {
        this.io = io;
    }

    public IO getIo() {
        return io;
    }

    public void displayMenu() {
        printBorders();

        printOnTable(marginY, marginX, new String[] { "(1) Start new game",
                                                      "(2) How to play",
                                                      "(3) About autors",
                                                      "(0) Exit" });
    }

    private void printBorders() {
        clearScreen();
        System.out.println("▊".repeat(TABLE_WIDTH));
        for (int i = 0; i < TABLE_HEIGTH; i++) {
            System.out.println("▊" + " ".repeat(TABLE_WIDTH - 2) + "▊");
        }
        System.out.println("▊".repeat(TABLE_WIDTH));
    }

    public void printOnTable(Point point, String toPrint) {
        printOnTable(point.y, point.x, stringToArray(toPrint));
    }

    public void printOnTable(Point point, String[] toPrint) {
        printOnTable(point.y, point.x, toPrint);
    }

    public void printOnTable(int y, int x, String toPrint) {
        printOnTable(y, x, stringToArray(toPrint));
    }

    public void printOnTable(int y, int x, String[] toPrint) {
        setCursorPosition(y, x);
        for (String string : toPrint) {
            System.out.print(string);
            setCursorPosition(++y, x);
        }
    }

    private String[] stringToArray(String str) {
        return str.split("\n");
    }

    public void displayPlayerTopCard(Player player) {
        displayPlayerTopCard(marginY, marginX, player);
    }

    public void displayPlayerTopCard(int y, int x, Player player) {
        clearScreen();
        printOnTable(y, x, "PLAYER " + player.getName() + " num. of cards: " + player.getHand().getCards().size());
        printOnTable(++y, x, player.getHand().getTopCard().toString());
        printOnTable(y, x + 20, player.getHand().getTopCard().getImage());
    }

    public void displayTable(Player[] players, CardsOnTable cardsOnTable, String winner) {
        final Point player1Origin = new Point(marginY, marginX);
        final Point player2Origin = new Point(marginY, TABLE_WIDTH / 2);
        final Point player3Origin = new Point(TABLE_HEIGTH / 2 + 4, marginX);
        final Point player4Origin = new Point(TABLE_HEIGTH / 2 + 4, TABLE_WIDTH / 2);
        final Point middle = new Point(TABLE_HEIGTH / 2, TABLE_WIDTH / 2);
        Point[] origins = { player1Origin, player2Origin, player3Origin, player4Origin };
        int currentPlayer = 0;
        printBorders();
        for (Player player : players) {
            String playerString = "PLAYER " + player.getName() + "\ncards: " + player.getHand().getCards().size()
                    + "\nTop card:\n" + player.getHand().getTopCard().toString();
            Point imagePoint = getImagePoint(origins[currentPlayer]);

            printOnTable(origins[currentPlayer++], playerString);
            printOnTable(imagePoint, player.getHand().getTopCard().getImage());
        }
        String cardsOnTableString = "▊".repeat(cardsOnTable.getCards().size());
        printOnTable(middle.y, middle.x - cardsOnTableString.length() / 2, cardsOnTableString);
        io.gatherEmptyInput(winner + "\nPress enter to continue.");
    }

    public void displayTable(Player[] players, CardsOnTable cardsOnTable, boolean draw) {
        displayTable(players, cardsOnTable, "Draw!");
    }

    public void displayTable(Player[] players, CardsOnTable cardsOnTable, Player winner) {
        displayTable(players, cardsOnTable, "Player " + winner.getName() + " wins this round");
    }

    private Point getImagePoint(Point origin) {
        return new Point(origin.y, origin.x + 20);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void setCursorPosition(int y, int x) {
        System.out.print("\033[" + y + ";" + x + "H");
    }
}
