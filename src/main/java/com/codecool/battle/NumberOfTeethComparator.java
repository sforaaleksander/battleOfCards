package com.codecool.battle;

import java.util.Comparator;

public class NumberOfTeethComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        if (card1.getAttributes().get("NUMBEROFTEETH") > card2.getAttributes().get("NUMBEROFTEETH")) {
            return 1;
        } else if (card1.getAttributes().get("NUMBEROFTEETH") < card2.getAttributes().get("NUMBEROFTEETH")) {
            return -1;
        }
        return 0;
    }

}