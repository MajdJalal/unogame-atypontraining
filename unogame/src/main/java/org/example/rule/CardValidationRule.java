package org.example.rule;

import org.example.card.Card;

public interface CardValidationRule extends Rule {
    boolean isValid(Card card, String currentColor, String currentSymbol);
}
