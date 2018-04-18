// Program: Redactor.java
// Purpose: Request three pieces of information from the user: an input file, an output file, and a word to look for
//			within the input file to redact before writing to the output file. Handles opening, writing, and closing
//			the files with the given file names while catching potential errors relating to doing so and presenting
//			the user with a message if an error occurs.
// Author:  Derek McCammond
// Date:    11/27/2017

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Redactor {
	public static void main(String[] args) {
		String inputFilename, outputFilename, wordToRedact;
		Scanner scan = new Scanner(System.in);
		
		// We will ask the user for three things: the names of the input file, output file, and the word to redact
		System.out.print("Enter the name of the data file: ");
		inputFilename = scan.nextLine();
		
		System.out.print("Enter the name of the output file: ");
		outputFilename = scan.nextLine();
		
		System.out.print("Enter the name to be redacted: ");
		wordToRedact = scan.nextLine();
		
		// Eclipse is never happy if you don't close your scanner.
		scan.close();
		
		// There appears to be two new lines before any output is given in the example.
		// Because either the try or the catch block can print out to console, we will
		// have to create our new lines here in order for it to work for either case.
		System.out.println("\n");
		
		try {
			// First we're going to instantiate and create our file objects. We could have either used a FileReader
			// or a scanner for reading from the file. I like the scanner method because it has the really helpful
			// "hasNextLine" method that makes our while loop super clean looking.
			Scanner inputFile = new Scanner(new File(inputFilename));
			FileWriter outputFile = new FileWriter(outputFilename);
			
			// For each line in the file, we're going to run our redact helper function on it and
			// give it the word we want redacted and feed the result directly into our output file.
			while (inputFile.hasNextLine()) {
				outputFile.write(redact(inputFile.nextLine(), wordToRedact) + "\n");
			}
			
			// Once we're finished processing the files, we'll close them.
			inputFile.close();
			outputFile.close();
			
			// If nothing went wrong, then we will tell the user to check their output file
			System.out.println("All done! Check your output file.");			
			
		} catch (IOException e) {
			// Regardless of the error, there's only a few things that could have gone wrong.
			// We will output this catch-all statement of the things that could have happened.
			// While the example shows that this can appear before the "All Done!" and have the
			// message still appear, I have intentially set this up so that that message will not
			// appear as it does not make sense to tell the user to check for a file that either
			// does not exist or is empty if something went wrong during the process of writing to it.
			System.out.println("File was not found or could not be opened.");
		}
	}
	
	// This helper function has essentially the same functionality of replaceAll. It searches for needles in the
	// haystack to know which portions of the haystack need to be replaced with "REDACTED" and replaces them all.
	public static String redact(String haystack, String needle) {
		int needleIndex;
		while ((needleIndex = haystack.indexOf(needle)) != -1) {
			haystack = haystack.substring(0, needleIndex) + "REDACTED" + 
					   haystack.substring(needleIndex + needle.length(), haystack.length());
		}
		return haystack;
	}
}
