
/**
======================================================================
CLASS NAME : LE2.3 : Decimal to Hex
DESCRIPTION : This class converts an inputted decimal number into its
              hexadecimal representation using successive division and
              remainder.
AUTHOR     : Mickel Angelo Castoverde
COPYRIGHT  : macastroverde 2025
REVISION HISTORY
Date:           By:             Description
2025-09-17      macastroverde   Creation of the program named "Change Denomination"
2025-09-22      macastroverde   Updated documentation to new format
======================================================================
*/

import java.util.Scanner;

public class LE2_3 {
	/**
	 * ======================================================================
	 * METHOD NAME : main
	 * DESCRIPTION : Main method that prompts the user for a decimal number,
	 * performs the conversion to hexadecimal, and displays the result.
	 * PRE-CONDITION : The user must input a valid integer.
	 * POST-CONDITION: The program outputs the hexadecimal representation of
	 * the entered decimal number.
	 * ======================================================================
	 */
	public static void main(String[] args) {

		// initialize variables and object
		Scanner input = new Scanner(System.in);
		int decimal = 0;
		String hex = "";
		char hexDigit;

		// input validation for input
		System.out.print("Enter a decimal number: ");
		while (!input.hasNextInt()) {
			System.out.print("Invalid input. Please enter an integer: ");
			input.next(); // Consume the invalid input
		}
		decimal = input.nextInt();

		// for handling '0' as input
		if (decimal == 0) {
			hex = "0";
		} else {
			// using temp variable for continuous division
			int tempDecimal = decimal;
			// loop until the temp value is 0
			while (tempDecimal > 0) {
				int remainder = tempDecimal % 16;

				// algorithm for conversion
				// for remainders 0-9, convert to characters '0'-'9'
				if (remainder >= 0 && remainder <= 9) {
					hexDigit = (char) ('0' + remainder);
				} else {
					// for remainders 10-15, convert to characters 'A'-'F'
					hexDigit = (char) ('A' + remainder - 10);
				}

				// Prepend the new hex digit to build in reverse order
				hex = hexDigit + hex;

				// Perform integer division to get the next number for the loop
				tempDecimal /= 16;
			}
		}
		// display the converted decimal
		System.out.println("The hexadecimal number for " + decimal + " is: " + hex);
		input.close();
	}
}
