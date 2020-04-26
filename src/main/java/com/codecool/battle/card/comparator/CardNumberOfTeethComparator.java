package com.codecool.battle.card.comparator;

import java.util.Comparator;

import com.codecool.battle.card.Card;
import com.codecool.battle.card.CardAttribute;

public class CardNumberOfTeethComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return Integer.compare(card1.getAttributes().get(CardAttribute.NUMBEROFTEETH),
                card2.getAttributes().get(CardAttribute.NUMBEROFTEETH));
    }

}