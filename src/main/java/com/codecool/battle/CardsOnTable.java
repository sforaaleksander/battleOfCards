package com.codecool.battle;

import java.util.ArrayList;
import java.util.List;

public class CardsOnTable {
    private List<Card> cards;

    CardsOnTable(){
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
