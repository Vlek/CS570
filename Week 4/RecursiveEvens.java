// Program: RecursiveEvens.java
// Purpose: Requests an integer value from the user greater than zero, then supplies a list of all of the
// 			even numbers from that number to zero. If the user enters a negative number, they are reprompted, and,
// 			if they enter a zero, the program ends.
//
// Author: Derek McCammond
// Date: 10/23/2017

import java.util.Scanner;

public class RecursiveEvens {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// We're going to preset our input var because it is used before being set within our loop.
		int input = -1;
		String evens;
		int numEvens, numSpaces;
		
		while (input != 0) {	
			System.out.print("Enter a positive integer or 0 to end: ");
			input = scan.nextInt();
			
			if (input > 0) {
				// Because we use what is returned from getEvens in multiple places, we're going to store it in its own
				// variable. We need it in order to figure out how many even numbers we found as well as for our output
				evens = getEvens(input);
				
				// There were several ways we could figure out how many even numbers we were able to find, but this one
				// seems like the most straight forward without doing something like using arrays which I was not
				// entirely sure we were allowed to use just yet. If we were, then our recursive function could
				// return an array of ints that we could then get the length of and be done with it.
				// That being said, I am going to iterate over the returned string from getEvens that is a space
				// character delineated list of the numbers. So, if we count all of the spaces, that will be
				// count - 1. I initialize numSpaces as one to account for that missing number.
				numSpaces = 1;
				for (int i = 0; i < evens.length(); i++) {
					if (evens.charAt(i) == ' ') {
						numSpaces++;
					}
				}
				
				numEvens = numSpaces;
				
				// Because there's a case where the number of even numbers can be one, I felt it was necessary to
				// make sure that our sentence structure makes sense for all of the possible output that we could
				// return. I am using ternary operators to check numEvens to figure out whether we should refer
				// to a singular returned value or multiple accordingly
				System.out.println("The even integer" + (numEvens > 1 ? "s": "") + " between 0 and " 
									+ input + " " + (numEvens > 1 ? "are": "is") + ": " + evens);
				System.out.println("There " + (numEvens > 1 ? "are ": "is ") + numEvens + 
									" even integer" + (numEvens > 1 ? "s": "") + " between 0 and " + input);
				System.out.println();
			} else if (input < 0) {
				System.out.println("Error: you entered a negative value. Try again.\n");
			}
		}
		
		System.out.println("Bye");
		// While not covered in class, Eclipse was not happy unless I closed the scanner after using it.
		scan.close();
	}
	
	private static String getEvens(int num) {
		// Our base case is when we hit zero. We're going to simply return back zero since it is even.
		if (num == 0) {
			return "0";
		} else {
			// Our recursive case where num > 0. It is defined as giving a string with either the current value of
			// num with a space or an empty string which gets concatenated with the returned string from the call
			// to itself with num - 1 as the given parameter which will decrement the count until it reaches the base
			// case and finally propagates our strings to be concatenated and finally returned as a space character
			// delineated string of even numbers
			return (num % 2 == 0 ? num + " ": "") + getEvens(num - 1);
		}
	}
}
