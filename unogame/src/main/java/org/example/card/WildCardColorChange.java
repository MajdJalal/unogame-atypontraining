package org.example.card;

import org.example.UnoGameMain;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class WildCardColorChange extends WildCard {

    public WildCardColorChange(String color, String number) {
        super(color, number);
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getSymbol() {
        return "wildCardColorChange";
    }

    /**
     * changes the curr color randomly.
     *
     * @param game
     */
    @Override
    public void applyEffect(UnoGameMain game) {
        Scanner scanner = new Scanner(System.in);
        String[] colors = {"Red", "Green", "Blue", "Yellow"};

        System.out.println("Choose a color: ");
        for (int i = 0; i < colors.length; i++) {
            System.out.println((i + 1) + ". " + colors[i]);
        }

        int choice;
        while (true) {
            System.out.print("Enter the number of your color choice (1-4): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    break;
                }
            }
            System.out.println("Invalid choice. Please select a number between 1 and 4.");
            scanner.nextLine();
        }

        game.setCurrentColor(colors[choice - 1]);
        System.out.println("The new color is: " + colors[choice - 1]);
    }
}
