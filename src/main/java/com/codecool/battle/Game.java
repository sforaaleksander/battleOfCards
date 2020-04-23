package com.codecool.battle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import edu.emory.mathcs.backport.java.util.Arrays;

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
            boolean draw = false;
            String userAttribute = "";
            do {
                Player currentPlayer = players[currentPlayerInt];
                ui.displayPlayerTopCard(currentPlayer);
                userAttribute = currentPlayer.chooseAttribute();
                ui.displayTable(players, cardsOnTable);
                draw = checkIfRoundDraw(userAttribute);
                if (draw) {
                    cardsOnTable.collectPlayersTopCards(players);
                }
            } while (draw && !isGameOver());
            if (isGameOver()) {
                endGame();
                break;
            }
            Player roundWinner = returnRoundWinner(userAttribute);
            cardsOnTable.collectPlayersTopCards(players);
            roundWinner.getHand().addHandCards(cardsOnTable);
            cardsOnTable.clearTable();
            changeToNextPlayer();

        }
    }

    private void endGame() {
        ui.getIo().gatherEmptyInput("GAME OVER!");
        List<Player> winnerList = new ArrayList<>();
        winnerList.add(players[0]);
        for (Player player : players) {
            if (player.getHand().getCards().size() > winnerList.get(0).getHand().getCards().size()) {
                winnerList.removeAll(winnerList);
                winnerList.add(player);
            } else if (player != players[0] && player.getHand().getCards().size() == winnerList.get(0).getHand().getCards().size()) {
                winnerList.add(player);
            }
        }
        String finalResult = "";
        if (winnerList.size() == 1) {
            finalResult += "The winner is " + winnerList.get(0).getName();
        } else {
            int index = 0;
            finalResult += "Draw! The winners are ";
            for (Player player : winnerList) {
                finalResult += player.getName();
                index++;
                if (index < winnerList.size()) {
                    finalResult += " & ";
                }
            }
        }
        ui.getIo().gatherEmptyInput(finalResult);
    }

    public boolean checkIfRoundDraw(String attribute) {
        int highestValue = players[currentPlayerInt].getHand().getTopCard().getValueByType(attribute);

        //TODO STREAMS???
        for (Player player : players) {
            if (player.getHand().getTopCard().getValueByType(attribute) > highestValue) {
                highestValue = player.getHand().getTopCard().getValueByType(attribute);
            }
        }
        for (Player player : players) {
            if (player.getHand().getTopCard().getValueByType(attribute) == highestValue && players[currentPlayerInt] != player) {
                return true;
            }
        }
        return false;
    }

    // public Player returnRoundWinner(String attribute) {
    //     Player playerWithHighestValue = players[0];
    //     int higestValue = players[0].getHand().getTopCard().getValueByType(attribute);

    //     for (Player player : players) {
    //         if (player.getHand().getTopCard().getValueByType(attribute) > higestValue) {
    //             playerWithHighestValue = player;
    //             higestValue = player.getHand().getTopCard().getValueByType(attribute);
    //         }
    //     }
    //     return playerWithHighestValue;
    // }   

    public Player returnRoundWinner(String attribute) {
        return Arrays.stream(this.getPlayers()).max(Comparator.comparing(Player -> getHand().getTopCard().getValueByType(attribute))); // :: to ->
        // return playerWithHighestValue;
 
    }
}