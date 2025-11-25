package hangman.console;
import hangman.core.Hangman;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hangman game = new Hangman();
        boolean playAgain = true;

        while (playAgain) {
            game.startNewGame();
            boolean wordCompleted = false;

            while (!wordCompleted) {
                System.out.print("(Guess) Enter a letter in word " + game.getMaskedWord() + " > ");
                String input = scanner.next();

                if (input.length() != 1) {
                    System.out.println("Please enter a single letter.");
                    continue;
                }

                char guess = input.charAt(0);
                int result = game.guess(guess);

                if (result == Hangman.GUESS_ALREADY_IN_WORD) {
                    System.out.println("\t" + Character.toLowerCase(guess) + " is already in the word");
                } else if (result == Hangman.GUESS_NOT_IN_WORD) {
                    System.out.println("\t" + Character.toLowerCase(guess) + " is not in the word");
                }

                if (game.isWon()) {
                    wordCompleted = true;
                }
            }

            System.out.println("The word is " + game.getWordToGuess() + ". You missed " + game.getMisses() + " time" + (game.getMisses() == 1 ? "" : "s"));
            System.out.print("Do you want to guess another word? Enter y or n> ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }
        scanner.close();
    }
}
