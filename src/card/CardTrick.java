/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that models a magic hand of seven cards and allows the user to pick a card
 * and search for it in the hand.
 * 
 * @author [muska]
 * Student Number: [991715278]
 */
public class CardTrick {

    private final Card[] magicHand;
    private final Card luckyCard;

    // Constructor to initialize the magic hand with random cards
    public CardTrick() {
        magicHand = new Card[7];
        fillMagicHand();
        luckyCard = new Card(7, "Spades");
    }

    // Method to fill the magic hand with random cards
    private void fillMagicHand() {
        Random random = new Random();
        for (int i = 0; i < magicHand.length; i++) {
            Card card = new Card();
            card.setValue(random.nextInt(13) + 1); // Random value between 1 and 13
            card.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit from the suits array
            magicHand[i] = card;
        }
    }

    // Method to ask the user to pick a card and search for it in the magic hand
    public void pickAndSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The lucky card is: " + luckyCard);
        System.out.print("Enter the value of your card (1-13): ");
        int value = scanner.nextInt();
        System.out.print("Enter the suit of your card (hearts, diamonds, clubs, spades): ");
        String suit = scanner.next().toLowerCase();
        
        Card userCard = new Card();
        userCard.setValue(value);
        userCard.setSuit(suit);

        boolean found = false;
        for (Card card : magicHand) {
            if (card.equals(userCard)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }

    // Main method to test the CardTrick class
    public static void main(String[] args) {
        CardTrick cardTrick = new CardTrick();
        cardTrick.pickAndSearch();
    }
}
