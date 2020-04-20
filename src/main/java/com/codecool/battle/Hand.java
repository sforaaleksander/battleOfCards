package com.codecool.battle;

import java.util.List;

public class Hand {
    private List<Card> handCards;

    public List<Card> getHandCards() {
        return handCards;
    }

    public void addHandCards(CardsOnTable newCards) {
        handCards.addAll(newCards.getCards());
    }

    public void moveTopCardToTable(CardsOnTable onTable) {
        Card topCard = handCards.get(handCards.size() - 1);
        onTable.addCard(topCard);
        handCards.remove(topCard);

       
        
    }

}