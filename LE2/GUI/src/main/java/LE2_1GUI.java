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

/**
 * ======================================================================
 * CLASS NAME : LE2.1GUI Day of the Week
 * DESCRIPTION : This program calculates the day of the week for a given
 * date using Zeller's congruence, using GUI.
 * AUTHOR : Mickel Angelo Castoverde
 * COPYRIGHT : macastroverde 2025
 * REVISION HISTORY
 * Date: By: Description
 * 2025-09-22 macastroverde Creation of the GUI program
 * ======================================================================
 */

public class LE2_1GUI extends Application {

	private TextField yearField;
	private TextField monthField;
	private TextField dayField;
	private Label resultLabel;

	/*
	 * ======================================================================
	 * METHOD NAME : start
	 * DESCRIPTION : The main entry point for the JavaFX application.
	 * This method sets up the user interface.
	 * PRE-CONDITION : The JavaFX runtime must be initialized.
	 * POST-CONDITION : The GUI window is displayed, ready for user interaction.
	 * ======================================================================
	 */ @Override
	public void start(Stage primaryStage) {
		// main page
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// UI components
		Label titleLabel = new Label("Day of the Week Calculator");
		titleLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		Label yearLabel = new Label("Year:");
		yearField = new TextField();
		yearField.setPromptText("e.g., 2012");

		Label monthLabel = new Label("Month (1-12):");
		monthField = new TextField();
		monthField.setPromptText("e.g., 5");

		Label dayLabel = new Label("Day (1-31):");
		dayField = new TextField();
		dayField.setPromptText("e.g., 12");

		Button calcButton = new Button("Calculate");

		resultLabel = new Label("Result here.");

		// adding components to the grid
		grid.add(yearLabel, 0, 1);
		grid.add(yearField, 1, 1);
		grid.add(monthLabel, 0, 2);
		grid.add(monthField, 1, 2);
		grid.add(dayLabel, 0, 3);
		grid.add(dayField, 1, 3);
		grid.add(calcButton, 1, 4);
		grid.add(resultLabel, 1, 5);

		// set button action
		calcButton.setOnAction(e -> calculateDay());

		// root layout
		VBox root = new VBox(20);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(titleLabel, grid);

		Scene scene = new Scene(root, 400, 350);

		primaryStage.setTitle("Day of the Week Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/*
	 * ======================================================================
	 * METHOD NAME : calculateDay
	 * DESCRIPTION : This method performs the day of the week calculation
	 * when the button is clicked, itt retrieves, and validates the input
	 * and calculates the Zeller's congruence.
	 * PRE-CONDITION : The calculate button is pressed.
	 * POST-CONDITION : The resultLabel displays the calculated day of the week
	 * or an error message.
	 * ======================================================================
	 */ private void calculateDay() {
		try {
			// get input from text fields and parsed into integers
			int year = Integer.parseInt(yearField.getText());
			int m = Integer.parseInt(monthField.getText());
			int q = Integer.parseInt(dayField.getText());

			// input validation
			if (m < 1 || m > 12 || q < 1 || q > 31) {
				resultLabel.setText("Error: Invalid month or day.");
				return;
			}

			// applying the logic for January and February based on instruction
			if (m == 1 || m == 2) {
				m += 12;
				year -= 1;
			}
			int j = year / 100;
			int k = year % 100;
			int h = (q + ((26 * (m + 1)) / 10) + k + (k / 4) + (j / 4) + 5 * j) % 7;

			// output the day based on the output integer from h
			String[] days = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
					"Friday" };
			resultLabel.setText("Day of the week is: " + days[h]);

		} catch (NumberFormatException e) {
			// input validation as well
			resultLabel.setText("Error: Please enter valid numbers.");
		}
	}

	/*
	 * ======================================================================
	 * METHOD NAME : main
	 * DESCRIPTION : Main method to launch the JavaFX application.
	 * PRE-CONDITION : The application is executed from the command line.
	 * POST-CONDITION : The JavaFX application is launched.
	 *
	 * kapoya lord
	 * ======================================================================
	 */ public static void main(String[] args) {
		launch(args);
	}
}
