package com.codecool.battle.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.codecool.battle.card.Card;
import com.codecool.battle.card.comparator.*;
import com.codecool.battle.player.Player;

public class GameChecker {
    private Player[] players;
    private CardMaxSpeedComparator cardMaxSpeedComparator;
    private CardRoarVolumeComparator cardRoarVolumeComparator;
    private CardNumberOfTeethComparator cardNumberOfTeethComparator;
    private CardWeightComparator cardWeightComparator;

    GameChecker(Player[] players) {
        this.players = players;
        createComparators();
    }

    private void createComparators() {
        this.cardMaxSpeedComparator = new CardMaxSpeedComparator();
        this.cardRoarVolumeComparator = new CardRoarVolumeComparator();
        this.cardNumberOfTeethComparator = new CardNumberOfTeethComparator();
        this.cardWeightComparator = new CardWeightComparator();

    }

    public boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().getCards().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public int findHighestValue(String attribute, List<Card> topCards) {
        switch (attribute) {
            case ("MAXSPEED"):
                return Collections.max(topCards, cardMaxSpeedComparator).getAttributes().get(attribute);
            case ("ROARVOLUME"):
                return Collections.max(topCards, cardRoarVolumeComparator).getAttributes()
                        .get(attribute);
            case ("NUMBEROFTEETH"):
                return Collections.max(topCards, cardNumberOfTeethComparator).getAttributes()
                        .get(attribute);
            default:
                return Collections.max(topCards, cardWeightComparator).getAttributes().get(attribute);
        }
    }

    private List<Card> createTopCardsArray() {
        return Arrays.stream(players)
                     .map(player -> player.getHand().getTopCard())
                     .collect(Collectors.toList());
    }

    public boolean checkIfRoundDraw(String attribute) {
        List<Card> topCards = createTopCardsArray();
        int highestValue = findHighestValue(attribute, topCards);

        int highestValueCount = 0;

        // TODO how could we implement comparators down here?
        for (Card card : topCards) {
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
