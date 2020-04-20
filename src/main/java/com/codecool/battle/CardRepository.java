package com.codecool.battle;

import java.util.List;

public class CardRepository {
    private List<Card> cards;

    public void addCard(Card card){
        cards.add(card);
    }
    public List<Card> getCards() {
        return cards;
    }
}