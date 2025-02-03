package org.example.rule.implementation;

import org.example.card.Card;
import org.example.card.WildCard;
import org.example.rule.CardValidationRule;

public class BasicCardValidationRule implements CardValidationRule {
    @Override
    public boolean isValid(Card card, String currentColor, String currentSymbol) {
        return card instanceof WildCard ||
                card.getColor().equals(currentColor) ||
                card.getSymbol().equals(currentSymbol);
    }
}