// Program: Popeye.java
// Purpose: This program calculates the distance (both in nautical and "regular" miles) and travel times 
// 		of Popeye's boat going from Bluto's Marina to Whipy's Hamburger Haven (DISTANCE_TO_HAVEN) in both
// 		the average speed (AVERAGE_SPEED) as well as at full speed (TOP_SPEED). 
// Author: Derek McCammond
// Date: 10/8/2017

public class Popeye {
	public static void main(String[] args) {
		// Assign our static values to easily recognizable constants:
		final double TO_REGULAR_MILE	= 1.1508, // The product of this with a nautical measurement gives "regular" miles
					 TOP_SPEED 			= 5.8,
					 AVERAGE_SPEED 		= 4,
					 DISTANCE_TO_HAVEN 	= 18;
		
		// Calculate the distance (in "regular" miles) as well as the travel times:
		double distance_in_miles   = TO_REGULAR_MILE * DISTANCE_TO_HAVEN,
			   fastest_travel_time = DISTANCE_TO_HAVEN / TOP_SPEED,
			   average_travel_time = DISTANCE_TO_HAVEN / AVERAGE_SPEED;
		
		// Finally, print out all of our results to the console: 
		System.out.println("Travel time calculator");
		System.out.println("This program calculates the distance in miles from a distance given in nautical miles.");
		System.out.println("The program also calculates the time it would take to " +
							"travel the given distance at top speed and at average speed.");
		System.out.println();
		System.out.println("The distance to travel in nautical miles is: " + DISTANCE_TO_HAVEN);
		System.out.println("The equivalent in regular miles is: " + distance_in_miles);
		System.out.println("The best case travel time is: " + fastest_travel_time + 
							" hours at " + TOP_SPEED + " knots.");
		System.out.println("The average case travel time is: " + average_travel_time +
							" hours at " + AVERAGE_SPEED + " knots.");
	}
}
