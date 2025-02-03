package org.example.card.factory;

import org.example.card.Card;
import org.example.card.NumberCard;
import org.example.card.ReverseCard;
import org.example.card.WildCardColorChange;

import java.util.ArrayList;
import java.util.List;

public class StandardCardFactory implements CardFactory {
    @Override
    public List<Card> createCards() {
        List<Card> cards = new ArrayList<>();
        String[] colors = {"Red", "Blue", "Green", "Yellow"};

        // Add Number Cards (0-9)
        for (String color : colors) {
            for (int i = 0; i <= 9; i++) {
                cards.add(new NumberCard(color, (i+"")));
                if (i != 0) cards.add(new NumberCard(color, (i+""))); // Two of each except 0
            }
        }

        // Add Action Cards (Reverse, Skip, Draw Two)
        for (String color : colors) {
            for (int i = 0; i < 2; i++) {
                cards.add(new ReverseCard(color, "Reverse"));
            }
        }

        // Add Wild Cards
        for (int i = 0; i < 4; i++) {
            cards.add(new WildCardColorChange(null, "wildCardColorChange"));
        }

        return cards;
    }
}