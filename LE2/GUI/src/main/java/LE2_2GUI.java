import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;

/*
======================================================================
CLASS NAME      : LE2.2GUI Heads or Tails
DESCRIPTION     : This class simulates flipping a coin two million times
                  and displays the total count of heads and tails using GUI.
AUTHOR          : Mickel Angelo Castoverde
COPYRIGHT       : macastroverde 2025
REVISION HISTORY
Date:           By:             Description
2025-09-22      macastroverde   Creation of the GUI program
======================================================================
*/

public class LE2_2GUI extends Application {

	private Label headsLabel;
	private Label tailsLabel;
	private final int numberOfFlips = 2000000;

	/*
	 * ======================================================================
	 * METHOD NAME : start
	 * DESCRIPTION : The main entry point for the JavaFX application.
	 * This method sets up the user interface with a button to run the
	 * simulation and labels to display the results.
	 * PRE-CONDITION : The JavaFX runtime must be initialized.
	 * POST-CONDITION : The GUI window is displayed, ready for user interaction.
	 * ======================================================================
	 */
	@Override
	public void start(Stage primaryStage) {
		// ui components
		Label titleLabel = new Label("Coin Flip Simulator");
		titleLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // jetbrains error thingy on
										// windows....hays

		headsLabel = new Label("Heads: 0");
		tailsLabel = new Label("Tails: 0");

		Button flipButton = new Button("Run");

		// button actions
		flipButton.setOnAction(e -> simulateFlips());

		// main layout and components
		VBox root = new VBox(20);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(20));
		root.getChildren().addAll(titleLabel, flipButton, headsLabel, tailsLabel);

		Scene scene = new Scene(root, 300, 200);

		primaryStage.setTitle("Heads or Tails");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/*
	 * ======================================================================
	 * METHOD NAME : simulateFlips
	 * DESCRIPTION : Simulates flipping a coin two million times and updates
	 * the GUI labels with the final counts.
	 * PRE-CONDITION : The "Flip Coin" button is pressed.
	 * POST-CONDITION : The headsLabel and tailsLabel display the final counts.
	 * ======================================================================
	 */ private void simulateFlips() {
		int tailsCount = 0, headsCount = 0;
		Random rdmDigit = new Random();

		for (int i = 0; i < numberOfFlips; i++) {
			if (rdmDigit.nextBoolean()) {
				headsCount++;
			} else {
				tailsCount++;
			}
		}
		// update the result
		headsLabel.setText("Heads: " + headsCount); // this will just keep on adding, but much faster than
								// dynamically showing
		tailsLabel.setText("Tails: " + tailsCount); // it while it adds
	}

	/*
	 * ======================================================================
	 * METHOD NAME : main
	 * DESCRIPTION : Main method to launch the JavaFX application.
	 * PRE-CONDITION : The application is executed from the command line.
	 * POST-CONDITION : The JavaFX application is launched.
	 * ======================================================================
	 */ public static void main(String[] args) {
		launch(args);
	}
}
