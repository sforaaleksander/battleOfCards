package com.codecool.battle.card;

import java.util.Collections;
import java.util.Stack;

import com.codecool.battle.player.Player;

public class Deck {
    private Stack<Card> cards;
    private CardRepository cardRepository;

    public Deck(CardRepository cardRepository) {
        cards = new Stack<>();
        this.cardRepository = cardRepository;
        multipleRepoCards();
    }

    private void multipleRepoCards() {
        int index = 0;
        int deckSize = 30;
        while (cards.size() < deckSize) {
            Card clonedCard = cloneCard(index);
            cards.add(clonedCard);
            index++;
            if (index == cardRepository.getCards().size()) {
                index = 0;
            }
        }
    }

    private Card cloneCard(int index) {
        return (Card) cardRepository.getCards().get(index).clone();
    }

    public void distributeCards(Player[] players) {
        Collections.shuffle(cards);
        int cardsPerPlayer = cards.size() / players.length;
        for (Player player : players) {
            for (int i = 0; i < cardsPerPlayer; i++) {
                player.getHand().addCard(cards.firstElement());
                Collections.rotate(cards, -1);
            }
        }
    }
}
