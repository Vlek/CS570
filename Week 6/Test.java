// Program: Test.java
// Purpose: Instantiates several Publication objects into an array, adds their publishers from another array, prints
//			them out to console, sorts them, and then prints out the publications again to prove that they had been 
//			properly sorted.
// Author: Derek McCammond
// Date: 11/15/2017

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		
		// All of these publications and publishers were taken from the homework sample output
		Publication[] pubs = {
				new Magazine(100, 9.95, "The Philadelphia Magazine", Magazine.FREQUENCIES.MONTHLY),
				new Magazine(50, 4.99, "Times Magazine", Magazine.FREQUENCIES.WEEKLY),
				new KidsMagazine(36, 3.5, "National Geografic Kids", Magazine.FREQUENCIES.MONTHLY, 7, 12),
				new Book(764, 99.14, "Java Software Solutions", "J.Lewis and W Loftus"),
				new Book(309, 9.59, "Harry Potter and the Sorcerer's Stone", "J. K. Rowling")
		};
		
		String[] publishers = {
				"Metrocorp",
				"Time Inc.",
				"National Geographic Partners",
				"Pearson",
				"Scholastic"
		};
		
		for (int i = 0; i < pubs.length; i++) {
			pubs[i].setPublisher(publishers[i]);
		}
		
		// We will first print out our publication list to show them in non-alphabetical order based on title:
		System.out.println("List of publications:\n========================");
		
		printPublications(pubs);
		
		// Here's where we're going to sort our pubs list using the array sort method. Our base-class Publication
		// has implemented the Comparable object in such a way that it will allow its children classes to use its
		// compareTo method.
		Arrays.sort(pubs);
		
		// Finally, after sorting, we are going to print out the publications again to prove that we did it:
		System.out.println("========================\n\nSorted list of publications\n========================");
		
		printPublications(pubs);
	}
	
	// Helper function that keeps us DRY for printing out all of our publications before and after a sort
	private static void printPublications(Publication[] pubs) {
		for (int i = 0; i < pubs.length; i++) {
			pubs[i].print();
			// There appears to be a double space between each publication in sample run
			System.out.println("\n");
		}
	}
}
