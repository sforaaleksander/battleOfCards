package com.codecool.battle.card.comparator;

import java.util.Comparator;

import com.codecool.battle.card.Card;
import com.codecool.battle.card.CardAttribute;

public class CardRoarVolumeComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return Integer.compare(card1.getAttributes().get(CardAttribute.ROARVOLUME.name()),
                card2.getAttributes().get(CardAttribute.ROARVOLUME.name()));
    }

}