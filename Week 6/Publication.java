// Program: Publication.java
// Purpose: Create an abstract class that children classes can be created off of to encapulate the idea of different
// 			types of publications including magazines and books. Creates a base template with all of the underlying
//			variables that will be in common with all publication types as well as the getters and setters for those
//			variables. Also implements Comparable specifically targeting other Publications so the overriden compareTo
//			method can be used in all child classes to sort a list of Publications.
// Author: Derek McCammond
// Date: 11/15/2017

public abstract class Publication implements Comparable <Publication> {
	
	private String publisher, title;
	private int pages;
	private double price;
	
	// Constructors:
	public Publication() {
		publisher = "";
		title = "";
		pages = 0;
		price = 0;
	}
	
	// Alternate constructor where the user is able to initialize a Publication with 
	// user-given values for pages, price, and title
	public Publication(int newPages, double newPrice, String newTitle) {
		publisher = "";
		pages = newPages;
		price = newPrice;
		title = newTitle;
	}
	
	// Getters and setters:
	public void setPublisher(String newPublisher) {
		publisher = newPublisher;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setPages(int newPages) {
		pages = newPages;
	}
	
	public int getPages() {
		return pages;
	}
	
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	
	public double getPrice() {
		return price;
	}
	
	// this abstract method will be filled out in each of its child classes as each will have special, class-specific
	// information that it will want to include in its list of things.
	public abstract void print();
	
	// Because all of our different subclasses are going to need to fill out print and make their own, it is going
	// to be helpful to have this bit of code down the line to create our astrisks without having to rehardcode strings.
	protected String getAsterisks(int numAstric) {
		String result = "";
		
		for (int i = 0; i < numAstric; i++) {
			result = result + '*';
		}
		
		return result;
	}
	
	// Overriding the compareTo function based on the Publication's Title. We will use the string method compareTo
	// in order to get our 0, 1, or -1 value necessary to properly sort Publications.
	public int compareTo(Publication other) {
		return getTitle().compareTo(other.getTitle());
	}
}
