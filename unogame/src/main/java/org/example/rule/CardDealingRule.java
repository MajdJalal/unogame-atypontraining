package org.example.rule;

import org.example.Player;
import org.example.card.Deck;

import java.util.List;

public interface CardDealingRule extends Rule {
    void dealCards(List<Player> players, Deck deck);
}
