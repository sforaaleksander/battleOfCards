package com.codecool.battle.card;

import java.util.ArrayList;
import java.util.List;

public class CardRepository {
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}
