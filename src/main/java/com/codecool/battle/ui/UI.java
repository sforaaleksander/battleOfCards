package com.codecool.battle.ui;

import java.util.Random;

import com.codecool.battle.card.CardsOnTable;
import com.codecool.battle.player.Player;

public class UI {
    private final int TABLE_WIDTH = 170;
    private final int TABLE_HEIGHT = 40;
    private Point cursorPosition = new Point(1, 1);
    private final int marginY = 3;
    private final int marginX = 3;
    private IO io;
    private Random generator;

    public UI(IO io) {
        this.io = io;
        this.generator = new Random();
    }

    public IO getIo() {
        return io;
    }

    public Random getGenerator() {
        return generator;
    }

    public void displayMenu() {
        displayNewTable(new String[] { "(1) Start new game",
                                       "(2) How to play",
                                       "(3) About authors",
                                       "(0) Exit" });
    }

    public void displayNewTable(String[] content) {
        printBorders(TABLE_WIDTH, TABLE_HEIGHT);

        printOnTable(marginY, marginX, content);
    }

    private void printBorders(int width, int height) {
        clearScreen();
        System.out.println("▊".repeat(width));
        for (int i = 0; i < height; i++) {
            System.out.println("▊" + " ".repeat(width - 2) + "▊");
        }
        System.out.println("▊".repeat(width));
    }

    public void printOnTable(String toPrint) {
        printOnTable(cursorPosition.getY(), cursorPosition.getX(), stringToArray(toPrint));
    }

    public void printOnTable(Point point, String toPrint) {
        printOnTable(point.getY(), point.getX(), stringToArray(toPrint));
    }

    public void printOnTable(Point point, String[] toPrint) {
        printOnTable(point.getY(), point.getX(), toPrint);
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

    public void displayPlayerTopCard(Player player, Player[] players) {
        displayPlayerTopCard(marginY, marginX, player);
    }

    public void displayPlayerTopCard(int y, int x, Player player) {
        clearScreen();
        printBorders(TABLE_WIDTH, TABLE_HEIGHT);
        printOnTable(y, x, "PLAYER " + player.getName() + " num. of cards: " + player.getHand().getCards().size());
        printOnTable(++y, x, player.getHand().getTopCard().toString());
        printOnTable(y, x + 20, player.getHand().getTopCard().getImage());
    }

    private void displayTable(Player[] players, CardsOnTable cardsOnTable, String winner) {
        final Point player1Origin = new Point(marginY, marginX);
        final Point player2Origin = new Point(marginY, TABLE_WIDTH / 2);
        final Point player3Origin = new Point(TABLE_HEIGHT / 2 + 4, marginX);
        final Point player4Origin = new Point(TABLE_HEIGHT / 2 + 4, TABLE_WIDTH / 2);
        final Point middle = new Point(TABLE_HEIGHT / 2, TABLE_WIDTH / 2);
        Point[] origins = { player1Origin, player2Origin, player3Origin, player4Origin };
        int currentPlayer = 0;
        printBorders(TABLE_WIDTH, TABLE_HEIGHT);
        for (Player player : players) {
            String playerString = "PLAYER " + player.getName() + "\ncards: " + player.getHand().getCards().size()
                    + "\nTop card:\n" + player.getHand().getTopCard().toString();
            Point imagePoint = getImagePoint(origins[currentPlayer]);

            printOnTable(origins[currentPlayer++], playerString);
            printOnTable(imagePoint, player.getHand().getTopCard().getImage());
        }
        String cardsOnTableString = "▊".repeat(cardsOnTable.getCards().size());
        printOnTable(middle.getY() - 1, middle.getX() - cardsOnTableString.length() / 2, cardsOnTableString);
        printOnTable(middle.getY(), middle.getX() - winner.length() / 2 + 5, winner);
        String pressEnter = "Press enter to continue.";
        printOnTable(middle.getY() + 1, middle.getX() - pressEnter.length() / 2, pressEnter);
        gatherEmptyInput("");
    }

    public void displayTable(Player[] players, CardsOnTable cardsOnTable) {
        displayTable(players, cardsOnTable, "Draw!          ");
    }

    public void displayTable(Player[] players, CardsOnTable cardsOnTable, Player winner) {
        displayTable(players, cardsOnTable, "Player " + winner.getName() + " wins this round");
    }

    private Point getImagePoint(Point origin) {
        return new Point(origin.getY(), origin.getX() + 20);
    }

    public void gatherEmptyInput(String message) {
        printOnTable(message);
        io.gatherEmptyInput();
    }

    public String gatherInput(String message) {
        printOnTable(message);
        return io.gatherInput();
    }

    public int gatherIntInput(String message, int rangeMin, int rangeMax) {
        printOnTable(message);
        return io.gatherIntInput(rangeMin, rangeMax);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        cursorPosition.setY(1);
        cursorPosition.setX(1);
    }

    public void setCursorPosition(int y, int x) {
        System.out.print("\033[" + y + ";" + x + "H");
        cursorPosition.setY(y);
        cursorPosition.setX(x);
    }
}
