// Program: RobotTester.java
// Purpose: Used to test the Robot.java class to ensure that it is functioning properly by outputting statements
//			to console based on a given format that takes numerical formatting into consideration.
// Author: Derek McCammond
// Date: 10/18/2017

import java.text.DecimalFormat;

public class RobotTester {
	public static void main(String[] args) {
		Robot robo = new Robot();
		DecimalFormat fmt = new DecimalFormat("0.##");
		
		System.out.println("Testing the Robot class\n");
		System.out.println("myRobot current speed is " + robo.currentSpeed());
		
		robo.moveForward(9);
		
		System.out.println("myRobot current speed now is " + fmt.format(robo.currentSpeed()));
		System.out.println("It should take this much time to get home: " + fmt.format(robo.estTimeHome()));
		
		robo.charge(5);
		
		System.out.println("myRobot current speed after charging is " + robo.currentSpeed());
	}
}
