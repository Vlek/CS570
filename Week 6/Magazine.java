// Program: Magazine.java
// Purpose: Create a Magazine class that extends the Publication class and adds a frequency variable along with the getters
//			and setters specific to this class. Implements the print method with Magazine-specific information added
// Author: Derek McCammond
// Date: 11/15/2017

public class Magazine extends Publication {
	
	static enum FREQUENCIES {
		WEEKLY,
		BIWEEKLY,
		MONTHLY
	}
	
	private FREQUENCIES frequency;
	
	// Constructors:
	public Magazine() {
		super();
		
		frequency = FREQUENCIES.WEEKLY;
	}
	
	public Magazine(int newPages, double newPrice, String newTitle, FREQUENCIES newFrequency) {
		super(newPages, newPrice, newTitle);
		frequency = newFrequency;
	}
	
	// Getters and setters:
	public void setFrequency(FREQUENCIES newFrequency) {
		frequency = newFrequency;
	}
	
	public FREQUENCIES getFrequency() {
		return frequency;
	}
	
	// While not necessary, it seemed a lot cleaner to have it as another getter.
	public String getFrequencyString() {
		String result;
		if (frequency == FREQUENCIES.WEEKLY) {
			result = "Weekly. 52 issues per year.";
		} else if (frequency == FREQUENCIES.BIWEEKLY) {
			result = "Bi-Weekly. 26 issues per year.";
		} else {
			result = "Monthly. 12 issues per year.";
		}
		return result;
	}
	
	// Overriden print method from Publication to include frequency of publication
	public void print() {
		System.out.println(getAsterisks(50));

		// Because this is the same for all of our output, I want to stay DRY and keep this in a var in case I have
		// to make any quick changes to it.
		String f = "%-17s%s%n";
		System.out.format(f, "Magazine title:", getTitle());
		System.out.format(f, "Publisher:", getPublisher());
		System.out.format(f, "Number of Pages:", getPages());
		System.out.format(f, "Price per issue:", getPrice());
		System.out.format(f, "Frequency:", getFrequencyString());
		
		System.out.println(getAsterisks(50));
	}
}
