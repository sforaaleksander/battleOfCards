package com.codecool.battle;

import java.util.ArrayList;
import java.util.List;

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
        this.currentPlayerInt = 0;
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

    private boolean isGameOver(){
        for (Player player: players) {
            if (player.getHand().getCards().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void gamePlay(){
        while (!isGameOver()){
            
        }
    }
    
    
    public boolean checkIfIsRoundWinner(String attribute) {
        List<Integer> highestValues = new ArrayList<>();
        highestValues.add(players[0].getHand().getTopCard().getValueByType(attribute));

        for (Player player : players) {
            if (player.getHand().getTopCard().getValueByType(attribute) > highestValues.get(0)) {
                highestValues.removeAll(highestValues);
                highestValues.add(player.getHand().getTopCard().getValueByType(attribute));
            }
            if (player.getHand().getTopCard().getValueByType(attribute) == highestValues.get(0)) {
                highestValues.add(player.getHand().getTopCard().getValueByType(attribute));
            }
        }
        if (highestValues.size() == 1) {
            return true;
        }
        return false;
    }


    public Player returnRoundWinner(String attribute) {
        Player playerWithHighestValue = players[0];
        int higestValue = players[0].getHand().getTopCard().getValueByType(attribute);

        for (Player player : players) {
            if (player.getHand().getTopCard().getValueByType(attribute) > higestValue) {
                playerWithHighestValue = player;
                higestValue = player.getHand().getTopCard().getValueByType(attribute);
            }
        }
        return playerWithHighestValue;
    }
}
