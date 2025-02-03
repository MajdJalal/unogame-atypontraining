package org.example.rule.implementation;

import org.example.rule.TurnOrderRule;

public class ClockwiseTurnOrderRule implements TurnOrderRule {
    @Override
    public int getNextPlayerIndex(int current, int totalPlayers, boolean isClockwise) {
        return isClockwise ? (current + 1) % totalPlayers
                : (current - 1) >= 0 ? ((current - 1) % totalPlayers) : totalPlayers - 1;
    }
}
