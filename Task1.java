package codesoft;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        Scanner scanner = new Scanner(System.in);
        int attemptsMade = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + MIN_NUMBER + " and " + MAX_NUMBER);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the correct number.");

        while (attemptsMade < MAX_ATTEMPTS) {
            attemptsMade++;
            System.out.print("Enter your guess: ");
            int playerGuess = scanner.nextInt();

            if (playerGuess == targetNumber) {
                System.out.println("Congratulations!! You guessed the correct number.");
                System.out.println("It took you " + attemptsMade + " attempts.");
                break;
            } else if (playerGuess < targetNumber) {
                System.out.println("Too low! Try guessing a higher number.");
            } else {
                System.out.println("Too high! Try guessing a lower number.");
            }

            System.out.println("Attempts left: " + (MAX_ATTEMPTS - attemptsMade));
        }

        if (attemptsMade == MAX_ATTEMPTS) {
            System.out.println("\nYou've used all your attempts. The correct number was: " + targetNumber);
            System.out.println("Better luck next time!");
        }

        scanner.close();
    }
}
