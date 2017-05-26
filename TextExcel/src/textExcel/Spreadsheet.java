
	
package textExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
import java.io.*;


public class Spreadsheet implements Grid
{
	private Cell[][] textExcel = new Cell [getRows()][getCols()];
	
	public Spreadsheet(){
		newSheet();
	}
	
	@Override
	public String processCommand(String command)
	{
			
		
		
		
			//checks to see if the input is anything, if not just ends here
			if(command.length() == 0 || command.equals("quit")){
				return "";
			}
			
			//splits the input by spaces
			String[] split = command.split(" ",3);
			
			//gets rid of issue if the input has lowercases or uppercases
			// for columns
			split[0] = split[0].toUpperCase();
			
			//checks to see if the input has save in it
			if(split[0].equals("SAVE")){
				return saveData(split[1]);
			}
			
			// checks for an open in the input
			if(split[0].equals("OPEN")){
				return openData(split[1]);
			}
			//checks to see if the input is only 3 characters or less
			//which could only be a cell and returns the value
			
			if(split.length == 3){
				setCellValue(split[0], split[2]);
				return getGridText();
			
			// the first value is all uppercase
			// checks to see if the first word is clear
			}else if(split[0].contains("CLEAR")){
				
				// means that its clear with a cell so clears the cell
				if(split.length == 2){
					split[1] = split[1].toUpperCase();
					clearCell(split[1]);
					
					//returns how the grid looks like afterwards
					return getGridText();
					
				}else{
					
					//clears the entire grid by making an entirely new grid
					newSheet();
					
					//returns the new grid
					return getGridText();
				}
				
			}else{
				//returns the value of the cell
				return inspectCell(split[0]);
			}	
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	@Override
	public int getRows()
	{
		//total number of rows
		return 20;
	}

	@Override
	public int getCols()
	{
		//total number of columns
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// uses spreadsheet location to find the location of the cell
		return textExcel[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		
		String grid = "   |";
		//fills in the top row with the letters
		for(int i = 0; i < getCols(); i++){
			//cast to character type for letters, add the 10 spaces between this and the next one
			grid += (char) ('A' + i) + "         |";
		}
		
		//fills in the grid
		for(int i = 1; i <= getRows(); i++){
			//makes new line at end of row and adds the number
			grid += "\n" + i;
			//fixes the spacing when the numbers hit double digits
			if(i >= 10){
				grid += " |";
			}else{
				grid += "  |";
			}
			
			//sets all the values of each part of the array
			for(int k = 0; k < getCols(); k++){
				//includes the dashed lines at the end, only lets first 10 characters show
				//Puts the cell with its values in the grid
				//i-1 because i started at 1 for numbering but arrays are zero based
				grid += textExcel[i-1][k].abbreviatedCellText() + "|";
			}
		}
		// skips to next line after finishing creating the grid
		grid += "\n";
		return grid;
	
	}
	
	public String inspectCell(String cellName){
		//creating an instance of spreadsheetLocation to use 
		//the getRow and getCol methods
		SpreadsheetLocation loc = new SpreadsheetLocation(cellName);
		//returns the full value of the cell
		return (getCell(loc).fullCellText());
	}
	
	public void clearCell(String location){
		
		//creating an instance of spreadsheetLocation to use 
		//the getRow and getCol methods
		SpreadsheetLocation loc = new SpreadsheetLocation(location);
		
		//remakes the cell into an empty cell to get rid of the value it had
		textExcel[loc.getRow()][loc.getCol()] = new EmptyCell();
	}
	
	public void newSheet(){
		//creates a new grid to make everything empty
		for(int i = 0; i < textExcel.length; i++){
			for( int j = 0; j < textExcel[i].length; j++){
				textExcel[i][j] = new EmptyCell();
			}
		}
	}
	
	public void setCellValue(String loc, String value){
		//creating an instance of spreadsheetLocation to use 
		//the getRow and getCol methods
		SpreadsheetLocation area = new SpreadsheetLocation(loc);
		//checks for quotes
		if(value.contains("\"")){
			textExcel[area.getRow()][area.getCol()] = new TextCell(value);
			//checks to see if it has a percentage
		}else if(value.contains("%")){
			textExcel[area.getRow()][area.getCol()] = new PercentCell(value);
			
			//checks for parenthesis
		}else if(value.endsWith(")")){
			textExcel[area.getRow()][area.getCol()] = new FormulaCell(value, textExcel);
			
			//if there isn't anything then it has to be a value cell
		}else{
			textExcel[area.getRow()][area.getCol()] = new ValueCell(value);
		}
		
	}
	
	public String cellType(Location loc){
		//tests for the type of cell and returns the type of cell as a string
		Cell cell = getCell(loc);
		if(cell instanceof TextCell){
			return "TextCell";
		}else if(cell instanceof PercentCell){
			return "PercentCell";
		}else if(cell instanceof ValueCell){
			return "ValueCell";
		}else{
			return "FormulaCell";
		}
	}
	
	private String saveData (String filename){ 

		PrintStream outputFile;
	
		try {
			outputFile = new PrintStream(new File(filename));
		}
	
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 20; j++){
				//makes the name or location of the cell
				String cell = ""; 
				cell += (char)(i + 'A');
				cell += j + 1;
				SpreadsheetLocation loc = new SpreadsheetLocation(cell);
				//if the cell isnt an empty cell, it sends the file the contents
				if(!(textExcel[j][i] instanceof EmptyCell)){
					outputFile.println(cell + "," + cellType(loc) + "," + textExcel[j][i].fullCellText());
				}
			}
		}
		outputFile.close();
		return "";
	}
	
	private String openData (String filename){

		Scanner outputFile;
		
		try {
			outputFile = new Scanner(new File(filename));
		}
		
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		
		while(outputFile.hasNextLine()){
			//splits the line of the file by the commas
			String[] data = outputFile.nextLine().split(",");
			//adds the percentage to the percent cell value
			if(data[1].equals("PercentCell")){
				double holder = Double.parseDouble(data[2]);
				holder = holder * 100.0;
				data[2] = Double.toString(holder);
				data[2] += "%";
			}
			//sets the value of the cell
			setCellValue(data[0], data[2]);
		}
		outputFile.close();
		return getGridText();
	}
}
	
	
	
	
	
	
	

	
	
	
	

