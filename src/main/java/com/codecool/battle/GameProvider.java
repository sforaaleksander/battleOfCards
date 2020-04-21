package com.codecool.battle;

import java.util.HashMap;
import java.util.Map;

public class GameProvider {
    private IO io;
    private UI ui;
    private Map<String, Runnable> mainMenuMap;
    private boolean isRunning;
    private Deck deck;

    GameProvider() {
        initialize();
        handleMenu();
    }
    private void createMenuMap() {
        mainMenuMap = new HashMap<>();
        mainMenuMap.put("1", () -> playGame());
        mainMenuMap.put("2", () -> howTo());
        mainMenuMap.put("3", () -> about());
        mainMenuMap.put("0", () -> exitGame());
    }

    private void initialize() {
        CardParser cardParser = new CardParser("src/main/resources/dinosaurs.xml");
        deck = new Deck(cardParser.cardRepository);
        io = new IO();
        ui = new UI();
        createMenuMap();
        isRunning = true;
    }

    private void handleMenu() {
        while (isRunning) {
            ui.displayMenu();
            String userChoice = io.gatherInput("");
            mainMenuMap.get(userChoice).run();
        }
    }

    public void playGame() {
        int numberOfHumanPlayers = io.gatherIntInput("How many human players are there playing?", 4);
        int numberOfComputerPlayers = io.gatherIntInput("How many computer players are there playing?",
                4 - numberOfHumanPlayers);
        new Game(deck, numberOfHumanPlayers, numberOfComputerPlayers, io);
    }

    public void howTo() {
    }

    public void about() {
    }

    public void exitGame() {
        isRunning = false;
    }
}