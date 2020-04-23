package com.codecool.battle.player;

import java.util.Stack;

import com.codecool.battle.card.Card;
import com.codecool.battle.card.CardsOnTable;

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
