import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/*
 * ======================================================================
 * CLASS NAME       : LE2.3GUI Decimal to Hex
 * DESCRIPTION      : This class converts an inputted decimal number into its
 *                    hexadecimal representation with GUI.
 * AUTHOR           : Mickel Angelo Castoverde
 * COPYRIGHT        : macastroverde 2025
 * REVISION HISTORY
 * Date:            By:                 Description
 * 2025-09-22       macastroverde       Creation of the GUI program
 * ======================================================================
 */
public class LE2_3GUI extends Application {

	private TextField decimalField;
	private Label resultLabel;

	/*
	 * ======================================================================
	 * METHOD NAME : start
	 * DESCRIPTION : The main entry point for the JavaFX application.
	 * This method sets up the user interface.
	 * PRE-CONDITION : The JavaFX runtime must be initialized.
	 * POST-CONDITION : The GUI window is displayed, ready for user interaction.
	 * ======================================================================
	 */
	@Override
	public void start(Stage primaryStage) {
		// ui layout
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// ui components
		Label titleLabel = new Label("Decimal to Hex");
		titleLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // since jetbrains mono is not readily
										// available in windows

		Label decimalLabel = new Label("Decimal Number:");
		decimalField = new TextField();
		decimalField.setPromptText("Enter a decimal number");

		Button convertButton = new Button("Convert to Hex");

		resultLabel = new Label("Result here.");

		// adding components to grid
		grid.add(decimalLabel, 0, 1);
		grid.add(decimalField, 1, 1);
		grid.add(convertButton, 1, 2);
		grid.add(resultLabel, 1, 3);

		// button action
		convertButton.setOnAction(e -> convertDecimalToHex());

		// root layout and grid
		VBox root = new VBox(20);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(titleLabel, grid);

		Scene scene = new Scene(root, 400, 250);

		primaryStage.setTitle("Decimal to Hex");
		primaryStage.setScene(scene);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.show();
	}

	/*
	 * ======================================================================
	 * METHOD NAME : convertDecimalToHex
	 * DESCRIPTION : This method performs the decimal to hexadecimal
	 * conversion when the button is clicked. It retrieves and
	 * validates the input, and calculates using successive division algorithm.
	 * PRE-CONDITION : The convert button is pressed.
	 * POST-CONDITION : The resultLabel displays the calculated hexadecimal
	 * result or an error message.
	 * ======================================================================
	 */ private void convertDecimalToHex() {
		try {
			int decimal = Integer.parseInt(decimalField.getText());

			if (decimal < 0) {
				resultLabel.setText("Error: Please enter a non-negative number.");
				return;
			}

			if (decimal == 0) {
				resultLabel.setText("Hexadecimal: 0");
				return;
			}

			StringBuilder hex = new StringBuilder();
			int tempDecimal = decimal;

			while (tempDecimal > 0) {
				int remainder = tempDecimal % 16;
				char hexDigit;

				if (remainder >= 0 && remainder <= 9) {
					hexDigit = (char) ('0' + remainder);
				} else {
					hexDigit = (char) ('A' + remainder - 10);
				}

				hex.insert(0, hexDigit);
				tempDecimal /= 16;
			}

			resultLabel.setText("Hexadecimal: " + hex.toString());

		} catch (NumberFormatException e) {
			// input validation
			resultLabel.setText("Error: Please enter a valid integer.");
		}
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
