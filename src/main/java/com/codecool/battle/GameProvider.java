package com.codecool.battle;

import java.util.Map;

public class GameProvider {    
    private IO io;
    private Map<String, Runnable> mainMenuMap;
    
    GameProvider() {
        initialize();
        UI ui = new UI();
        ui.displayMenu();
        String userChoice = io.gatherInput("");
        mainMenuMap.get(userChoice).run();
    }

    private void createMenuMap(){
        mainMenuMap.put("1", () -> playGame());
        mainMenuMap.put("2", () -> howTo());
        mainMenuMap.put("3", () -> about());
        mainMenuMap.put("0", () -> exitGame());
    }

    private void initialize() {
        new CardParser("src/main/resources/dinosaurs.xml");
        io = new IO();
        createMenuMap();
    }

    public void playGame() {
        int numberOfPlayers = io.gatherIntInput("How many players are there playing?", 4);
        new Game(numberOfPlayers, io);
    }

    public void howTo(){}

    public void about() {
    }

    public void exitGame() {
    }
}