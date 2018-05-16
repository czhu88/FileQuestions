import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * PrintAndCount will read a file and reprint it so that at the end of each line
 * it also contains the number of words contained in that line. If the article has 
 * an empty line, it will print 0, as that line as no words. 
 */

public class PrintAndCount {
	//the main method scans the name of the file, 
	//opens the file to be read and then calls the create
	//method to create the output file
	public static void main(String[] args) throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		File inputFile = fileChecker(console); // checks if input file exists and prompts for creating output file
		Scanner input = new Scanner(inputFile); // reads the input file
		create(console, input, inputFile);
	}
	 
	//fileChecker method asks for the file name and checks if the file exists. If it doesn't
	//then it will continuously ask until an existing file name is entered.
	//It then returns the input file name.
	public static File fileChecker(Scanner console) throws FileNotFoundException {
		System.out.print("Input file name: ");
		String fileName = console.nextLine();
		File inputFile;
		do {
			inputFile = new File(fileName);
			if (inputFile.exists() == false) { // if file doesn't exist
				System.out.print("File not found. Try again: ");
				fileName = console.nextLine();				}
			} while (inputFile.exists() != true);
		return inputFile;
	}
	

	public static void create(Scanner console, Scanner input, File inputFile) throws FileNotFoundException {
	    LinkedList<String> documentLines = new LinkedList<String>();

		// if there is a next line, it will read the next line. 
	    while (input.hasNextLine()) {
			String line = input.nextLine();
	    	Scanner lineScan = new Scanner(line);
	    	int wordCount = 0;
	    	while (lineScan.hasNext()) { //while the line has more words, count them
				lineScan.next();
				wordCount++;
	    	}
	    	lineScan.close();
	    	documentLines.add(line +" "+ wordCount);
	    }
	    input.close();
	    
		PrintStream out = new PrintStream(inputFile); // in order to print in output file
		while (!documentLines.isEmpty()) { //read from the linked list to print into original file 
			out.println(documentLines.poll());
		}
		out.close();
	}
}
