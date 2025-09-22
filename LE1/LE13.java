
/**
======================================================================
CLASS NAME : LE13
DESCRIPTION : This class calculates the Basal Metabolic Rate (BMR) for a man and a woman
              based on user input for weight, height, and age. It then calculates how many
              chocolate bars a person would need to consume in order to maintain their current weight.
AUTHOR     : Mickel Angelo Castoverde
COPYRIGHT  : macastroverde 2025
REVISION HISTORY
Date:			By: 			Description 
2025-09-17		macastroverde 		Creation of the program named "BMR Calculation and Chocolate Bar Requirement"
======================================================================
*/

import java.util.Scanner;

public class LE13 {
	public static void main(String[] args) {

		/*
		 * ======================================================================
		 * METHOD NAME : main
		 * DESCRIPTION : Main method that prompts the user for their weight, height,
		 * and age, calculates the Basal Metabolic Rate (BMR) for both
		 * a man and a woman, and then calculates the number of chocolate bars
		 * required to maintain their weight.
		 * PRE-CONDITION : The user must enter valid numeric inputs for weight, height,
		 * and age.
		 * POST-CONDITION : The program calculates and displays the number of chocolate
		 * bars needed
		 * to maintain a man’s and woman’s weight based on the input.
		 * ======================================================================
		 */

		// Constants
		final int chocoBarCal = 230; // Calories per chocolate bar

		// Variables to store user input
		double userWeight = 0.0, userHeight = 0.0, userAge = 0.0, BMRWoman = 0.0, BMRMan = 0.0;
		Scanner input = new Scanner(System.in);

		// Getting the weight from the user
		System.out.print("Enter Weight: ");
		while (!input.hasNextDouble()) {
			System.out.print("Invalid input, ");
			input.next(); // consume the invalid input
			System.out.print("Please enter a valid Weight: ");
		}
		userWeight = input.nextDouble();

		// Getting the height from the user
		System.out.print("Enter Height: ");
		while (!input.hasNextDouble()) {
			System.out.print("Invalid input, ");
			input.next(); // consume the invalid input
			System.out.print("Please enter a valid Height: ");
		}
		userHeight = input.nextDouble();

		// Getting the age from the user
		System.out.print("Enter Age: ");
		while (!input.hasNextDouble()) {
			System.out.print("Invalid input, ");
			input.next(); // consume the invalid input
			System.out.print("Please enter a valid Age: ");
		}
		userAge = input.nextDouble();

		// Calculate the Basal Metabolic Rate (BMR) for a woman
		BMRWoman = (655 + (4.3 * userWeight) + (4.7 * userHeight) - (4.7 * userAge)) / chocoBarCal;

		// Calculate the Basal Metabolic Rate (BMR) for a man
		BMRMan = (66 + (6.3 * userWeight) + (12.9 * userHeight) - (6.8 * userAge)) / chocoBarCal;

		// Output the results for both woman and man
		System.out.printf("The number of chocolate bars to consume to maintain a man's weight is %.2f\n",
				BMRMan);
		System.out.printf("The number of chocolate bars to consume to maintain a woman's weight is %.2f\n",
				BMRWoman);

		// Close the scanner
		input.close();
	}
}
