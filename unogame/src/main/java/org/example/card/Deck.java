package org.example.card;

import org.example.card.factory.CardFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> drawPile = new ArrayList<>();
    private List<Card> discardPile = new ArrayList<>();
    private final CardFactory cardFactory;

    public Deck(CardFactory cardFactory) {
        this.cardFactory = cardFactory;
    }

    public void initialize() {
        drawPile.addAll(cardFactory.createCards());
        shuffle();
    }

    public void shuffle() { Collections.shuffle(drawPile); }

    public Card draw() {
        if (drawPile.isEmpty()) restock();
        return drawPile.remove(0);
    }

    private void restock() {
        Card top = discardPile.remove(discardPile.size() - 1);
        drawPile.addAll(discardPile);
        discardPile.clear();
        discardPile.add(top);
        shuffle();
    }

    public void discard(Card card) { discardPile.add(card); }
}
