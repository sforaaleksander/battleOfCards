package com.codecool.battle;

import java.util.HashMap;
import java.util.Map;

public class GameProvider {
    private IO io;
    private UI ui;
    private Map<String, Runnable> mainMenuMap;
    private boolean isRunning;
    private Deck deck;
    private int numberOfHumanPlayers;
    private int numberOfComputerPlayers;

    GameProvider() {
        initialize();
        handleMenu();
    }

    private void createMenuMap() {
        mainMenuMap = new HashMap<>();
        mainMenuMap.put("1", () -> gameSetup());
        mainMenuMap.put("2", () -> howTo());
        mainMenuMap.put("3", () -> about());
        mainMenuMap.put("0", () -> exitGame());
    }

    private void initialize() {
        String currentDirectory = System.getProperty("user.dir");
        CardParser cardParser = new CardParser(currentDirectory + "/src/main/resources/dinosaurs.xml");
        deck = new Deck(cardParser.getCardRepository());
        io = new IO();
        ui = new UI(io);
        createMenuMap();
        isRunning = true;
    }

    private void handleMenu() {
        while (isRunning) {
            ui.displayMenu();
            String userChoice = ui.gatherInput("");
            mainMenuMap.get(userChoice).run();
        }
    }

    public void gameSetup() {
        boolean enoughPlayers = false;
        while (!enoughPlayers) {
            numberOfHumanPlayers = ui.gatherIntInput("How many human players are there playing?", 0, 4);
            numberOfComputerPlayers = ui.gatherIntInput("How many computer players are there playing?", 0,
                    4 - numberOfHumanPlayers);
            enoughPlayers = numberOfHumanPlayers + numberOfComputerPlayers >= 2;
            if (!enoughPlayers){
                ui.gatherEmptyInput("Not enough players to start game!");
            }
        }
        Game game = new Game(deck, numberOfHumanPlayers, numberOfComputerPlayers, ui);
        createHumanPlayers(game);
        createComputerPlayers(game);
        setPlayersNames(game);
        game.getDeck().distributeCards(game.getPlayers());
        game.gamePlay();
    }

    public void howTo() {
    }

    public void about() {
    }

    public void exitGame() {
        isRunning = false;
    }

    public void createHumanPlayers(Game game) {
        for (int i = 0; i < numberOfHumanPlayers; i++) {
            Player player = new HumanPlayer(ui);
            game.getPlayers()[i] = player;
        }
    }

    public void createComputerPlayers(Game game) {
        for (int i = numberOfHumanPlayers; i < numberOfHumanPlayers + numberOfComputerPlayers; i++) {
            Player player = new ComputerPlayer(ui);
            game.getPlayers()[i] = player;
        }
    }

    public void setPlayersNames(Game game) {
        int count = 1;
        for (Player player : game.getPlayers()) {
            String humanOrComputer = player instanceof HumanPlayer ? "player " : "computer ";
            player.setName(ui.gatherInput("Type in the name for " + humanOrComputer + count + "."));
            count++;
        }
    }
}