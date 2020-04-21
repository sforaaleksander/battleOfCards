package com.codecool.battle;


public class Game {
    private Player[] players;
    private int currentPlayerInt;
    private Deck deck;
    private CardsOnTable cardsOnTable;
    private IO io;

    public Game(Deck deck, int numberOfHumanPlayers, int numberOfComputerPlayers, IO io) {
        this.players = new Player[numberOfHumanPlayers + numberOfComputerPlayers];
        this.io = io;
        this.deck = deck;
    }

    public IO getIo() {
        return io;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void changeToNextPlayer(){
        currentPlayerInt += 1;
        if (currentPlayerInt == players.length){
            currentPlayerInt = 0;
        }
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerInt];
    }

    public Deck getDeck() {
        return deck;
    }

    public CardsOnTable getCardsOnTable() {
        return cardsOnTable;
    }

}
