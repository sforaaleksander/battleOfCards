package com.codecool.battle;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private int currentPlayerInt;
    private Deck deck;
    private CardsOnTable cardsOnTable;
    private int numberOfHumanPlayers;
    private int numberOfComputerPlayers;
    private IO io;

    public Game(int numberOfHumanPlayers, int numberOfComputerPlayers, IO io) {
        this.players = new ArrayList<>();
        this.numberOfHumanPlayers = numberOfHumanPlayers;
        this.numberOfComputerPlayers = numberOfComputerPlayers;
        this.io = io;
        createHumanPlayers();
        createComputerPlayers();
        setPlayersNames(io);
    }

    public IO getIo() {
        return io;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void changeToNextPlayer(){
        currentPlayerInt += 1;
        if (currentPlayerInt == players.size()){
            currentPlayerInt = 0;
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerInt);
    }

    public Deck getDeck() {
        return deck;
    }

    public CardsOnTable getCardsOnTable() {
        return cardsOnTable;
    }

    public void createHumanPlayers() {
        for (int i = 0; i < numberOfHumanPlayers; i++) {
            Player player = new HumanPlayer(io);
            players.add(player);
        }
    }

    public void createComputerPlayers() {
        for (int i = 0; i < numberOfComputerPlayers; i++) {
            Player player = new ComputerPlayer();
            players.add(player);
        }
    }

    public void setPlayersNames(IO io) {
        int count = 1;
        for (Player player : players) {
            String humanOrComputer = player instanceof HumanPlayer ? "player " : "computer ";
            player.setName(io.gatherInput("Type in the name for " + humanOrComputer + count + "."));
            count++;
        }
    }

}
