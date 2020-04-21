package com.codecool.battle;

import java.util.HashMap;
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
        mainMenuMap = new HashMap<>();
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
        int numberOfHumanPlayers = io.gatherIntInput("How many human players are there playing?", 4);
        int numberOfComputerPlayers = io.gatherIntInput("How many computer players are there playing?", 4 - numberOfHumanPlayers);
        new Game(numberOfHumanPlayers, numberOfComputerPlayers, io);
    }

    public void howTo(){}

    public void about() {
    }

    public void exitGame() {
    }
}