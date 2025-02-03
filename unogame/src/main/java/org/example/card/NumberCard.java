package org.example.card;

import org.example.UnoGameMain;

public class NumberCard extends Card {

    public NumberCard(String color, String number) {
        super(color, number);
    }

    @Override
    public void applyEffect(UnoGameMain game) {
        game.setCurrentColor(getColor());
        game.setCurrentSymbol(getSymbol());
    }
}