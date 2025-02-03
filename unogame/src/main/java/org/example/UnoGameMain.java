package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.example.card.Card;
import org.example.card.Deck;
import org.example.card.factory.StandardCardFactory;
import org.example.rule.CardDealingRule;
import org.example.rule.CardValidationRule;
import org.example.rule.PenaltyRule;
import org.example.rule.TurnOrderRule;
import org.example.rule.implementation.BasicCardValidationRule;
import org.example.rule.implementation.ClockwiseTurnOrderRule;
import org.example.rule.implementation.DrawTwoPenaltyRule;
import org.example.rule.implementation.SevenCardDealingRule;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * main uno game the defines the base rules so we can extend to create different variations.
 * and also can be extended by injecting different rules in it.
 *
 * @author majd
 * @since 02/02/2025
 */
@Setter
@Getter
@SuperBuilder
@Slf4j
public abstract class UnoGameMain {

    @Builder.Default
    protected List<Player> players = new ArrayList<>();
    @Builder.Default
    protected Deck deck = new Deck(new StandardCardFactory());
    @Builder.Default
    protected int numberOfPlayers = 2;
    protected int currentPlayerIndex;
    @Builder.Default
    protected boolean directionClockwise = true;
    protected String currentColor;
    protected String currentSymbol;
    @Builder.Default
    protected CardValidationRule cardValidationRule = new BasicCardValidationRule();
    @Builder.Default
    protected PenaltyRule penaltyRule = new DrawTwoPenaltyRule();
    @Builder.Default
    protected TurnOrderRule turnOrderRule = new ClockwiseTurnOrderRule();
    @Builder.Default
    protected CardDealingRule cardDealingRule = new SevenCardDealingRule();

    /**
     * method to start playing.
     */
    public void play() {
        initializePlayers(numberOfPlayers);
        log.info("players initialized");
        initializeDeck();
        log.info("Deck initialized");
        cardDealingRule.dealCards(players, deck);
        log.info("Cards dealt");
        startGame();
        log.info("Game started");
        while (!isGameOver()) {
            handleTurn();
            prepareNextPlayer();
        }
        declareWinner();
    }

    protected void initializePlayers(int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("Player " + (i + 1)));
        }
    }

    protected void initializeDeck() {
        deck.initialize();
        Card firstCard = deck.draw();
        deck.discard(firstCard);
        setCurrentColor(firstCard.getColor());
        setCurrentSymbol(firstCard.getSymbol());
        log.info("current color " + firstCard.getColor());
        log.info("current symbol " + firstCard.getSymbol());
        firstCard.applyEffect(this);
    }

    protected void startGame() { currentPlayerIndex = 0; }

    protected void handleTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        //check all cards in the curr player hand.
        boolean hasValidCard = currentPlayer.getHand().stream()
                .anyMatch(card -> cardValidationRule.isValid(card, currentColor, currentSymbol));

        if (!hasValidCard) {
            log.info("current player doesn't have a card to play");
            penaltyRule.applyPenalty(currentPlayer, deck);
        } else {
            List<Card> validCards = currentPlayer.getHand().stream()
                    .filter(card -> cardValidationRule.isValid(card, currentColor, currentSymbol))
                    .collect(Collectors.toList());
            System.out.println("Valid cards you can play:");
            for (int i = 0; i < validCards.size(); i++) {
                System.out.println((i + 1) + ": " + validCards.get(i));
            }

            // Step 3: Allow the user to choose a card
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose a card to play (1-" + validCards.size() + "): ");
            int choice = scanner.nextInt();

            while (!(choice > 0 && choice <= validCards.size())) {
                System.out.println("Invalid choice. Please try again.");
                choice = scanner.nextInt();
            }
            Card toPlay = validCards.get(choice - 1);
            currentPlayer.playCard(toPlay, deck);
            toPlay.applyEffect(this);
        }
    }

    protected boolean isGameOver() {
        return players.stream().anyMatch(Player::hasWon);
    }

    protected void declareWinner() {
        Player winner = players.stream().filter(Player::hasWon).findFirst().orElse(null);
        System.out.println("Winner: " + (winner != null ? winner.getName() : "None"));
    }

    protected void prepareNextPlayer() {
        currentPlayerIndex = turnOrderRule.getNextPlayerIndex(
                currentPlayerIndex, players.size(), directionClockwise
        );
        log.info("now it is "+ players.get(currentPlayerIndex) +" turn");
    }
}
