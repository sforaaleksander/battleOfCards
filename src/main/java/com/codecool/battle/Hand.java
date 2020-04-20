package com.codecool.battle;

import java.util.List;

public class Hand {
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void addHandCards(CardsOnTable newCards) {
        cards.addAll(newCards.getCards());
    }

    public void moveTopCardToTable(CardsOnTable onTable) {
        Card topCard = cards.get(cards.size() - 1);
        onTable.addCard(topCard);
        cards.remove(topCard);

       
        
    }

}