package org.example.card;

import org.example.Player;
import org.example.UnoGameMain;

public class WildCardDrawFour extends WildCard {

    public WildCardDrawFour(String color, String number) {
        super(color, number);
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getSymbol() {
        return "wildCardDrawFour";
    }

    @Override
    public void applyEffect(UnoGameMain game) {
        final Player player = game.getPlayers().get(game.getCurrentPlayerIndex());
        for(int i = 0; i < 4; i++) player.drawCard(game.getDeck());
    }
}
