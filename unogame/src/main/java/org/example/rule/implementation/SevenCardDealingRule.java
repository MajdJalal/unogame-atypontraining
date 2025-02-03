package org.example.rule.implementation;

import org.example.Player;
import org.example.card.Deck;
import org.example.rule.CardDealingRule;

import java.util.List;

public class SevenCardDealingRule implements CardDealingRule {
    @Override
    public void dealCards(List<Player> players, Deck deck) {
        players.forEach(p -> {
            for (int i = 0; i < 7; i++) p.drawCard(deck);
        });
    }
}
