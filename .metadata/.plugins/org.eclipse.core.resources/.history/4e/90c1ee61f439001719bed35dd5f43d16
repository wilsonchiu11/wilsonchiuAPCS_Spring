package textExcel;

public class Spreadsheet implements Grid{

	 Cell[][]spreadsheet=new Cell[getRows()][getCols()];
	
	public Spreadsheet(){
		
		for(int i = 0; i< spreadsheet.length; i++){
			for(int j = 0; j<spreadsheet[j].length; j++){
				spreadsheet[i][j]= new EmptyCell();
			}
		}
	}
	@Override

	public String processCommand(String command)
	{
		
		String[] splitCommand = command.split(" ");
		
		splitCommand[0] = splitCommand[0].toUpperCase();
		if(command.length()==0){
			return "";
		} else if(splitCommand.length >= 3){
			String userInput = splitCommand[2] + "";
			int counter = 3;
			while(counter < splitCommand.length){
				userInput += " " + splitCommand[counter];
				counter++;
			}
			String cell = splitCommand[0];
			cellAssignment(userInput, cell);
			return getGridText();
			//if its less than 3, it has to be cell inspection
		}else if(command.length() <= 3){
			return cellInspection(splitCommand[0]);
			//check if the user input has clear, has been changed to uppercase
		} else if (splitCommand[0].contains("CLEAR")){
			//if theres no spaces, then must be just clear so clear entire cell
			if(splitCommand.length == 1){
				 clearEntireCell();
				 return getGridText();
				 //if there is space, then must be clearing just one spot
			} else{
				//in case the cell isnt uppercased
				clearOneCell(splitCommand[1].toUpperCase());
				return getGridText();
			}
		}
		return "";
	}
	
	public int getRows()
	{
		return 20;
	}


	public int getCols()
	{
		return 12;
	}

	public Cell getCell(Location loc)
	{
		return spreadsheet[loc.getRow()][loc.getCol()];
	}
	
	public String getGridText()
	{
		String grid = "   |";
		//fills in the top row with the letters
		for(int i = 0; i < 12; i++){
			//cast to character type for letters, add the 10 spaces between this and the next one
			grid += (char) ('A' + i) + "         |";
		}
		
		//fills in the grid
		for(int i = 1; i <= 20; i++){
			//makes new line at end of row and adds the number
			grid += "\n" + i;
			//fixes the spacing when the numbers hit double digits
			if(i >= 10){
				grid += " |";
			}else{
				grid += "  |";
			}
			
			//sets all the values of each part of the array
			for(int k = 0; k < 12; k++){
				//includes the dashed lines at the end, only lets first 10 characters show
				//Puts the cell with its values in the grid
				//i-1 because i started at 1 for numbering but arrays are zero based
				grid += spreadsheet[i-1][k].abbreviatedCellText() + "|";
			}
		}
		// skips to next line after finishing creating the grid
		grid += "\n";
		return grid;
	}
	public String cellInspection(String cell){
		//makes new spreadsheetlocation object to get the rows and col
		SpreadsheetLocation a = new SpreadsheetLocation(cell);
		String result = spreadsheet[a.getRow()][a.getCol()].fullCellText();
		return result;
	}
	//assigns cell using Textcell constructor
	public void cellAssignment(String input, String cell){
		SpreadsheetLocation b = new SpreadsheetLocation(cell);
		//assigns cell accordingly to distinct characteristics
		if(input.contains("%")){
			spreadsheet[b.getRow()][b.getCol()] = new PercentCell(input);
		} else if(input.contains("\"")){
			spreadsheet[b.getRow()][b.getCol()] = new TextCell(input);
		} else if(input.contains("(")){
			spreadsheet[b.getRow()][b.getCol()] = new FormulaCell(input, spreadsheet);
		} else{
			spreadsheet[b.getRow()][b.getCol()] = new ValueCell(input);
		}
	}
	
	//sets everything to emptycell to clear
	public void clearEntireCell(){
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 12; j++){
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	public void clearOneCell(String cell){
		//clears one cell by making it an emptycell
		SpreadsheetLocation userInput = new SpreadsheetLocation(cell);
		spreadsheet[userInput.getRow()][userInput.getCol()] = new EmptyCell();
	}
	
	
	/*
	
	
	
	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	public void clearSheet(){
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 12; j++){
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		int row = loc.getRow();
		int column = loc.getCol();
		return spreadsheet[row][column];
		
	}

	@Override
	public String getGridText()
	{
		
		
			String grid = "   |";
			for(int i=0; i < getCols(); i++){
				grid += (char) (i + 'A') + "         |";
			}
			grid += "\n";
		
			for(int i=1; i <= getRows(); i++){
				if(i > 9){
					grid += i + " ";
				}
				if(i < 10){
					grid += i + "  ";
				}
				for(int j=0; j < getCols(); j++){
					grid += "|" + spreadsheet[i-1][j].abbreviatedCellText();
				}
				grid += "|\n";
			}
			return grid;
		
	
		
		
		
		
	
	}
	*/
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	

