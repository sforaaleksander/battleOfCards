package com.codecool.battle;

import java.util.Comparator;

public class RoarVolumeComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        if (card1.getAttributes().get("ROARVOLUME") > card2.getAttributes().get("ROARVOLUME")) {
            return 1;
        } else if (card1.getAttributes().get("ROARVOLUME") < card2.getAttributes().get("ROARVOLUME")) {
            return -1;
        }
        return 0;
    }

}