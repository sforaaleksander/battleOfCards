package com.codecool.battle;

import java.util.Stack;

public class Hand {
    private Stack<Card> cards;

    public Hand(){
        this.cards = new Stack<Card>();
    }

    public Stack<Card> getCards() {
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
        return cards.pop();

    }

}