package passwordentry.gui;

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
import passwordentry.core.TicTacToe;

public class TicTacToeApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		final BorderPane root = mkWindow(stage, 200, 200, "TicTacToe");
		final TicTacToe game = new TicTacToe();
		final char[] players = { 'X', 'O' };

		//frames
		BorderPane menu = new BorderPane();
		StackPane boardFrame = new StackPane();

		Text currentPlayerIndicator = new Text();
		Button resetButton = new Button();

		// board frame
		GridPane board = createBoard();

		//setup
		menu.prefHeight(50);

		currentPlayerIndicator.setText(Character.toString(players[game.getMoveCount() % players.length]));

		resetButton.setText("Reset");


		//cell buttons
		for (int i = 0; i < game.getBoardSize(); i++) {
			for (int j = 0; j < game.getBoardSize(); j++) {
				Button cellButton = new Button();

				//allows the use of the variables i and j in the lambda setup
				final int col = i;
				final int row = j;

				cellButton.setText(" ");
				cellButton.setStyle("-fx-text-fill: black; -fx-opacity: 1; -fx-font-weight: bold;");
				cellButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

				// handle button click
				cellButton.setOnAction(_ -> {
					char currentPlayer = players[game.getMoveCount() % players.length];
					char nextPlayer = players[(game.getMoveCount() + 1) % players.length];


					if (game.move(col, row, currentPlayer)) {
						currentPlayerIndicator.setText(Character.toString(nextPlayer));
						cellButton.setText(Character.toString(currentPlayer));
						cellButton.setDisable(true);

						if (game.winExist(col, row, currentPlayer) != '\0' || game.drawExist()) {
							for (Node node: board.getChildren()) {
								// disable all buttons
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

		// handle reset button
		resetButton.setOnAction(_ -> {
			game.reset();
			
			currentPlayerIndicator.setText(Character.toString(players[game.getMoveCount() % players.length]));

			for (Node node: board.getChildren()) {
				// reset all buttons
				if (node instanceof Button button) {
					button.setText(" ");
					button.setDisable(false);
				}
			}
		});
		
		//root
		root.setTop(menu);
		root.setCenter(boardFrame);

		//menu
		menu.setCenter(currentPlayerIndicator);
		menu.setRight(resetButton);
		
		//boardFrame
		boardFrame.getChildren().add(board);

		//show
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
		// initialization
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, width, height);

		// setup
		stage.setTitle(title);
		stage.setScene(scene);
		stage.setResizable(false);

		return root;
	}
}
