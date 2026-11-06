import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        String playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            // Generate a random number between 1 and 100
            int number = random.nextInt(100) + 1;

            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nGuess a number between 1 and 100.");
            System.out.println("You have a maximum of 7 attempts.");

            // Allow a maximum of 7 valid attempts
            while (attempts < 7) {

                System.out.print("Enter your guess: ");

                // Check whether the input is an integer
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next(); // Discard invalid input
                    continue;
                }

                int guess = sc.nextInt();

                // Check whether the number is within the valid range
                if (guess < 1 || guess > 100) {
                    System.out.println(
                        "Please enter a number between 1 and 100."
                    );
                    continue;
                }

                attempts++;

                // Check the guess
                if (guess == number) {
                    System.out.println(
                        "Congratulations! You guessed correctly."
                    );
                    System.out.println("Attempts used: " + attempts);

                    int score = (8 - attempts) * 10;
                    totalScore += score;

                    System.out.println("Your score: " + score);

                    guessed = true;
                    break;
                } 
                else if (guess > number) {
                    System.out.println("Too high! Try again.");
                } 
                else {
                    System.out.println("Too low! Try again.");
                }
            }

            // Display the correct number if the player fails
            if (!guessed) {
                System.out.println(
                    "Sorry! You couldn't guess the number."
                );
                System.out.println("Correct number was: " + number);
            }

            System.out.println("Total score: " + totalScore);

            // Ask whether the player wants to play again
            System.out.print(
                "\nDo you want to play again? (yes/no): "
            );
            playAgain = sc.next();

        } while (
            playAgain.equalsIgnoreCase("yes") ||
            playAgain.equalsIgnoreCase("y")
        );

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Your final score: " + totalScore);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}



