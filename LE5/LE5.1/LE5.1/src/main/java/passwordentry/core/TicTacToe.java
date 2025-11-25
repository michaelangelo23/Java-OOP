package passwordentry.core;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	private int boardSize;
	private char[][] board;
	private int moveCount;
	private boolean gameFinished;
	private char winner;

	public TicTacToe() {
		boardSize = 3;
		board = new char[boardSize][boardSize];
		reset();
	}
	
	public int getBoardSize() {
		return boardSize;
	}

	public char[][] getBoard() {
		return board;
	}

	public char getCurrentPlayer() {
		return (moveCount % 2 == 0) ? 'X' : 'O';
	}

	public char getWinner() {
		return winner;
	}

	public boolean move(int x, int y) {
		return move(x, y, getCurrentPlayer());
	}

	public boolean move(int x, int y, char s) {
		if (x < 0 || x >= boardSize || y < 0 || y >= boardSize || board[x][y] != '\0')
			return false;

		board[x][y] = s;
		moveCount += 1;
		
		char win = winExist(x, y, s);
		if (win != '\0') {
			gameFinished = true;
			winner = win;
			return true;
		}
		
		if (drawExist()) {
			gameFinished = true;
			return true;
		}

		return true;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public void display() {
		for (char[] x : board) {
			System.out.print(" ");
			for (int y = 0; y < x.length; y++) {
				System.out.print(x[y] != '\0' ? Character.toString(x[y]) : " ");
				if (y != x.length - 1)
					System.out.print(" | ");
			}
			System.out.println();
		}
	}

	public char winExist(int x, int y, char s) {
		// Check Col
		for (int i = 0; i < boardSize; i++) {
			if (board[x][i] != s)
				break;
			if (i == boardSize - 1) {
				return s;
			}
		}

		// Check Row
		for (int i = 0; i < boardSize; i++) {
			if (board[i][y] != s)
				break;
			if (i == boardSize - 1) {
				return s;
			}
		}

		// Check Diag
		if (x == y) {
			for (int i = 0; i < boardSize; i++) {
				if (board[i][i] != s)
					break;
				if (i == boardSize - 1) {
					return s;
				}
			}
		}

		if (x + y == boardSize - 1) {
			for (int i = 0; i < boardSize; i++) {
				if (board[i][(boardSize - 1) - i] != s)
					break;
				if (i == boardSize - 1) {
					return s;
				}
			}
		}

		return '\0';
	}

	public boolean drawExist() {
		if (moveCount == (Math.pow(boardSize, 2))) {
			return true;
		}
		return false;
	}

	public void reset() {
		for (char[] states : board) {
			Arrays.fill(states, '\0');
		}
		moveCount = 0;
		gameFinished = false;
		winner = '\0';
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Tic Tac Toe Console Game");
		game.display();
		
		while (!game.isGameFinished()) {
			System.out.println("Player " + game.getCurrentPlayer() + "'s turn.");
			System.out.print("Enter row (0-2) and column (0-2): ");
			
			int row = -1;
			int col = -1;
			
			if (scanner.hasNextInt()) {
				row = scanner.nextInt();
			}
			if (scanner.hasNextInt()) {
				col = scanner.nextInt();
			} else {
				scanner.next(); // consume invalid input
			}
			
			if (game.move(row, col)) {
				game.display();
			} else {
				System.out.println("Invalid move. Try again.");
			}
		}
		
		if (game.getWinner() != '\0') {
			System.out.println("Player " + game.getWinner() + " wins!");
		} else {
			System.out.println("It's a draw!");
		}
		scanner.close();
	}
}
