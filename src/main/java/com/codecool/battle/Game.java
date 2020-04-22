package com.codecool.battle;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player[] players;
    private int currentPlayerInt;
    private Deck deck;
    private CardsOnTable cardsOnTable;
    private UI ui;

    public Game(Deck deck, int numberOfHumanPlayers, int numberOfComputerPlayers, UI ui) {
        this.players = new Player[numberOfHumanPlayers + numberOfComputerPlayers];
        this.ui = ui;
        this.deck = deck;
        this.cardsOnTable = new CardsOnTable();
        this.currentPlayerInt = 0;
    }

    public UI getUi() {
        return ui;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void changeToNextPlayer() {
        currentPlayerInt += 1;
        if (currentPlayerInt == players.length) {
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

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().getCards().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void gamePlay() {
        while (!isGameOver()) {
            System.out.println("INSIDE OF GAME LOOP");
            boolean draw = true;
            String userAttribute = "";
            do {
                Player currentPlayer = players[currentPlayerInt];
                ui.displayPlayerTopCard(currentPlayer);

                userAttribute = currentPlayer.chooseAttribute();
                ui.displayTable(players, cardsOnTable);                
                draw = checkIfRoundDraw(userAttribute);
                cardsOnTable.collectPlayersTopCards(players);
                if (isGameOver()){
                    endGame();
                }
            } while (draw);

            Player roundWinner = returnRoundWinner(userAttribute);

            roundWinner.getHand().addHandCards(cardsOnTable);
            cardsOnTable.clearTable();

            changeToNextPlayer();

        }
    }

    private void endGame() {
        //TODO
        System.out.println("GAME OVER");
    }

    public boolean checkIfRoundDraw(String attribute) {
        List<Integer> highestValues = new ArrayList<>();
        highestValues.add(players[0].getHand().getTopCard().getValueByType(attribute));

        for (Player player : players) {
            if (player.getHand().getTopCard().getValueByType(attribute) > highestValues.get(0)) {
                highestValues.removeAll(highestValues);
                highestValues.add(player.getHand().getTopCard().getValueByType(attribute));
            } else if (player.getHand().getTopCard().getValueByType(attribute) == highestValues.get(0)) {
                highestValues.add(player.getHand().getTopCard().getValueByType(attribute));
            }
        }
        if (highestValues.size() == 1) {
            return false;
        }
        return true;
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
