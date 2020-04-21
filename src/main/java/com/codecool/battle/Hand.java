package com.codecool.battle;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand(){
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addHandCards(CardsOnTable newCards) {
        cards.addAll(newCards.getCards());
    }

    public void moveTopCardToTable(CardsOnTable onTable) {
        Card topCard = getTopCard();
        onTable.addCard(topCard);
        cards.remove(topCard);
    }

    public Card getTopCard(){
        return cards.get(cards.size() - 1);
    }

}