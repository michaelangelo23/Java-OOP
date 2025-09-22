
/**
======================================================================
CLASS NAME : LE2.2: Simulation: Head or Tails
DESCRIPTION : This class simulates flipping a coin two million times and
              displays the total count of heads and tails.
AUTHOR     : Mickel Angelo Castoverde
COPYRIGHT  : macastroverde 2025
REVISION HISTORY
Date:           By:             Description
2025-09-17      macastroverde   Creation of the program named "Change Denomination"
2025-09-22      macastroverde   Updated documentation to new format
======================================================================
*/

import java.util.Random;

public class LE2_2 {
	/**
	 * ======================================================================
	 * METHOD NAME : main
	 * DESCRIPTION : Main method that simulates flipping a coin a predefined
	 * number of times and prints the number of heads and tails.
	 * PRE-CONDITION : The program requires no user input and runs a fixed
	 * number of simulations.
	 * POST-CONDITION : The program outputs the total number of heads and tails
	 * after the simulation is complete.
	 * ======================================================================
	 */
	public static void main(String[] args) {

		// initialize and define variables and constants
		final int numberOfFlips = 2000000;
		int tailsCount = 0, headsCount = 0;

		Random rand = new Random();

		for (int i = 0; i < numberOfFlips; i++) {
			if (rand.nextBoolean()) {
				headsCount++; // if true then heads
			} else {
				tailsCount++; // tails for false
			}
		}
		// Print the final counts to the console
		System.out.println("Heads: " + headsCount);
		System.out.println("Tails: " + tailsCount);
	}
}
