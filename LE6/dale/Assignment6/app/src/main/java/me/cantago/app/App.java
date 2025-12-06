package me.cantago.app;

import java.util.function.Consumer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.cantago.model.Doctor;

public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		HBox window = mkWindow(stage);
		VBox inputFrame = new VBox(10);
		VBox resultFrame = new VBox(10);

		Doctor doc1 = new Doctor();
		Doctor doc2 = new Doctor();

		setupDoctorInput(inputFrame, doc1);
		setupDoctorInput(inputFrame, doc2);

		Button checkBtn = new Button();
		checkBtn.setText("Check");

		Circle nameCheck = new Circle(5, Color.RED);
		Circle specialtyCheck = new Circle(5, Color.RED);
		Circle feeCheck = new Circle(5, Color.RED);

		HBox nameFrame = new HBox(10);
		HBox specialtyFrame = new HBox(10);
		HBox feeFrame = new HBox(10);

		Text doc1Name = new Text();
		Text doc1Specialty = new Text();
		Text doc1Fee = new Text();

		doc1Name.setText(doc1.getName());
		doc1Specialty.setText(doc1.getSpecialty());
		doc1Fee.setText(Double.toString(doc1.getOfficeVisitFee()));

		Text doc2Name = new Text();
		Text doc2Specialty = new Text();
		Text doc2Fee = new Text();

		doc2Name.setText(doc2.getName());
		doc2Specialty.setText(doc2.getSpecialty());
		doc2Fee.setText(Double.toString(doc2.getOfficeVisitFee()));

		nameFrame.getChildren().addAll(doc1Name, nameCheck, doc2Name);
		specialtyFrame.getChildren().addAll(doc1Specialty, specialtyCheck, doc2Specialty);
		feeFrame.getChildren().addAll(doc1Fee, feeCheck, doc2Fee);

		checkBtn.setOnAction(_ -> {
			doc1Name.setText(doc1.getName());
			doc1Specialty.setText(doc1.getSpecialty());
			doc1Fee.setText(Double.toString(doc1.getOfficeVisitFee()));

			doc2Name.setText(doc2.getName());
			doc2Specialty.setText(doc2.getSpecialty());
			doc2Fee.setText(Double.toString(doc2.getOfficeVisitFee()));

			if (doc1.hasSameName(doc2)) {
				nameCheck.setFill(Color.GREEN);
			} else {
				nameCheck.setFill(Color.RED);
			}

			if (doc1.hasSameSpecialty(doc2)) {
				specialtyCheck.setFill(Color.GREEN);
			} else {
				specialtyCheck.setFill(Color.RED);
			}

			if (doc1.hasSameVisitFee(doc2)) {
				feeCheck.setFill(Color.GREEN);
			} else {
				feeCheck.setFill(Color.RED);
			}
		});

		resultFrame.getChildren().addAll(checkBtn, nameFrame, specialtyFrame, feeFrame);

		window.getChildren().addAll(inputFrame, resultFrame);
		stage.show();
	}

	public void setupDoctorInput(VBox frame, Doctor doctor) {
		VBox doctorFrame = new VBox(10);
		HBox name = inputArea("Name: ", "Dale Ryoko Jose Cantago", value -> doctor.setName(value));
		HBox specialty = inputArea("Specialty: ", "Pediatrician, Obstetrician...", value -> doctor.setSpecialty(value));
		HBox visitingFee = inputArea("Office Visiting Fee:", "50000000", value -> {
			try {
				doctor.setOfficeVisitFee(Double.parseDouble(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		});
		
		doctorFrame.getChildren().addAll(name, specialty, visitingFee);
		frame.getChildren().addAll(doctorFrame);
	}

	public HBox inputArea(String prompt, String example, Consumer<String> logic) {
		HBox frame = new HBox(10);
		Text text = new Text();
		TextField input = new TextField();

		text.setText(prompt);
		input.setPromptText(example);

		input.setOnAction(e -> logic.accept(input.getText()));

		frame.getChildren().addAll(text, input);
		return frame;
	}

	public HBox mkWindow(Stage stage) {
		HBox root = new HBox(10);
		Scene scene = new Scene(root, 900, 300);

		stage.setTitle("Activity 6.2");
		stage.setScene(scene);
		stage.setResizable(false);

		return root;
	}
}
