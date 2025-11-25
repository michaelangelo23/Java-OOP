package hangman;

import hangman.core.Hangman;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HangmanTest {

    @Test
    public void testInitialState() {
        Hangman game = new Hangman();
        assertEquals(0, game.getMisses(), "Initial misses should be 0");
        assertEquals(game.getWordToGuess().length(), game.getMaskedWord().length(), "Masked word length mismatch");
    }

    @Test
    public void testCorrectGuess() {
        Hangman game = new Hangman();
        String word = game.getWordToGuess();
        char firstChar = word.charAt(0);

        int result = game.guess(firstChar);
        assertEquals(Hangman.GUESS_CORRECT, result, "Correct guess should return GUESS_CORRECT");
        assertEquals(firstChar, game.getMaskedWord().charAt(0), "Correct guess should be revealed");
    }

    @Test
    public void testRepeatedGuess() {
        Hangman game = new Hangman();
        char firstChar = game.getWordToGuess().charAt(0);

        game.guess(firstChar);
        int result = game.guess(firstChar);
        assertEquals(Hangman.GUESS_ALREADY_IN_WORD, result, "Repeated guess should return GUESS_ALREADY_IN_WORD");
    }

    @Test
    public void testIncorrectGuess() {
        Hangman game = new Hangman();
        String word = game.getWordToGuess();
        char wrongChar = ' ';
        for (char c = 'a'; c <= 'z'; c++) {
            if (word.indexOf(c) == -1) {
                wrongChar = c;
                break;
            }
        }

        int result = game.guess(wrongChar);
        assertEquals(Hangman.GUESS_NOT_IN_WORD, result, "Incorrect guess should return GUESS_NOT_IN_WORD");
        assertEquals(1, game.getMisses(), "Misses should increment");
    }
}
