package com.codecool.battle;

import java.util.Stack;

public class Deck {
    private Stack<Card> cards;
    private CardParser cardParser;

    Deck() {
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public CardParser getCardParser() {
        return cardParser;
    }

    public void multipleRepoCards() {
    }

    public void distributeCards(Player[] players){
        int cardsPerPlayer = cards.size() / players.length;
        int playerNo = 0;
        for (int i=0; i<cardsPerPlayer; i++){
            players[playerNo].getHand().addCard(cards.pop());
        }


    }
}