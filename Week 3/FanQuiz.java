// Program: FanQuiz.java
// Purpose: Test a user to assess their knowledge of Java concepts and history with three question types: Multiple choice,
//			True/False, and Numeric. Makes use of the TriviaQuestion class in order to encapsulate the concept of a
//			question to make the code more readable and conform to Java's object oriented paradigm. After the test,
//			gives a score and a message based on the score received.
// Author: Derek McCammond
// Date: 10/18/2017

import java.util.Scanner;

public class FanQuiz {	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCorrect = 0;
		
		// Apologies in advance. I'm not the most creative person in the world, and since we're learning Java anyway...
		System.out.println("Welcome to the computer science quiz! This quiz will assess your knowledge"+
						" of Java concepts and history.\n\n");

		// Unfortunately, because we haven't learned arrays, I am going to do this boilerplate business where I am
		// instantiating all of the questions inside of the call to the handler function that does everything we 
		// need to properly handle them. I've made the handler in such a way as to return either 0 or 1 depending
		// on whether the person got the question right so at the end we can give an informed scoring printout.
		
		// Because this is a static method, we have to throw our handler function the scanner object that was
		// instantiated here unless we want to make a new one every time handleQuestion is called. While the speed 
		// improvement is extraordinarily minimal, I felt, for good form, I should reuse the object.
		
		// Question taken from the book, page 26
		numCorrect += handleQuestion(new TriviaQuestion("Who invented Java?", "Guido van Rossum", "Linus Torvalds", 
										"Bill Gates", "James Gosling", "Jean-Luc Picard", 'd'), scan);
		// Question taken from the book, page 27
		numCorrect += handleQuestion(new TriviaQuestion("What year was Java initially released to the public?", 1995), 
										scan);
		// Question taken from the book, page 26
		numCorrect += handleQuestion(new TriviaQuestion("What company did Gosling work for?", 
										"Dell", "IBM", "Sun Microsystems", "Apple", "Microsoft", 'c'), scan);
		// Question was taken from this page: https://en.wikibooks.org/wiki/Java_Programming/History
		numCorrect += handleQuestion(new TriviaQuestion("Java was initially conceptualized to make C"
										+ " and C++ obsolete.", true), scan);
		// Question was taken from this page: https://en.wikibooks.org/wiki/Java_Programming/History
		numCorrect += handleQuestion(new TriviaQuestion("Java was later focused to run on:", "Desktop computers",
										"PDAs", "Laptops", "Smartwatches", "Embedded systems", 'e'), scan);
		// Question was taken from week 3's class lecture
		numCorrect += handleQuestion(new TriviaQuestion("The best way to compare floating point numbers is with"
										+ " the \"==\" equality operator", false), scan);
		// Question taken from Week 2's slides (Slide 8)
		numCorrect += handleQuestion(new TriviaQuestion("Java prescribes to which programming paradigm:", "Logic",
										"Object-oriented", "Procedural", "Concurrent", "Functional", 'b'), scan);
		// Question taken from Week 2's slides (Slide 8)
		numCorrect += handleQuestion(new TriviaQuestion("Java is a \"high-level\" programming language", true), scan);
		// Question was taken from this page: https://en.wikibooks.org/wiki/Java_Programming/History
		numCorrect += handleQuestion(new TriviaQuestion("Java 8 was released in what year?", 2014), scan);
		// Question taken directly from Week 2's slides (slide 15)
		numCorrect += handleQuestion(new TriviaQuestion("The Java compiler produces what kind of code:", "bytecode",
										"machine language code", "class files", "executables", "text files", 'a'), scan);
		
		printScore(numCorrect);
	}
	
	// Encapsulates all of the necessary things to properly handle, on a quiz level, individual questions that are
	// passed to it. This follows as best as possible the object oriented method where a quiz would have several
	// question objects whose methods it would call to be able to interact meaningfully with it. However, things
	// like score wouldn't be held at the question level and thus are handled here. Each call to this method
	// returns either 0 or 1 to indicate whether the user got the question right to be later totalled and sent to
	// the printScore method.
	private static int handleQuestion(TriviaQuestion question, Scanner scan) {
		question.printQuestion();
		boolean gotRight;
		
		// Unfortunately, because of the strong typing, we have to do a conditional to properly type the user
		// response and then throw the typed response to the correct handler to figure out whether they got it right.
		// If there was a better way, I'm all ears, please email me: dmm545@drexel.edu
		if (question.type == TriviaQuestion.questionType.multipleChoice) {
			gotRight = question.checkAnswer(scan.next().charAt(0));
		} else if (question.type == TriviaQuestion.questionType.numeric) {
			gotRight = question.checkAnswer(scan.nextInt());
		} else {
			gotRight = question.checkAnswer(scan.nextBoolean());
		}
		
		// Because it is always going to be the case that gotRight is either true or false, we can nest our 
		// return statement without worrying that nothing will be returned.
		if (gotRight) {
			System.out.println("Correct!\n");
			return 1;
		} else {
			System.out.println("Sorry, wrong answer. The correct answer is " + question.getAnswer() + ".\n");
			return 0;
		}
	}
	
	// Takes a score from 0 - 10 and gives a score card statement based on how well the user did on the quiz.
	private static void printScore(int score) {
		System.out.println("Your score is: " + score);
		
		// After the quiz, we are going to output a description based on the score that the user got that goes from
		// least knowledgeable to stellar.
		if (score < 5) {
			System.out.println("Your computer science knowledge needs some work.");
		} else if (score < 8) {
			System.out.println("Your computer science knowledge is getting there. Keep studying!");
		} else {
			System.out.println("Your computer science knowledge is stellar! Congratulations!");
		}
		
		System.out.println("Thanks for taking the computer science quiz!");
	}
}