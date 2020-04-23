package com.codecool.battle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
            boolean draw;
            String userAttribute = "";
            do {
                Player currentPlayer = players[currentPlayerInt];
                ui.displayPlayerTopCard(currentPlayer);
                userAttribute = currentPlayer.chooseAttribute();
                draw = checkIfRoundDraw(userAttribute);
                if (draw) {
                    ui.displayTable(players, cardsOnTable);
                    cardsOnTable.collectPlayersTopCards(players);
                }
            } while (draw && !isGameOver());
            if (isGameOver()) {
                endGame();
                break;
            }
            Player roundWinner = returnRoundWinner(userAttribute);
            ui.displayTable(players, cardsOnTable, roundWinner);
            cardsOnTable.collectPlayersTopCards(players);
            roundWinner.getHand().addHandCards(cardsOnTable);
            cardsOnTable.clearTable();
            changeToNextPlayer();

        }
    }

    private void endGame() {
        ui.clearScreen();
        ui.getIo().gatherEmptyInput("GAME OVER!");
        List<Player> winnerList = new ArrayList<>();
        winnerList.add(players[0]);
        for (Player player : players) {
            if (checkIfPlayersHandSizeIsBigger(player, winnerList)) {
                winnerList.removeAll(winnerList);
                winnerList.add(player);
            } else if (checkIfIsDrawInList(player, winnerList)) {
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

    public boolean checkIfPlayersHandSizeIsBigger(Player player, List<Player> winnerList) {
        if (player.getHand().getCards().size() > winnerList.get(0).getHand().getCards().size()) {
            return true;
        }
        return false;
    }

    public boolean checkIfIsDrawInList(Player player, List<Player> winnerList) {
        if (player != players[0]
                && player.getHand().getCards().size() == winnerList.get(0).getHand().getCards().size()) {
            return true;
        }
        return false;
    }

    private int findHighestValue(String attribute, List<Card> temporaryTopCards) {
        switch (attribute) {
            case ("MAXSPEED"):
                return Collections.max(temporaryTopCards, new CardMaxSpeedComparator()).getAttributes().get(attribute);
            case ("ROARVOLUME"):
                return Collections.max(temporaryTopCards, new CardMaxSpeedComparator()).getAttributes().get(attribute);
            case ("NUMBEROFTEETH"):
                return Collections.max(temporaryTopCards, new CardMaxSpeedComparator()).getAttributes().get(attribute);
            default:
                return Collections.max(temporaryTopCards, new CardMaxSpeedComparator()).getAttributes().get(attribute);
        }
    }

    private List<Card> createTemporaryTopCardsArr() {
        List<Card> temporaryTopCards = new ArrayList<>();
        for (Player player : players) {
            temporaryTopCards.add(player.getHand().getTopCard());
        }
        return temporaryTopCards;
    }

    public boolean checkIfRoundDraw(String attribute) {
        List<Card> temporaryTopCards = createTemporaryTopCardsArr();
        int highestValue = findHighestValue(attribute, temporaryTopCards);
        
        int highestValueCount = 0;
        for (Player player : players) {
            if (player.getHand().getTopCard().getValueByType(attribute) == highestValue) {
                highestValueCount++;
            }
        }
        return highestValueCount > 1;
    }

    public Player returnRoundWinner(String attribute) {
        return Arrays.stream(players)
                .max(Comparator.comparing(Player -> Player.getHand().getTopCard().getValueByType(attribute)))
                .orElse(null);
    }
}