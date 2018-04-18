// Class: TriviaQuestion.java
// Purpose: This class acts as a helper class for the FanQuiz.java program that performs all of the functions
//		of a given question in different formats: multiple choice, True/False, or numeric response.
// 		
//		The types are instantiated as follows:
//			Multiple choice: (Question) (Possible Answer) (Possible Answer)... (correct character response)
//			True/False:		 (Question) (Correct boolean response)
//			Numeric:		 (Question) (Correct int response)
//
// Author: Derek McCammond
// Date: 10/18/2017

public class TriviaQuestion {
	
	private String triviaQuestion;
	
	// These will hold our question's information. This is type independent because we're essentially doing
	// a catch-all here. We will use the questionType enum below in conditional statements to pull the correct
	// one(s) for the job when we go to do our question printing or checking our answers.
	private int intAnswer;
	private boolean boolAnswer;
	private char charAnswer;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String choice5;
	
	// At the beginning of questions, we're supposed to print out what number the question is. This will do
	// the headache work of keeping track of which question is which. Luckily for us, whatever order they're
	// instantiated in is the order that they'll most likely be used so we can use a static int to count for us.
	// We don't have to save this information into another variable if we didn't want to as we haven't learned
	// loops where we would be tempted to do a batch instantiating inside of an array where the numbering could
	// get thrown off, but, in the interest of doing a good job, I'm going to do so.
	private static int triviaQuestionCount;
	private int questionNumber;
	
	// This will be used in conditionals in order to handle printing and our getters/setters in a descriptive way.
	public enum questionType {numeric, multipleChoice, trueFalse};
	public questionType type;
	
	// We first create constructors for all three different types of questions where each understands how to handle
	// the information being passed. We will use doNormalInit in order to handle all of the stuff that's done regardless
	// of the type of the question. Obviously we would want to handle this in a class this one would inherit from,
	// but we haven't covered that quite yet.
	public TriviaQuestion(String question, int answer) {
		doNormalInit(question);
		type = questionType.numeric;
		
		intAnswer = answer;
	}
	
	public TriviaQuestion(String question, boolean answer) {
		doNormalInit(question);
		type = questionType.trueFalse;
		
		boolAnswer = answer;
	}
	
	// If we had covered arrays, I would have used that instead, but writing them out will do for now.
	public TriviaQuestion(String question, String c1, String c2, String c3, String c4, String c5, char answer) {
		doNormalInit(question);
		type = questionType.multipleChoice;
		
		charAnswer = answer;
		choice1 = c1;
		choice2 = c2;
		choice3 = c3;
		choice4 = c4;
		choice5 = c5;
	}
	
	// While there are differences between the three different types of questions, there are things that are the same.
	// This is the stuff that would most likely have been done within the class that this one would have inherited
	// from, but doing this hacky method stuff works for what we're doing and helps us stay DRY.
	private void doNormalInit(String question) {
		triviaQuestion = question;
		triviaQuestionCount++;
		questionNumber = triviaQuestionCount;
	}
	
	// Prints to console the question information with the correct structure depending on the type.
	public void printQuestion() {
		// We are going to take advantage of the print method instead of using println in order to finish our
		// instructions based on the type of question that is being asked. Helps us stay DRY without creating
		// another String variable unnecessarily. No readability gained in doing so.
		System.out.print(questionNumber + ". " + triviaQuestion);
		
		if (type == TriviaQuestion.questionType.multipleChoice) {
			System.out.println(" Please enter a letter.");
			System.out.println("a. " + choice1);
			System.out.println("b. " + choice2);
			System.out.println("c. " + choice3);
			System.out.println("d. " + choice4);
			System.out.println("e. " + choice5);
			System.out.println();
		} else if (type == TriviaQuestion.questionType.numeric) {
			System.out.println(" Please enter an integer.");
		} else {
			System.out.println(" (type True or False)");
		}
		
		System.out.print("Your answer: ");
	}
	
	// I went back and forth on whether to have three different versions of checkAnswer for the different types of
	// responses that we could receive based on the type of the question. Really, the formating feels like it should
	// be handled at the quiz level instead of at the question level, so I left it this way. Alternatively, I could
	// have accepted a string response and then used the different datatype classes to parse the string into what
	// I needed based on the question type.
	public boolean checkAnswer(int response) {
		return intAnswer == response;
	}
	
	public boolean checkAnswer(char response) {
		return charAnswer == response;
	}
	
	public boolean checkAnswer(boolean reponse) {
		return boolAnswer == reponse;
	}
	
	// This method Getter for the answer that's able to handle all of the different types. Because there's always
	// going to be a case where either the initial statement is true or false, there will always be a string
	// returned in the "if" or "else" case not to mention the "else if".
	public String getAnswer() {
		if (type == TriviaQuestion.questionType.multipleChoice) {
			return "" + charAnswer;
		} else if (type == TriviaQuestion.questionType.numeric) {
			return "" + intAnswer;
		} else {
			return "" + boolAnswer;
		}
	}
}
