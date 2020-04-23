package com.codecool.battle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameChecker {
    private Player[] players;

    GameChecker(Player[] players) {
        this.players = players;
    }

    public boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().getCards().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public int findHighestValue(String attribute, List<Card> temporaryTopCards) {
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

    public List<Card> createTemporaryTopCardsArr() {
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

        // TODO how could we implement comparators down here?
        for (Card card : temporaryTopCards) {
            if (card.getValueByType(attribute) == highestValue) {
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