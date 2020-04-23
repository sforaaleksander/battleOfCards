package com.codecool.battle.card;

import com.codecool.battle.player.Player;

import java.util.ArrayList;
import java.util.List;

public class CardsOnTable {
    private List<Card> cards;

    public CardsOnTable(){
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void clearTable(){
        cards.clear();
    }

    public void collectPlayersTopCards(Player[] players) {
        for (Player player : players) { 
            cards.add(player.getHand().popTopCard());
        }
    }
}
