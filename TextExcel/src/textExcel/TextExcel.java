package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		
		Spreadsheet spreadsheet = new Spreadsheet();
		Scanner input = new Scanner(System.in);
		String command = "";
		while(command.equals("quit") != true){
			System.out.println("What would you like to do?");
			command = input.nextLine();
			System.out.println(spreadsheet.processCommand(command));
		}
		
		
		
		
	    // Add your command loop here
	}
}
