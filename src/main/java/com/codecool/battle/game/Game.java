package com.codecool.battle.game;

import java.util.ArrayList;
import java.util.List;

import com.codecool.battle.ui.UI;
import com.codecool.battle.card.CardAttribute;
import com.codecool.battle.card.CardsOnTable;
import com.codecool.battle.card.Deck;
import com.codecool.battle.player.Player;

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

    public Player[] getPlayers() {
        return players;
    }

    public void changeToNextPlayer() {
        currentPlayerInt += 1;
        if (currentPlayerInt == players.length) {
            currentPlayerInt = 0;
        }
    }

    public Deck getDeck() {
        return deck;
    }

    public void gamePlay() {
        while (!gameChecker.isGameOver()) {
            boolean draw;
            CardAttribute userAttribute;
            do {
                Player currentPlayer = players[currentPlayerInt];
                ui.displayPlayerTopCard(currentPlayer, players);
                userAttribute = currentPlayer.chooseAttribute();
                draw = gameChecker.checkIfRoundDraw(userAttribute);
                if (draw) {
                    ui.displayTable(players, cardsOnTable);
                    cardsOnTable.collectPlayersTopCards(players);
                }
            } while (draw && !gameChecker.isGameOver());
            if (gameChecker.isGameOver()) {
                break;
            }
            Player roundWinner = gameChecker.returnRoundWinner(userAttribute);
            ui.displayTable(players, cardsOnTable, roundWinner);
            cardsOnTable.collectPlayersTopCards(players);
            roundWinner.getHand().addHandCards(cardsOnTable);
            cardsOnTable.clearTable();
            changeToNextPlayer();
        }
        endGame();
    }

    private void endGame() {
        ui.clearScreen();
        ui.gatherEmptyInput("GAME OVER");
        List<Player> winnerList = new ArrayList<>();
        winnerList.add(players[0]);
        for (Player player : players) {
            if (isPlayersHandSizeIsBigger(player, winnerList)) {
                winnerList.clear();
                winnerList.add(player);
            } else if (checkIfIsDrawInList(player, winnerList)) {
                winnerList.add(player);
            }
        }
        StringBuilder finalResult = new StringBuilder();
        if (winnerList.size() == 1) {
            finalResult.append("The winner is ").append(winnerList.get(0).getName());
        } else {
            int index = 0;
            finalResult.append("Draw! The winners are ");
            for (Player player : winnerList) {
                finalResult.append(player.getName());
                index++;
                if (index < winnerList.size()) {
                    finalResult.append(" & ");
                }
            }
        }
        ui.gatherEmptyInput(finalResult.toString());
    }

    private boolean isPlayersHandSizeIsBigger(Player player, List<Player> winnerList) {
        return player.getHand().getCards().size() > winnerList.get(0).getHand().getCards().size();
    }

    private boolean checkIfIsDrawInList(Player player, List<Player> winnerList) {
        return player != players[0]
                && player.getHand().getCards().size() == winnerList.get(0).getHand().getCards().size();
    }
}
