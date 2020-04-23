package com.codecool.battle;

import java.util.Comparator;

public class RoarVolumeComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return Integer.compare(card1.getAttributes().get(CardAttribute.ROARVOLUME.name()),
                card2.getAttributes().get(CardAttribute.ROARVOLUME.name()));
    }

}