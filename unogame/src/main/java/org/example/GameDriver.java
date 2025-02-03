package org.example;

import org.example.card.Deck;
import org.example.card.factory.StandardCardFactory;
import org.example.rule.implementation.BasicCardValidationRule;
import org.example.rule.implementation.ClockwiseTurnOrderRule;
import org.example.rule.implementation.DrawTwoPenaltyRule;
import org.example.rule.implementation.SevenCardDealingRule;

import java.util.ArrayList;

public class GameDriver {
    public static void main(String[] args) {
        final UnoGameMain game = UnoGameV1.builder()
                .players(new ArrayList<>())
                .numberOfPlayers(4)
                .deck(new Deck(new StandardCardFactory()))
                .cardValidationRule(new BasicCardValidationRule())
                .penaltyRule(new DrawTwoPenaltyRule())
                .turnOrderRule(new ClockwiseTurnOrderRule())
                .cardDealingRule(new SevenCardDealingRule())
                .build();
        game.play();
    }
}