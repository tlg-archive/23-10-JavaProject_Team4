package com.clashofcards.renderer;

import com.apps.util.Prompter;
import com.clashofcards.models.Ai;
import com.clashofcards.models.Card;
import com.clashofcards.models.Player;
import com.clashofcards.Ai;
import com.clashofcards.Card;
import com.clashofcards.Player;
import com.clashofcards.utils.BattleFieldDisplay;
import com.clashofcards.utils.Helper;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DefensePhase{

        BattleFieldDisplay displayer = new BattleFieldDisplay();
        Prompter prompter = new Prompter(new Scanner(System.in));
    private Object Player;

    public void aiBlockPhase (Player Ai, Player enemy, List<Card> playerBattleField, List<Card> enemyBattleField) {
            displayer.updateBattleField(enemyBattleField, playerBattleField, Ai);

            if (!playerBattleField.isEmpty()) {
                boolean wantsToAttack = promptBlock(playerBattleField, Ai, enemyBattleField);
                displayer.updateBattleField(enemyBattleField, playerBattleField, Ai);
                if (wantsToAttack) {
                    blockWithCard(playerBattleField, Ai, enemyBattleField, Player, enemy);
                }
            }

            displayer.updateBattleField(enemyBattleField, playerBattleField, Ai);
            playCard(Ai.getDeck(), playerBattleField);
            displayer.updateBattleField(enemyBattleField, playerBattleField, Ai);
        }

        boolean valid = false;
        while (!valid) {
            clearConsole();
            Prompter prompter = new Prompter(new Scanner(System.in));
            String name = prompter.prompt("Please enter your name: ");

            if (name.length() < 20) {
                valid = true;
            }

        }

        // Allow the AI to choose a card for defense
       // Card aiChosenCard = chooseCardForDefense(enemyHand);
        // Now you can use aiChosenCard to defend against the player's attack
        // Add your defensive logic here...

    }
    private Card chooseCardForDefense(List<Card> hand) {
        // Simple AI logic: Randomly choose a card from the hand
        Random random = new Random();
        int randomIndex = random.nextInt(hand.size());
        return hand.get(randomIndex);
    }

    private void displayEnemyBattlefield(List<Card> enemyBattlefield) {
        // TODO: Implement logic to display the enemy's battlefield
        for (Card card : enemyBattlefield) {
            System.out.println(card + "\n");
        }
        System.out.println();
    }

    private void showPlayerBattlefield(List<Card> playerBattlefield) {
        // TODO: Implement logic to display the player's battlefield
        for (Card card : playerBattlefield) {
            System.out.println(card + "\n");
        }
        System.out.println();
    }


    private void showPlayerHand(List<Card> playerHand) {
        System.out.println("Player's Hand:");
        int cardCount = 0;
        for (Card card : playerHand) {
            System.out.print(card + " ");
            cardCount++;

            // Change the number 5 to the desired number of cards per line
            if (cardCount % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /*
     * Clears the console screen.
     * Note: This method may not work in all environments. as jay said
     */
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}