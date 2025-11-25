package hangman.gui;

import hangman.core.Hangman;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Optional;

public class HangmanGUI extends Application {
    private Hangman game;
    private Label wordLabel;
    private Label statusLabel;
    private TextField inputField;
    private Button guessButton;
    private Button restartButton;

    @Override
    public void start(Stage primaryStage) {
        game = new Hangman();

        primaryStage.setTitle("Hangman Game");

        // word display
        wordLabel = new Label(game.getMaskedWord());
        wordLabel.setFont(new Font("Monospaced", 24));

        // input
        Label promptLabel = new Label("Enter a letter:");
        inputField = new TextField();
        inputField.setPrefWidth(50);
        inputField.setMaxWidth(50);
        guessButton = new Button("Guess");

        HBox inputBox = new HBox(10);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.getChildren().addAll(promptLabel, inputField, guessButton);

        // status
        statusLabel = new Label("Misses: 0");

        // restart
        restartButton = new Button("Play Again");
        restartButton.setDisable(true);

        // main
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(wordLabel, inputBox, statusLabel, restartButton);

        // event handler
        guessButton.setOnAction(e -> handleGuess());
        inputField.setOnAction(e -> handleGuess());
        restartButton.setOnAction(e -> startNewGame());

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleGuess() {
        String text = inputField.getText();
        if (text.length() != 1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a single letter.");
            alert.showAndWait();
            inputField.setText("");
            return;
        }

        char guess = text.charAt(0);
        int result = game.guess(guess);

        if (result == Hangman.GUESS_ALREADY_IN_WORD) {
            statusLabel.setText("Misses: " + game.getMisses() + " (Already guessed '" + guess + "')");
        } else if (result == Hangman.GUESS_NOT_IN_WORD) {
            statusLabel.setText("Misses: " + game.getMisses() + " ('" + guess + "' not in word)");
        } else {
            statusLabel.setText("Misses: " + game.getMisses());
        }

        wordLabel.setText(game.getMaskedWord());
        inputField.setText("");
        inputField.requestFocus();

        if (game.isWon()) {
            statusLabel.setText("You Won! Misses: " + game.getMisses());
            guessButton.setDisable(true);
            inputField.setDisable(true);
            restartButton.setDisable(false);
            
            showPlayAgainDialog();
        }
    }

    private void showPlayAgainDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("You finished the word!");
        alert.setContentText("Number of misses: " + game.getMisses() + "\nDo you want to play another word?");

        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            startNewGame();
        }
    }

    private void startNewGame() {
        game.startNewGame();
        wordLabel.setText(game.getMaskedWord());
        statusLabel.setText("Misses: 0");
        guessButton.setDisable(false);
        inputField.setDisable(false);
        restartButton.setDisable(true);
        inputField.setText("");
        inputField.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
