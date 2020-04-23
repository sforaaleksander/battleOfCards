package com.codecool.battle;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player[] players;
    private int currentPlayerInt;
    private Deck deck;
    private CardsOnTable cardsOnTable;
    private UI ui;
    private GameChecker gameChecker;

    public Game(Deck deck, int numberOfHumanPlayers, int numberOfComputerPlayers, UI ui) {
        this.players = new Player[numberOfHumanPlayers + numberOfComputerPlayers];
        this.ui = ui;
        this.deck = deck;
        this.cardsOnTable = new CardsOnTable();
        this.currentPlayerInt = 0;
        this.gameChecker = new GameChecker(players);
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

    public void gamePlay() {
        while (gameChecker.isGameOver()) {
            boolean draw;
            String userAttribute = "";
            do {
                Player currentPlayer = players[currentPlayerInt];
                ui.displayPlayerTopCard(currentPlayer);
                userAttribute = currentPlayer.chooseAttribute();
                draw = gameChecker.checkIfRoundDraw(userAttribute);
                if (draw) {
                    ui.displayTable(players, cardsOnTable);
                    cardsOnTable.collectPlayersTopCards(players);
                }
            } while (draw && !gameChecker.isGameOver());
            if (gameChecker.isGameOver()) {
                endGame();
                break;
            }
            Player roundWinner = gameChecker.returnRoundWinner(userAttribute);
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
            if (isPlayersHandSizeIsBigger(player, winnerList)) {
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

    private boolean isPlayersHandSizeIsBigger(Player player, List<Player> winnerList) {
        if (player.getHand().getCards().size() > winnerList.get(0).getHand().getCards().size()) {
            return true;
        }
        return false;
    }

    private boolean checkIfIsDrawInList(Player player, List<Player> winnerList) {
        if (player != players[0]
                && player.getHand().getCards().size() == winnerList.get(0).getHand().getCards().size()) {
            return true;
        }
        return false;
    }
}