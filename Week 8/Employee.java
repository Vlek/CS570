// Class:   Employee
// Purpose: Describes an Employee object with sufficent getters and setters for their
//			hours worked, pay rate, and gross wages (hours * rate) to be used with
//			the driver program. Allows an Employee to be instantiated with or without
//			setting the employeeID initially and has a printEmployee method.
// Author:  Derek McCammond
// Date:    12/05/2017

public class Employee {

	private String employeeID;
	private double hours, payRate, grossWages;
	
	public Employee() {
		presetInfo();
	}
	
	public Employee(String id) {
		employeeID = id;
		presetInfo();
	}

	// Helper function that keeps our constructors DRY
	private void presetInfo() {
		hours = 0;
		payRate = 0;
		grossWages = 0;
	}
	
	// Getters and setters:
	public String getID() {
		return employeeID;
	}
	
	public double getHours() {
		return hours;
	}
	
	public double getPayRate() {
		return payRate;
	}
	
	public double getGrossWages() {
		return grossWages;
	}
	
	public void setID(String newID) {
		employeeID = newID;
	}
	
	public void setHours(double newHours) {
		hours = newHours;
	}
	
	public void setPayRate(double newPayRate) {
		payRate = newPayRate;
	}
	
	public void setGrossWages(double newGrossWages) {
		grossWages = newGrossWages;
	}
	
	// No output example was given, so I went with printing all of the information contained in the Employee.
	// I felt being overly descriptive was better than leaving something out.
	public void printEmployee() {
		System.out.format("ID: %s, Hours: %f, Pay: %f, Gross: %f%n", employeeID, hours, payRate, grossWages);
	}
}
	
