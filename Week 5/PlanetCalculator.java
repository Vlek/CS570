// Program: PlanetCalculator.java
// Purpose: Creates a console interface for a user to calculate their weight on different planets in our solar system.
//			The user is presented with a menu that gives four options: calculate weight for one planet, all planets,
//			display the names and gravity factors for all planets, and show the menu again. If the user gives a number
//			not in that range, it will exit the program and give a parting message.
//
// Author: Derek McCammond
// Date: 11/05/2017

import java.util.Scanner;

public class PlanetCalculator {
	
	private static String[] PLANET_NAMES = {
			"Mercury", "Venus", "Earth", "Mars", "Jupiter",
			"Saturn", "Uranus", "Neptune", "Pluto"
	};
	
	private static double[] SURFACE_GRAVITY = {
			0.39, 0.91, 1.00, 0.38, 2.87,
			1.32, 0.93, 1.23, 0.03
	};
	
	//private static Scanner SCAN = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// We will initialize the input with the user input value for "show menu"
		int input = 4;
		
		// While it's the case that we received input within our specified numbers for menu options, we will continue
		// to give output. We don't care if the person gives us a "4" as the menu appears to be printed regardless
		// of whether the user picks another entry or not.
		while (input >= 1 && input <= 4) {
			
			switch (input) {
				case 1: getPlanetWeight(scan);
					break;
				case 2: getAllPlanetsWeight(scan);
					break;
				case 3: printFactors();
					break;
			}
			printMenu();
			System.out.print("Your choice: ");
			input = scan.nextInt();
		}
		
		// If we receive something other than a number to continue using the PlanetCalculator, then we will say goodbye
		System.out.println("Have a nice day!");
	}
	
	// This method takes a scanner object in order to handle asking the user for their pounds and the planet code for
	// the planet they would like to get their weight for. It then prints out a nicely formatted message with the
	// calculated weight based on the weight (on Earth) that the user gave.
	private static void getPlanetWeight(Scanner scan) {
		double pounds = getPounds(scan);
		
		int planetCode = -1;
		
		while (planetCode < 0 || planetCode >= PLANET_NAMES.length) {
			System.out.print("Enter the code number of the planet you want: ");
			
			planetCode = scan.nextInt();
			
			if (planetCode < 0 || planetCode >= PLANET_NAMES.length) {
				System.out.println("Planet code must be a value between 0 and " + (PLANET_NAMES.length - 1) + ".\n");
			}
		}

		System.out.format("Your weight on %s is %.2f%n", PLANET_NAMES[planetCode], getWeight(pounds, planetCode));
	}
	
	// Takes a scanner object to get the user's weight (on Earth) to then calculate and print out a nicely formatted
	// list of all of the weights for each planet on our list of planets.
	private static void getAllPlanetsWeight(Scanner scan) {
		double pounds = getPounds(scan);
		System.out.println("Planet          Weight");
		System.out.println("----------------------");
		for (int i = 0; i < PLANET_NAMES.length; i++) {
			System.out.format("%-16s%-14.2f%n", PLANET_NAMES[i], getWeight(pounds, i));
		}
	}
	
	// A helper function that keeps our planet weight getters DRY by abstracting the code. Takes a scanner object
	// and askes the user for a double value above zero. Continues to ask until a valid value is given.
	private static double getPounds(Scanner scan) {
		double result = 0;
		
		while (result <= 0) {
			System.out.print("\nEnter your weight on Earth, in pounds: ");
			
			result = scan.nextDouble();
			
			if (result <= 0) {
				System.out.println("Weight must be a value greater than zero.");
			}
		}
		return result;
	}
	
	// Returns the calculated weight based on the weight given (on Earth) and the index of the planet to be used.
	private static double getWeight(double weight, int planet) {
		return SURFACE_GRAVITY[planet] * weight;
	}
	
	// Prints a formatted list of planets and their gravity factors to console.
	private static void printFactors() {
		System.out.println("Planet          Gravity Factor");
		System.out.println("------------------------------");
		for (int i = 0; i < PLANET_NAMES.length; i++) {
			System.out.format("%-16s%-14.2f%n", PLANET_NAMES[i], SURFACE_GRAVITY[i]);
		}
	}
	
	// Prints the program's menu to the console.
	private static void printMenu() {
		String[] menu = {
			"\nWelcome to the Planet Calculator!",
			"---------------------------------",
			"Enter 1 to find your weight on a given planet.",
			"Enter 2 to see your weight on all planets.",
			"Enter 3 to display all planets and gravity factors.",
			"Enter 4 to show this menu again.",
			"Enter any other number to exit the program.\n"
		};
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
	}
}
