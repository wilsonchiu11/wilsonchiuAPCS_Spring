package textExcel;

// Update this file with your own code.

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
		
				String[] splitSpace = command.split(" ");
				
				
				if(command.equals("")){
					return command;
				}
			
				else if(command.toLowerCase().equals("clear")){ 
					for(int i = 0; i < getRows(); i++){
						for(int j = 0; j < getCols(); j++){
							spreadsheet[i][j] = new EmptyCell();
						}
					}
					return getGridText();	
				}
				
				else if(splitSpace.length == 2){
					String location = splitSpace[1];
					SpreadsheetLocation loc = new SpreadsheetLocation(location);
					spreadsheet[loc.getRow()][loc.getCol()] = new EmptyCell();
					return getGridText();
				}
				
				else if(command.contains("\"")){  
					String[] split = command.split(" = ");
					String location = split[0];
					String value = split[1];
					
					if(split.length >= 3){
						System.out.println(value = value + " = " + split[2]);
					}
					SpreadsheetLocation loc = new SpreadsheetLocation(location);
					spreadsheet[loc.getRow()][loc.getCol()] = new TextCell(value.substring(1, value.length()-1)); 
			    	return getGridText(); 
			    	
				}	
				
				
				else if (splitSpace.length==1){
					
					SpreadsheetLocation loc = new SpreadsheetLocation(command);
					return spreadsheet[loc.getRow()][loc.getCol()].fullCellText();
				}
				else{
					SpreadsheetLocation loc=new SpreadsheetLocation(splitSpace[0]);
					
					if (splitSpace[2].charAt(0)==34){ 
						spreadsheet [loc.getRow()] [loc.getCol()] = new TextCell (splitSpace[2]);
					}
					
					else if (splitSpace[2].substring(splitSpace[2].length()-1).equals("%")){ 
						spreadsheet [loc.getRow()] [loc.getCol()] = new PercentCell (splitSpace[2]);	
					}
					
					else if (splitSpace[2].charAt(0) == ('(')){ 
						spreadsheet [loc.getRow()] [loc.getCol()] = new FormulaCell (splitSpace[2]);	
					}
					
					else { 
						spreadsheet [loc.getRow()] [loc.getCol()] = new ValueCell (splitSpace[2]);	
					}
					
					return getGridText();
				} 	
	}
	
	
	
	
	
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
