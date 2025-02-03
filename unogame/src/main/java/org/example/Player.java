package org.example;

import lombok.Getter;
import org.example.card.Card;
import org.example.card.Deck;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player {
    private String name;
    private List<Card> hand = new ArrayList<>();

    public Player(String name) { this.name = name; }

    public void drawCard(Deck deck) { hand.add(deck.draw()); }

    public void playCard(Card card, Deck deck) {
        hand.remove(card);
        deck.discard(card);
    }

    public boolean hasWon() { return hand.isEmpty(); }

    public List<Card> getHand() { return new ArrayList<>(hand); }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name;
    }
}
