package me.cantago.exercise5;

import java.util.Arrays;

public class TicTacToe {
	private int boardSize;
	private char[][] board;
	private int moveCount;
	private boolean gameFinished;

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

	public boolean move(int x, int y, char s) {
		if (board[x][y] != '\0')
			return false;

		board[x][y] = s;
		moveCount += 1;
		if (winExist(x, y, s) != '\0' || drawExist()) {
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
	}
}
