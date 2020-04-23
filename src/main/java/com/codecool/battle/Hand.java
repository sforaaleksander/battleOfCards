package com.codecool.battle;

import java.util.Stack;

public class Hand {
    private Stack<Card> cards;

    public Hand() {
        this.cards = new Stack<>();
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addHandCards(CardsOnTable newCards) {
        cards.addAll(newCards.getCards());
    }

    public Card getTopCard() {
        return cards.peek();
    }

    public Card popTopCard() {
        return cards.pop();
    }
}
