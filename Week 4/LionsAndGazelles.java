// Program: LionsAndGazelles.java
// Purpose: Calculates projected numbers of Gazelles and Lions based on initial given amounts over a thousand day 
//			period based two algorithms:
//
//				gTomorrow = (1 + a) * gToday - c * gToday * lToday
//				lTomorrow = (1 - b) * lToday + c * d * gToday * lToday
//			Where:
//				a = 0.01, b = 0.008, c = 0.00005, and d = 0.015
//
//			Users are prompted for initial values greater than zero, and, if they fail to give a proper number, are
//			reprompted. Once done, the program iterates through the number of days to calculate the rolling totals.
//			If it hits one of the hundred day marks, it outputs a line to console stating that day's number along with
//			the total number of gazelles and lions for the day. Once done iterating, the program gives the averages
//			as well as maximum numbers for both types of animals over the entire time period.
//
// Author: Derek McCammond
// Date: 10/23/2017


import java.util.Scanner;

public class LionsAndGazelles {
	
	final static double GAZELLE_POP_INC_NO_COMP = 0.01,
						LION_POP_DEC_WO_GAZELLE = 0.008,
						LION_ENCOUNTER = 0.00005,
						LION_POP_INC_FOR_DEVOURING = 0.015;
	final static int NUM_DAYS = 1000;

	public static void main(String[] args) {
		double averageGazelles = 0, averageLions = 0, maxGazelles = 0, maxLions = 0, 
				numGazelles, numLions, tomorrowsGazelles, tomorrowsLions;
		
		System.out.println("This program simulates the ecological balance between lion and gazelle populations");
		System.out.println("***********************************************************************************");
		System.out.println();
		
		// Because we're going to ask for input twice from the user, I took the boilerplate response checking code
		// and tucked it into its own method so that it can be called as it is below. This keeps us conforming to DRY.
		numGazelles = requestInt("Please enter the initial number of gazelles");
		numLions = requestInt("Please enter the initial number of lions");
		
		// Since we're only allowed to loop exactly one-thousand times, we have to initialize all of our maxes
		// and averages to our initial value for numGazelles and numLions accordingly. We could potentially account
		// for this within the loop, but then we would have to loop exactly once more.
		maxGazelles = numGazelles;
		maxLions = numLions;
		averageGazelles = numGazelles;
		averageLions = numLions;
		
		System.out.println("Gazelle vs. Lion population periods of 100 days");
		// this makes use of the format method's formating rules:
		// %-9s  - Indicates a string value with nine spaces left aligned
		// %-12s - Indicates a string value with twelve spaces left aligned
		// %n 	 - Indicates a newline character
		System.out.format("%-9s%-12s%-12s%n", "Day", "Gazelles", "Lions");
		System.out.println("=================================");
		
		int s = 0;
		
		for (int i = 1; i <= NUM_DAYS; i++) {
			s++;
			tomorrowsGazelles = gazellesTomorrow(numGazelles, numLions);
			tomorrowsLions = lionsTomorrow(numGazelles, numLions);
			
			numGazelles = tomorrowsGazelles;
			numLions = tomorrowsLions;
			
			// For our averages, we'll keep a rolling sum and then divide by a thousand later since we know
			// that this program will only ever be used to calculate this based on that number.
			averageGazelles += numGazelles;
			averageLions += numLions;
			
			if (numLions > maxLions) {
				maxLions = numLions;
			}
			
			if (numGazelles > maxGazelles) {
				maxGazelles = numGazelles;
			}
			

			
			// If it's the case that it's one of the 100-day marks, we gotta do our printout:
			if (i % 100 == 0) {
				// this makes use of the format method's formating rules:
				// %-9d 	- indicates a decimal int value with nine spaces left aligned
				// %-12.2f 	- indicates a float value with two precision points, 12 spaces, left aligned
				// %n 		- indicates a newline character 
				System.out.format("%-9d%-12.2f%-12.2f%n", i, numGazelles, numLions);
			}
		}
		
		System.out.println(s);
		
		System.out.format("Average number of gazelles: %.2f%n", averageGazelles / 1000);
		System.out.format("Average number of lions: %.2f%n", averageLions / 1000);
		
		System.out.format("Maximum number of gazelles: %.2f%n", maxGazelles);
		System.out.format("Maximum number of lions: %.2f%n", maxLions);
		
		System.out.println();
		System.out.println("End of population simulation program");
	}
	
	// Used to request, as many times as necessary, an integer value from the user that's greater than zero
	// with nicely formatted prompt and error message. Takes in a string that explains what the number will
	// be used to represent and returns the integer that the user finally gives.
	private static int requestInt(String request) {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		while (input < 1) {
			System.out.print(request + " (a value greater than zero): ");
			input = scan.nextInt();
			
			if (input < 1) {
				System.out.println("You must enter a value greater than zero. Try again.");
			}
			System.out.println();
		}
		return input;
	}
	
	// Returns the calculated amount of gazelles for the next day's total based on given algorithm (See header)
	private static double gazellesTomorrow(double gazelles, double lions) {
		double gazelleIncrease = (1 + GAZELLE_POP_INC_NO_COMP) * gazelles,
			   gazelleDecrease = LION_ENCOUNTER * gazelles * lions;
		return gazelleIncrease - gazelleDecrease;
	}
	
	// Returns the calculated amount of lions for the next day's total based on a given algorithm (See header)
	private static double lionsTomorrow(double gazelles, double lions) {
		double lionIncrease = LION_ENCOUNTER * LION_POP_INC_FOR_DEVOURING * gazelles * lions,
			   lionDecrease = (1 - LION_POP_DEC_WO_GAZELLE) * lions;
		return lionDecrease + lionIncrease;
	}

}
