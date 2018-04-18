// Program: KidsMagazine.java
// Purpose: Create a KidsMagazine class that extends the Magazine class and adds two integer variables to express the
//			suggested age range for the reader along with the getters and setters specific to this class. Implements 
//			the print method with KidsMagazine-specific information added
// Author: Derek McCammond
// Date: 11/15/2017

public class KidsMagazine extends Magazine {
	
	private int ageRangeLow, ageRangeHigh;
	
	// Constructors:
	public KidsMagazine() {
		super();
		
		ageRangeLow = 0;
		ageRangeHigh = 0;
	}
	
	public KidsMagazine(int newPages, double newPrice, String newTitle, FREQUENCIES newFrequency, 
						int newAgeRangeLow, int newAgeRangeHigh) {
		super(newPages, newPrice, newTitle, newFrequency);
		
		ageRangeLow = newAgeRangeLow;
		ageRangeHigh = newAgeRangeHigh;
	}
	
	// Getters and setters:
	
	// Overriden print method from Publication to include age range
	public void print() {
		System.out.println(getAsterisks(50));

		// Because this is the same for all of our output, I want to stay DRY and keep this in a var in case I have
		// to make any quick changes to it.
		String f = "%-17s%s%n";
		System.out.format(f, "Magazine title:", getTitle());
		System.out.format(f, "Publisher:", getPublisher());
		System.out.format(f, "Number of Pages:", getPages());
		System.out.format(f, "For ages:", ageRangeLow + " to " + ageRangeHigh);
		System.out.format(f, "Price per issue:", getPrice());
		System.out.format(f, "Frequency:", getFrequencyString());
		
		System.out.println(getAsterisks(50));
	}
}
