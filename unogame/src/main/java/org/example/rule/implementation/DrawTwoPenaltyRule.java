package org.example.rule.implementation;

import org.example.Player;
import org.example.card.Deck;
import org.example.rule.PenaltyRule;

public class DrawTwoPenaltyRule implements PenaltyRule {
    @Override
    public void applyPenalty(Player player, Deck deck) {
        player.drawCard(deck);
        player.drawCard(deck);
    }
}
