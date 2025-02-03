package org.example.card;

import org.example.UnoGameMain;

public class ReverseCard extends Card {


    public ReverseCard(String color, String number) {
        super(color, number);
    }

    @Override
    public void applyEffect(UnoGameMain game) {
        game.setDirectionClockwise(!game.isDirectionClockwise());
        game.setCurrentColor(getColor());
        game.setCurrentSymbol(getSymbol());
    }
}