package org.example.card.factory;

import org.example.card.Card;

import java.util.List;

public interface CardFactory {
    List<Card> createCards();
}