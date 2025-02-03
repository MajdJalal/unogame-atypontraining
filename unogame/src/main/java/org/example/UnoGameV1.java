package org.example;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.example.card.Card;

@SuperBuilder
@Slf4j
public class UnoGameV1 extends UnoGameMain{
    @Override
    protected void initializeDeck() {
        deck.initialize();
        deck.draw();
        Card secondCard = deck.draw();
        deck.discard(secondCard);
        setCurrentColor(secondCard.getColor());
        setCurrentSymbol(secondCard.getSymbol());
        log.info("current color " + secondCard.getColor());
        log.info("current symbol " + secondCard.getSymbol());
        secondCard.applyEffect(this);
    }
}
