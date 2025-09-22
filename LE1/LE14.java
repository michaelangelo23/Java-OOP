
/**
======================================================================
CLASS NAME : LE14
DESCRIPTION : This class calculates the distance between two points (x1, y1) and (x2, y2) 
              using the distance formula. The user is prompted to input the coordinates 
              for both points, and the program then computes and displays the distance.
AUTHOR     : Mickel Angelo Castoverde
COPYRIGHT  : macastroverde 2025
REVISION HISTORY
Date:			By: 			Description 
2025-09-17		macastroverde 		Creation of the program named "Distance Between Two Points"
======================================================================
*/

import java.util.Scanner;

public class LE14 {
	public static void main(String[] args) {

		/*
		 * ======================================================================
		 * METHOD NAME : main
		 * DESCRIPTION : Main method that prompts the user to input coordinates
		 * (x1, y1) and (x2, y2) for two points and calculates the
		 * Euclidean distance between them.
		 * PRE-CONDITION : The user must enter valid double values for the coordinates.
		 * POST-CONDITION : The program outputs the distance between the two points.
		 * ======================================================================
		 */

		// Variables to store the coordinates and the calculated distance
		double x1 = 0, y1 = 0, x2 = 0, y2 = 0, distance = 0;
		Scanner input = new Scanner(System.in);

		// Getting the first point's coordinates from the user
		System.out.print("Enter x1 and y1: ");
		x1 = input.nextDouble();
		y1 = input.nextDouble();

		// Getting the second point's coordinates from the user
		System.out.print("Enter x2 and y2: ");
		x2 = input.nextDouble();
		y2 = input.nextDouble();

		// Calculating the distance between the two points using the Euclidean distance
		// formula
		distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		// Output the calculated distance
		System.out.println("The distance between the two points is " + distance);

		// Closing the scanner
		input.close();
	}
}
