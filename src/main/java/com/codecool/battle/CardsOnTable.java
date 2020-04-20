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

    public void addCard(Card card){
        cards.add(card);
    }

    public void addCards(List<Card> newCards){
        cards.addAll(newCards);
    }

    public void clearTable(){
        cards.clear();
    }
}