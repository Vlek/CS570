// Class: Robot.java
// Purpose: Describes a Robot class that has several methods describing its current speed, estimated time home, as well
// 			as giving the bot the ability to charge its battery and move.
// Author: Derek McCammond
// Date: 10/18/2017

public class Robot {
	private int distanceTraveled;
	private double batteryLevel;
	
	// Constructor that instantiates a Robot class object and sets the initial values of distanceTravled and
	// batterLevel to the values given in the homework.
	public Robot() {
		distanceTraveled = 0;
		batteryLevel = 3;
	}
	
	// acts as a setter for the batterLevel class variable
	public void charge(int chargeAmount) {
		batteryLevel += chargeAmount;
	}
	
	// acts as a getter for the current speed of the robot which we get based on an algorithm using the battery level
	public double currentSpeed() {
		return Math.pow(batteryLevel, 2) * 2;
	}
	
	// acts as a setter for the distanceTraveled and batterLevel class variables based on a given algorithm
	public void moveForward(int distance) {
		distanceTraveled += distance;
		batteryLevel *= 1 - distance / (distance + 1.0);
	}
	
	// acts a getter for the estimated time home for the bot given their distance traveled and current battery level
	public double estTimeHome() {
		return distanceTraveled / currentSpeed();
	}
}
