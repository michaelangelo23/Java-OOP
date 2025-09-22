
/**
======================================================================
CLASS NAME  	: LE2.1 Day of the Week
DESCRIPTION 	: This program calculates the day of the week for a given
             	  date (year, month, day) using the Zeller's congruence
             	  algorithm.
AUTHOR    	: Mickel Angelo Castoverde
COPYRIGHT 	: macastroverde 2025
REVISION HISTORY
Date:           By:             Description
2025-09-17      macastroverde   Creation of the program
2025-09-22      Mickel Angelo   Updated documentation to new format
======================================================================
*/

import java.util.Scanner;

public class LE2_1 {
	/**
	 * ======================================================================
	 * METHOD NAME : main
	 * DESCRIPTION : Main method that prompts the user to enter a date
	 * PRE-CONDITION : The user must input a valid integer for the year,
	 * month (1-12), and day of the month (1-31).
	 * POST-CONDITION : The program outputs the name of the day of the week.
	 * ======================================================================
	 */
	public static void main(String[] args) {

		// variable declaration
		int year = 0;
		int h = 0, q = 0, m = 0, j = 0, k = 0;

		// h: day of the week
		// q: day of the month
		// m: month
		// j: century (year / 100)
		// k: year of the century (year % 100)
		Scanner input = new Scanner(System.in);

		// input validation for year
		System.out.print("Enter year: (e.g., 2012): ");
		while (!input.hasNextInt()) {
			System.out.print("Invalid input, Enter year: (e.g., 2012): ");
			input.next();
		}
		year = input.nextInt();

		// input validation for month
		System.out.print("Enter month: 1-12: ");
		while (!input.hasNextInt()) {
			System.out.print("Invalid input, Enter month: 1-12: ");
			input.next();
		}
		m = input.nextInt();

		// input validation for day of the month
		System.out.print("Enter the day of the month: 1-31: ");
		while (!input.hasNextInt()) {
			System.out.print("Invalid input, Enter the day of the month: 1-31: ");
			input.next();
		}
		q = input.nextInt();

		// algorithm for January and February to match the descriptions instruction
		if (m == 1 || m == 2) {
			m += 12;
			year -= 1;
		}

		// calculations
		j = year / 100;
		k = year % 100;

		// formula for findaing the day
		h = (q + ((26 * (m + 1)) / 10) + k + (k / 4) + (j / 4) + 5 * j) % 7;

		switch (h) {
			case 0:
				System.out.println("Day of the week is Saturday");
				break;
			case 1:
				System.out.println("Day of the week is Sunday");
				break;
			case 2:
				System.out.println("Day of the week is Monday");
				break;
			case 3:
				System.out.println("Day of the week is Tuesday");
				break;
			case 4:
				System.out.println("Day of the week is Wednesday");
				break;
			case 5:
				System.out.println("Day of the week is Thursday");
				break;
			case 6:
				System.out.println("Day of the week is Friday");
				break;
		}
		input.close();
	}
}
