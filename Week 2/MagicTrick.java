// Program: MagicTrick.java
// Purpose: This program asks the user for a four-digit integer, creates two "random" integers by switching the digits
// 		around, and then subtracts them. It then asks the user to supply three of the four digits of the remainder when
//		those two numbers are subtracted from each other. It then supplies the missing digit using modulus division
//		after adding all fo the given digits together.
// Author: Derek McCammond
// Date: 10/09/2017

import java.util.Scanner;

public class MagicTrick {
	public static void main(String[] args) {
		// First, we'll instantiate the scanner object as well as initialize the variable that'll hold the user's input.
		Scanner scan = new Scanner(System.in);
		int user_input;
		
		System.out.println("Magic Trick Program");
		System.out.print("Enter a four-digit number: ");
		
		// This is the first time we will be asking for input from the user. We are expecting an int
		// that is in the range 1000 through 9999 inclusive. Unfortunately, we haven't been taught about errors or
		// sanity checks just yet, so we are going to just hope that the user supplies what we are asking for.
		user_input = scan.nextInt();
		
		// Because we haven't been taught arrays yet, we will do some interesting modulus divison to get by.
		// This is a bit messy with all of the loose variables, but it gets the job done with what we know from class.
		// The division drills us down to the place that we want, and the modulus pulls out the digit. We do not need
		// to do modulus division for the thousandths place because it is able to give us the digit we want without it.
		int thousands_place 	= user_input / 1000,
			hundreds_place 		= user_input / 100 % 10,
			tens_place 			= user_input / 10 % 10,
			ones_place 			= user_input % 10;
		
		// We would use Math.random or a utility library with a string scramble method here, but, because we haven't 
		// gotten there quite yet, I have used a semi-randomizer that's going to switch the digits around in predicable 
		// yet somewhat random ways.
		int scrambled_num1 = ones_place * 1000 + hundreds_place * 100 + thousands_place * 10 + tens_place,
			scrambled_num2 = hundreds_place * 1000 + tens_place * 100 + ones_place * 10 + thousands_place;
		
		System.out.println("I have scrambled your number into two new numbers: " + 
							scrambled_num1 + " and " + scrambled_num2);
		System.out.println("Now subtract the smaller from the larger, and" +
							" secretly pick a non-zero digit from the difference.");
		System.out.println("Enter the other three digits of the difference:");
		
		// We will be hoping again that the user supplies the right sort of input (Single-digit ints). 
		// No sanity checks here.
		int resp_one = scan.nextInt();
		int resp_two = scan.nextInt();
		int resp_three = scan.nextInt();
		
		// We are using the hint's suggestion of finding the remainder of the sum of the given digits after they're
		// divided by nine. We then use that to figure out how off we are from nine which should be the missing digit.
		int missing_digit = 9 - (resp_one + resp_two + resp_three) % 9;
		
		System.out.println("The secret digit is " + missing_digit);
		
		// While this strictly wasn't covered in class, memory management is no joke. Eclipse wasn't happy without this.
		scan.close();
	}
}
