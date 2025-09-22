
/**
======================================================================
CLASS NAME : LE12
DESCRIPTION : This class prompts the user to input a number between 0 and 1000, 
              then calculates and prints the product of its digits. It also 
              displays the digits of the number in reverse order.
AUTHOR     : Mickel Angelo Castoverde
COPYRIGHT  : macastroverde 2025
REVISION HISTORY
Date:			By: 			Description 
2025-09-17		macastroverde 		Creation of the program named "Digit Product and Reverse"
======================================================================
*/

import java.util.Scanner;

public class LE12 {
	public static void main(String[] args) {
		/*
		 * ======================================================================
		 * METHOD NAME : main
		 * DESCRIPTION : Main method that prompts the user to input a number between 0
		 * and 1000,
		 * then calculates the product of its digits and displays the digits in reverse
		 * order.
		 * Finally, it outputs the product of the digits.
		 * PRE-CONDITION : The user must input a valid integer between 0 and 1000.
		 * POST-CONDITION : The program outputs the digits of the input number in
		 * reverse order
		 * and the product of all its digits.
		 * ======================================================================
		 */

		// initialize variables
		int userInput = 0, remainder = 0, product = 1, temp = 0;
		Scanner input = new Scanner(System.in);
		StringBuilder digit = new StringBuilder();

		// prompt user for a number
		System.out.print("Enter a number between 0 and 1000: ");

		// input validation
		while (!input.hasNextInt()) {
			System.out.print("Invalid input. Please enter a valid number: ");
			input.nextLine(); // consume the invalid input
		}
		// read and store user input
		userInput = input.nextInt();
		temp = userInput;

		// calculate the product of digits and store digits
		while (userInput != 0) { // if input is 932, so it will run
			remainder = userInput % 10; // the remainder will be 2
			product *= remainder;
			userInput /= 10; // 93

			digit.append(remainder); // then 2 is appended, goes on to 23, then 239
		}

		String reverseDigits = digit.reverse().toString(); // then the digit object is reversed and

		// print the reversed digits on each new line
		for (int i = 0; i < reverseDigits.length(); i++) {
			System.out.println(reverseDigits.charAt(i));
		}
		// print the product of the digits
		System.out.println("The product of all digits in " + temp + " is " + product);

		input.close(); // close the scanner
	}
}
