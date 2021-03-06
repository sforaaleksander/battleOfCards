package com.codecool.battle.card.comparator;

import java.util.Comparator;

import com.codecool.battle.card.Card;
import com.codecool.battle.card.CardAttribute;

public class CardWeightComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return Integer.compare(o1.getAttributes().get(CardAttribute.WEIGHT)
                        , o2.getAttributes().get(CardAttribute.WEIGHT));
    }
}
