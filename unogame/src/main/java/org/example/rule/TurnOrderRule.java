package org.example.rule;

public interface TurnOrderRule extends Rule{
    int getNextPlayerIndex(int current, int totalPlayers, boolean isClockwise);
}
