package me.cantago.app;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.cantago.exercise5.TicTacToe;

public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		//Initialization
		//Final
		final BorderPane root = mkWindow(stage, 200, 200, "TicTacToe");
		final TicTacToe game = new TicTacToe();
		final char[] players = { 'X', 'O' };

		//Frames
		BorderPane menu = new BorderPane();
		StackPane boardFrame = new StackPane();

		//Non-Final Variables

		/*
		 * Menu Ribbon Includes:
		 * Current Player Indicator -> Text
		 * Reset Button to Continue Game -> Button
		 * */
		Text currentPlayerIndicator = new Text();
		Button resetButton = new Button();

		/*
		 * Board Frame Includes:
		 * Board
		 * */
		GridPane board = createBoard();

		//Setup
		//Menu
		menu.prefHeight(50);

		//CurrentPlayerIndicator
		currentPlayerIndicator.setText(Character.toString(players[game.getMoveCount() % players.length]));

		//resetButton
		resetButton.setText("Reset");

		//Board Frame
		
		//Board

		//Logic
		//Cell Buttons
		for (int i = 0; i < game.getBoardSize(); i++) {
			for (int j = 0; j < game.getBoardSize(); j++) {
				Button cellButton = new Button();

				//Allows the use of the variables i and j in the lambda setup
				final int col = i;
				final int row = j;

				cellButton.setText(" ");
				cellButton.setStyle("-fx-text-fill: black; -fx-opacity: 1; -fx-font-weight: bold;");
				cellButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

				/*
				 * On Press Action Includes:
				 *	change current player
				 *	change button text from null or " " to player
				 *	disable button
				 *	if draw or win then disable all other buttons
				 * */
				cellButton.setOnAction(_ -> {
					char currentPlayer = players[game.getMoveCount() % players.length];
					char nextPlayer = players[(game.getMoveCount() + 1) % players.length];


					if (game.move(col, row, currentPlayer)) {
						currentPlayerIndicator.setText(Character.toString(nextPlayer));
						cellButton.setText(Character.toString(currentPlayer));
						cellButton.setDisable(true);

						if (game.winExist(col, row, currentPlayer) != '\0' || game.drawExist()) {
							for (Node node: board.getChildren()) {
								//Got this part from ChatGPT cuz i wasnt sure how to iterate and filter
								if (node instanceof Button button) {
									button.setDisable(true);
								}
							}

							if (game.winExist(col, row, currentPlayer) != '\0') {
								currentPlayerIndicator.setText("Win by " + game.winExist(col, row, currentPlayer));
							} else {
								currentPlayerIndicator.setText("DRAW");
							}

						}
					}
				});

				board.add(cellButton, col, row);
			}
		}

		/*
		 * Reset Button Must Include:
		 *	Reset Board
		 *	Reset Current Player Indicator
		 *	Reset Cell Buttons
		 * */
		resetButton.setOnAction(_ -> {
			game.reset();
			
			currentPlayerIndicator.setText(Character.toString(players[game.getMoveCount() % players.length]));

			for (Node node: board.getChildren()) {
				//Got this part from ChatGPT cuz i wasnt sure how to iterate and filter
				if (node instanceof Button button) {
					button.setText(" ");
					button.setDisable(false);
				}
			}
		});
		
		//Connect
		//Root
		root.setTop(menu);
		root.setCenter(boardFrame);

		//Menu
		menu.setCenter(currentPlayerIndicator);
		menu.setRight(resetButton);
		
		//BoardFrame
		boardFrame.getChildren().add(board);

		//Show
		setTyle(menu, boardFrame);
		stage.show();
	}

	public static GridPane createBoard() {
		GridPane board = new GridPane(1, 1);
		ColumnConstraints columnConstraints = new ColumnConstraints();
		RowConstraints rowConstraints = new RowConstraints();

		columnConstraints.setPercentWidth(100);
		rowConstraints.setPercentHeight(100);

		int addConstraintNTimes = 3;

		for (int i = 0; i < addConstraintNTimes; i++) {
			board.getColumnConstraints().add(columnConstraints);
			board.getRowConstraints().add(rowConstraints);
		}

		return board;
	}

	public static void setTyle(Region... layouts) {
		for (Region layout : layouts) {
			layout.setStyle("-fx-border-color: black; -fx-border-width: 2;");
		}
	}

	private static BorderPane mkWindow(Stage stage, double width, double height, String title) {
		// Initialization
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, width, height);

		// Setup
		stage.setTitle(title);
		stage.setScene(scene);
		stage.setResizable(false);

		return root;
	}
}
