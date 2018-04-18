// Program: Book.java
// Purpose: Create a Book class that extends the Publication class and adds an author variable along with the getters
//			and setters specific to this class. Implements the print method with Book-specific information added
// Author: Derek McCammond
// Date: 11/15/2017

public class Book extends Publication {
	
	private String author;
	
	// Constructors:
	public Book() {
		super();
		author = "";
	}
	
	// Because we have two different constructors for Publication, it only seems fitting we should for Book as well.
	public Book(int newPages, double newPrice, String newTitle, String newAuthor) {
		super(newPages, newPrice, newTitle);
		
		author = newAuthor;
	}
	
	// Mutators/Accessors:
	public void setAuthor(String newAuthor) {
		author = newAuthor;
	}
	
	public String getAuthor() {
		return author;
	}
	
	// Overriden print method from Publication to include Author
	public void print() {
		System.out.println(getAsterisks(50));

		// Because this is the same for all of our output, I want to stay DRY and keep this in a var in case I have
		// to make any quick changes to it.
		String f = "%-17s%s%n";
		System.out.format(f, "Book title:", getTitle());
		System.out.format(f, "Author(s):", author);
		System.out.format(f, "Publisher:", getPublisher());
		System.out.format(f, "Number of Pages:", getPages());
		System.out.format(f, "Price:", getPrice());		
		
		System.out.println(getAsterisks(50));
	}
}
