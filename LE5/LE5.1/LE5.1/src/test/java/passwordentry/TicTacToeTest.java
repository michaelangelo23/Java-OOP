package passwordentry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import passwordentry.core.TicTacToe;

class TicTacToeTest {

    @Test
    void testInitialization() {
        TicTacToe game = new TicTacToe();
        assertEquals(3, game.getBoardSize());
        assertEquals(0, game.getMoveCount());
        assertFalse(game.isGameFinished());
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    void testMove() {
        TicTacToe game = new TicTacToe();
        assertTrue(game.move(0, 0)); // X moves
        assertEquals('X', game.getBoard()[0][0]);
        assertEquals(1, game.getMoveCount());
        assertEquals('O', game.getCurrentPlayer());
        
        assertTrue(game.move(0, 1)); // O moves
        assertEquals('O', game.getBoard()[0][1]);
        assertEquals(2, game.getMoveCount());
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    void testInvalidMove() {
        TicTacToe game = new TicTacToe();
        game.move(0, 0);
        assertFalse(game.move(0, 0)); // Occupied
        assertFalse(game.move(3, 0)); // Out of bounds
    }

    @Test
    void testWinRow() {
        TicTacToe game = new TicTacToe();
        game.move(0, 0); // X
        game.move(1, 0); // O
        game.move(0, 1); // X
        game.move(1, 1); // O
        game.move(0, 2); // X wins
        
        assertTrue(game.isGameFinished());
        assertEquals('X', game.getWinner());
    }

    @Test
    void testWinCol() {
        TicTacToe game = new TicTacToe();
        game.move(0, 0); // X
        game.move(0, 1); // O
        game.move(1, 0); // X
        game.move(0, 2); // O
        game.move(2, 0); // X wins
        
        assertTrue(game.isGameFinished());
        assertEquals('X', game.getWinner());
    }

    @Test
    void testWinDiag() {
        TicTacToe game = new TicTacToe();
        game.move(0, 0); // X
        game.move(0, 1); // O
        game.move(1, 1); // X
        game.move(0, 2); // O
        game.move(2, 2); // X wins
        
        assertTrue(game.isGameFinished());
        assertEquals('X', game.getWinner());
    }

    @Test
    void testDraw() {
        TicTacToe game = new TicTacToe();
        
        // Sequence for a draw:
        // X O X
        // X O X
        // O X O
        
        game.move(0, 0); // X
        game.move(0, 1); // O
        game.move(0, 2); // X
        
        game.move(1, 1); // O
        game.move(1, 0); // X
        game.move(2, 0); // O
        
        game.move(1, 2); // X
        game.move(2, 2); // O
        game.move(2, 1); // X
        
        assertTrue(game.isGameFinished());
        assertEquals('\0', game.getWinner());
    }
    
    @Test
    void testReset() {
        TicTacToe game = new TicTacToe();
        game.move(0, 0);
        game.reset();
        assertEquals(0, game.getMoveCount());
        assertEquals('\0', game.getBoard()[0][0]);
        assertFalse(game.isGameFinished());
    }
}
