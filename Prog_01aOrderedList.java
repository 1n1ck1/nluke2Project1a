/*
* <Main driver class>
* CSC 1351 Programming Project No <1>
* Section <2>
* @author <Nicholas Luke>
* @since <3/17/2024>
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.io.PrintWriter;

public class Prog_01aOrderedList {
	/**
	* <Main method used to print the console text and uses accessors from other classes to change the array based on user input>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
	public static void main(String[] args) {
		boolean exists = false;
		aOrderedList list = new aOrderedList ();
		
		while (!exists) {  //the ! inverts it to be true
			System.out.println("Enter input filename: ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();

			try {
				Scanner in = GetInputFile(input); 
	
				while(in.hasNextLine())
				 {
					String name = in.nextLine();
					String[] arrOfStr = name.split(",", 5);
					if (arrOfStr[0].equalsIgnoreCase("d")) { //recognizes if first element is "D" and if so removes the 1st and 2nd elements from list
						list.remove(arrOfStr[1], Integer.parseInt(arrOfStr[2])); 
					}
					else if(arrOfStr[0].equalsIgnoreCase("a")) { //if first element is "A" then add 1st, 2nd, and 3rd element to list
						Car car = new Car(arrOfStr[1], Integer.parseInt(arrOfStr[2]), Integer.parseInt(arrOfStr[3]));
						list.add(car);
					}
			 }
				in.close();
				exists = true;
			} catch (FileNotFoundException e) {    
				System.out.println("File Specified <" + input + "> does not exist. Would you like to continue? <Y/N>");
				String answer = scanner.nextLine();
				if (answer.equalsIgnoreCase("n")) {
					exists = true;
				}
			} 
		}
		
		exists = false;
		while(!exists) {  	//if the input file was found then goes to this section for output filename 
			System.out.println("Enter output filename: ");
			Scanner scan = new Scanner(System.in);
			String userInput = scan.nextLine();
			try {
				PrintWriter outFile = GetOutputFile(userInput); 
				outFile.println(list.toString());
				outFile.close();
				exists = true;		
			}
			 catch (FileNotFoundException e) {
				 System.out.println("File Specified <" + userInput + "> is protected. Try again? <Y/N>");
					String answer = scan.nextLine();
					if (answer.equalsIgnoreCase("n")) {
						exists = true;
					}
			 }
		}
		System.out.println("Number of cars: 	" + list.size()); 
		
		for(int i = 0; i < list.size(); i++)
		System.out.println("\n Make:	" + ((Car) list.get(i)).getMake() + "\n Year:	" + ((Car) list.get(i)).getYear() + "\n Price:	" + ((Car) list.get(i)).getPrice());
			
	}
	/**
	* <Reads what the user inputs for input file name>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
	public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
		 File inputFile = new File(UserPrompt);
		 Scanner in = new Scanner(inputFile);
		 return in; 
	}
	/**
	* <Reads user input and makes an output file named it>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
	public static PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException {
		PrintWriter outFile = new PrintWriter(UserPrompt);
		return outFile;
	}

}
