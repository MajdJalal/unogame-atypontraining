package org.example.rule;

import org.example.Player;
import org.example.card.Deck;

public interface PenaltyRule extends Rule{
    void applyPenalty(Player player, Deck deck);
}
