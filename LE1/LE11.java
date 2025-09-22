
/**
======================================================================
CLASS NAME : LE11
DESCRIPTION : This class prompts the user to input an amount in cents (from 1 to 99). 
              It then calculates the number of coins (quarters, dimes, nickels, and pennies) needed 
              to make up that amount and displays the result.
AUTHOR     : Mickel Angelo Castoverde 
COPYRIGHT  : macastroverde 2025
REVISION HISTORY
Date:			By: 			Description 
2025-09-17		macastroverde 		Creation of the program named "Change Denomination"
======================================================================
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class LE11 {
	public static void main(String[] args) {
		/*
		 * ======================================================================
		 * METHOD NAME : main
		 * DESCRIPTION : Main method that prompts the user to enter an amount (in cents)
		 * and then calculates and prints the number of each type of coin
		 * (quarters, dimes, nickels, and pennies) needed to make up that amount.
		 * PRE-CONDITION : The user must input a valid integer between 1 and 99 cents.
		 * POST-CONDITION : The program outputs the number of each coin needed to make
		 * up the amount entered by the user.
		 * ======================================================================
		 */

		// initialize variable
		final int quarter = 25, dime = 10, nickel = 5, penny = 1;
		int userInput = 0, result = 0;
		boolean isValidInput = false;

		Scanner input = new Scanner(System.in);

		// asks the user for the amount to input
		System.out.print("Enter amount (from 1 - 99 cents): ");

		while (!isValidInput) {
			try {
				userInput = input.nextInt();
				if (userInput >= 1 && userInput <= 99) { // input validation if the input amount falls
										// in the said range
					isValidInput = true;
				} else {
					System.out.println("Please enter an amount between 1 - 99 cents.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input, please try again: ");
				input.nextLine(); // clean invalid input
			}
		}

		System.out.println("The change is");

		// calculate and print the amount of quarter
		result = userInput / quarter;
		System.out.println(result + " quarters");

		// calculate and print the amount of dimes
		userInput %= quarter;
		result = userInput / dime;
		System.out.println(result + " dimes");

		// calculate and print the amount of nickels
		userInput %= dime;
		result = userInput / nickel;
		System.out.println(result + " nickels");

		// calculate and print the amount of penny
		userInput %= nickel;
		result = userInput / penny;
		System.out.println(result + " penny");

		input.close();
	}
}
