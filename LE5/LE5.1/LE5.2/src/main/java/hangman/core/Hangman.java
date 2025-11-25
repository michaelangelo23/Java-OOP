package hangman.core;

import java.util.Random;

public class Hangman {
    private String[] words = { "write", "that", "program", "java", "code", "computer", "science", "logic", "syntax","debug" };
    private String wordToGuess;
    private boolean[] guessedLetters;
    private int misses;
    private Random random;

    public static final int GUESS_CORRECT = 0;
    public static final int GUESS_NOT_IN_WORD = 1;
    public static final int GUESS_ALREADY_IN_WORD = 2;

    public Hangman() {
        random = new Random();
        startNewGame();
    }

    public void startNewGame() {
        wordToGuess = words[random.nextInt(words.length)];
        guessedLetters = new boolean[wordToGuess.length()];
        misses = 0;
    }

    public int guess(char c) {
        char guess = Character.toLowerCase(c);
        boolean alreadyGuessedInWord = false;
        boolean isPresent = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                isPresent = true;
                if (guessedLetters[i]) {
                    alreadyGuessedInWord = true;
                } else {
                    guessedLetters[i] = true;
                }
            }
        }

        if (alreadyGuessedInWord) {
            return GUESS_ALREADY_IN_WORD;
        } else if (!isPresent) {
            misses++;
            return GUESS_NOT_IN_WORD;
        } else {
            return GUESS_CORRECT;
        }
    }

    public String getMaskedWord() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (guessedLetters[i]) {
                sb.append(wordToGuess.charAt(i));
            } else {
                sb.append("*");
            }
        }
        return sb.toString();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public int getMisses() {
        return misses;
    }

    public boolean isWon() {
        for (boolean b : guessedLetters) {
            if (!b)
                return false;
        }
        return true;
    }
}
