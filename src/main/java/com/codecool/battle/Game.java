package com.codecool.battle;

import java.util.List;

public class Game {
    private List<Player> players;
    private Player currentPlayer;
    private Deck deck;
    private CardsOnTable cardsOnTable;
    private int numOfPlayers;
    private IO io;

    public Game(int numOfPlayers, IO io) {

        // TODO if numOfPlayer == 1 create instance of ComputerPlayer
        
        this.numOfPlayers = numOfPlayers;
        this.io = io;
        createPlayers();
        setPlayersNames(io);
    }



    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Deck getDeck() {
        return deck;
    }

    public CardsOnTable getCardsOnTable() {
        return cardsOnTable;
    }

    public void createPlayers() {
        for (int i = 0; i < numOfPlayers; i++) {
            Player player = new Player();
            players.add(player);
        }
    }

    public void setPlayersNames(IO io) {
        int count = 1;
        for (Player player : players) {
            player.setName(io.gatherInput("Type in the name for player " + count + "."));
            count++;
        }
    }

}
