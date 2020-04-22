package com.codecool.battle;

import java.util.Stack;

public class Deck {
    private Stack<Card> cards;
    private CardRepository cardRepository;
    private final int DECKSIZE = 30;

    Deck(CardRepository cardRepository) {
        cards = new Stack<>();
        this.cardRepository = cardRepository;
        multipleRepoCards();
    }

    public Stack<Card> getCards() {
        return cards;
    }

    private void multipleRepoCards() {
        int index = 0;
        while (cards.size() < DECKSIZE) {
            Card clonedCard = cloneCard(index);
            cards.add(clonedCard);
            index++;
            if (index == cardRepository.getCards().size()) {
                index = 0;
            }
        }
    }

    private Card cloneCard(int index) {
        Card clonedCard = null;
        try {
            clonedCard = (Card) cardRepository.getCards().get(index).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedCard;
    }

    public void distributeCards(Player[] players) {
        int cardsPerPlayer = cards.size() / players.length;
        int playerNo = 0;
        for (int i = 0; i < cardsPerPlayer; i++) {
            players[playerNo].getHand().addCard(cards.pop());
        }

    }
}