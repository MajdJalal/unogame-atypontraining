package org.example.card;

import org.example.UnoGameMain;

public abstract class Card {
    private final String color;
    private final String symbol;

    protected Card(String color, String number) {
        this.color = color;
        this.symbol = number;
    }

    public String getColor() { return color; }

    public String getSymbol() { return symbol; }
    public abstract void applyEffect(UnoGameMain game);

    @Override
    public String toString() {
        return "Card{" +
                "color='" + color + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
