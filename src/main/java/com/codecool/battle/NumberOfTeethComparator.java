package com.codecool.battle;

import java.util.Comparator;

public class NumberOfTeethComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return Integer.compare(card1.getAttributes().get(CardAttribute.NUMBEROFTEETH.name()),
                card2.getAttributes().get(CardAttribute.NUMBEROFTEETH.name()));
    }

}