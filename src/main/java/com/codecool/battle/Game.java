package com.codecool.battle;

import java.util.List;

public class Game {
    private List<Player> players;
    private Player currentPlayer;
    private Deck deck;
    private CardsOnTable cardsOnTable;
    private IO io;
    private int numOfPlayers;

    public Game(int numOfPlayers){
        this.io = new IO();
        this.numOfPlayers = numOfPlayers;
        createPlayers();
        setPlayersNames();
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

    public void createPlayers(){
        for (int i=0; i<numOfPlayers; i++){
            Player player = new Player();
            players.add(player);
        }
    }

    public void setPlayersNames(){
        int count = 1;
        for (Player player : players) {
        player.setName(io.gatherInput("Type in the name for player " + count + "."));
        count++;
        }
    }
    
}
