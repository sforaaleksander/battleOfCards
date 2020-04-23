package com.codecool.battle;

import java.util.Collections;
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
        try {
            while (cards.size() < DECKSIZE) {
                Card clonedCard = cloneCard(index);
                cards.add(clonedCard);
                index++;
                if (index == cardRepository.getCards().size()) {
                    index = 0;
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private Card cloneCard(int index) throws CloneNotSupportedException {
        return (Card) cardRepository.getCards().get(index).clone();
    }

    public void distributeCards(Player[] players) {
        Collections.shuffle(cards);
        int cardsPerPlayer = cards.size() / players.length;
        for (Player player : players) {
            for (int i = 0; i < cardsPerPlayer; i++) {
                player.getHand().addCard(cards.pop());
            }
        }
    }
}
