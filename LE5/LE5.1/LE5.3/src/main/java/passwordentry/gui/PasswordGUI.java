package passwordentry.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import passwordentry.core.Authenticator;

public class PasswordGUI extends Application {

    private Authenticator auth;
    private GridPane mappingGrid;
    private TextField inputField;
    private Label resultLabel;

    @Override
    public void init() {
        auth = new Authenticator("82122");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("LE5.2");

        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label instructionLabel = new Label("Enter the random numbers corresponding to your PIN (82122):");
        instructionLabel.setFont(Font.font("System", 14));

        mappingGrid = new GridPane();
        mappingGrid.setHgap(10);
        mappingGrid.setVgap(5);
        mappingGrid.setAlignment(Pos.CENTER);
        updateMappingDisplay();

        HBox inputBox = new HBox(10);
        inputBox.setAlignment(Pos.CENTER);
        Label responseLabel = new Label("Response:");
        inputField = new TextField();
        inputField.setPromptText("Enter 5 digits");
        inputBox.getChildren().addAll(responseLabel, inputField);

        Button submitButton = new Button("Login");
        submitButton.setOnAction(e -> authenticate());

        // result label
        resultLabel = new Label("");
        resultLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

        // add all to root
        root.getChildren().addAll(instructionLabel, mappingGrid, inputBox, submitButton, resultLabel);

        Scene scene = new Scene(root, 450, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateMappingDisplay() {
        mappingGrid.getChildren().clear();
        int[] mapping = auth.getMapping();

        // head
        Label pinHeader = new Label("PIN:");
        pinHeader.setFont(Font.font("Monospaced", FontWeight.BOLD, 14));
        mappingGrid.add(pinHeader, 0, 0);

        Label numHeader = new Label("NUM:");
        numHeader.setFont(Font.font("Monospaced", FontWeight.BOLD, 14));
        mappingGrid.add(numHeader, 0, 1);

        // digits
        for (int i = 0; i < 10; i++) {
            Label pinDigit = new Label(String.valueOf(i));
            pinDigit.setFont(Font.font("Monospaced", FontWeight.BOLD, 14));
            mappingGrid.add(pinDigit, i + 1, 0);

            Label randomNum = new Label(String.valueOf(mapping[i]));
            randomNum.setFont(Font.font("Monospaced", 14));
            mappingGrid.add(randomNum, i + 1, 1);
        }
    }

    private void authenticate() {
        String response = inputField.getText();
        if (auth.authenticate(response)) {
            resultLabel.setText("Authentication Successful!");
            resultLabel.setTextFill(Color.GREEN);

            // generate new mapping next attempt
            auth.generateMapping();
            updateMappingDisplay();
            inputField.clear();
        } else {
            resultLabel.setText("Authentication Failed.");
            resultLabel.setTextFill(Color.RED);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
