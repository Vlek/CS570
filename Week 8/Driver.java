// Program: Driver.java
// Purpose: Request employee id's from the user before asking for their hours worked and their pay rate for
//			a given week so that a "wages due" table can be printed detailing the totals for each employee
//			using a LinkedList of Employee objects.
// Author:  Derek McCammond
// Date:    12/05/2017

import java.util.LinkedList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// First thing's first, we will create and instantiate our LinkedList of type Employee
		// so that we have our collection that will store all of the Employees that the user supplies
		LinkedList<Employee> employees = new LinkedList<Employee>();
		
		// Intro header:
		printMult(' ', 16);
		System.out.println("ACME Payroll");
		printMult('-', 42);
		System.out.println("\n");
	
		// Here's were we will add all of our employee objects to our linked list. Once the user is finished,
		// they will respond with "000" which will cause it to break out of the loop without adding to the list.
		String newID = "";
		while (newID.indexOf("000") == -1) {
			System.out.print("Enter an employee ID or 000 to stop: ");
			newID = scan.nextLine(); 
			
			if (newID.indexOf("000") == -1) {
				employees.addLast(new Employee(newID));
			}
		}

		// We have the option of either using an iterator or a for-loop in this case to go over all of the employees
		// for both this segment as well as below when we print out our wages table. I went with the for-loop because
		// it seemed like cleaner code and I wouldn't have to reset the iterator. It was not worth the extra hassle
		// given that I did not need to be cognizant of which index I was at nor was I adding or removing indexes.
		for (Employee emp: employees) {
			System.out.println();
			// Because both pieces of information we are requesting from the user to fill out the rest of our
			// Employee objects with are doubles, we can have a single method that handles the validation of
			// the data that we receive. The things that change, like the messages and the minimum value, are
			// supplied to the method so that it functions appropriately for both cases.
			emp.setHours(validateInput("Enter the total number of hours worked this week for employee " + emp.getID(), 
									   "Negative values are not allowed. Try again.", 0, scan));
			emp.setPayRate(validateInput("Enter the total hourly rate ($6.00 or more)", 
										 "The hourly rate must be at least $6.00. Try again.", 6, scan));
			
			// Once we have both their hours and pay rate, we can then calculate and set their gross wages:
			emp.setGrossWages(emp.getHours() * emp.getPayRate());
		}
		
		// Print out our header for our employee wages table:
		System.out.println("\n\nWages due this week");
		printMult('-', 34);
		System.out.format("%n%-8s%-8s%-9s%-9s%n", "ID", "Hours", "Rate", "Wages");
		printMult('-', 34);
		System.out.println();
		
		// For each of our employees, we will print out a row that gives
		// their id, hours, rate, and wages in a nicely formatted way:
		for (Employee emp: employees) {
			System.out.format("%-8s%-8.2f$%6.2f  $%8.2f%n", emp.getID(), 
							emp.getHours(), emp.getPayRate(), emp.getGrossWages());
		}
		
		// Eclipse was not happy unless I closed the Scanner
		scan.close();
	}
	
	// This helper function allows us to ask the user for input and validates it based on the minimum accepted value.
	// since both questions are asking for a double, they can be requested essentially the same way with the only
	// differences being the question that's asked, the erorr message, and the minimum value that we are asking for.
	private static double validateInput(String inputMessage, String errMessage, double minValue, Scanner scan) {
		double value;
		do {
			System.out.print(inputMessage + ": ");
			value = scan.nextDouble();
			if (value < minValue) {
				System.out.println(errMessage);
			}
		} while (value < minValue);
		return value;
	}
	
	// This helper function continuously prints a single character "c" to output up to "t".
	// This is very helpful when we want multiple spaces or hyphens.
	private static void printMult(char c, int t) {
		for (int i = 0; i < t; i++) {
			System.out.print(c);
		}
	}
}
