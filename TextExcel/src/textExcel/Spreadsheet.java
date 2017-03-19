package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid{

	Cell[][]excel;
	public Spreadsheet(){
		excel= new Cell[getRows()][getCols()];
		for(int i = 0; i< excel.length; i++){
			for(int j = 0; j<excel[j].length; j++){
				excel[i][j]= new EmptyCell();
			}
		}
		
		
		
		
	}
	@Override
	public String processCommand(String command)
	{
	/*	
		
		String[] arr= command.split(" ");
		

		if(command.equals("")){
			return "";
		}
		else if(arr.length==1){
			SpreadsheetLocation locspect= new SpreadsheetLocation(command);
			return spreadsheet[locspect.getRow()][locspect.getCol()].fullCellText();
			
			
		}
		else if(command.equalsIgnoreCase("clear")){ 
			clearSheet();
			return getGridText();
		}
		
		else if(command.equalsIgnoreCase("clear ")){
			String loca = arr[1];
			SpreadsheetLocation location= new SpreadsheetLocation(loca);
			spreadsheet[location.getRow()][location.getCol()]=new EmptyCell();
			
			return getGridText();
		}	
		else if(arr.length==3){
			
			String input = arr[2].substring(1,arr[2].length() - 1);
			setCell(new SpreadsheetLocation(arr[0]), new TextCell(input));
			return getGridText();
		}
		return "";
	}
	*/
		String[] split = command.split(" ");
		
		if(command.equals(" ")){
			return "";
		}
		else if(command.equalsIgnoreCase("clear")){
			for(int i = 0; i < getRows(); i++){
				for(int j = 0; j < getCols(); j++){
					excel[i][j] = new EmptyCell();
				}
			}
			return getGridText();	
		}
		else if(command.toLowerCase().contains("clear ")){
			String changeLoc = split[1];
			SpreadsheetLocation location = new SpreadsheetLocation(changeLoc);
			excel[location.getRow()][location.getCol()] = new EmptyCell();
			return getGridText();
		}
		else if(command.contains("=")){
			String[] splitInput = command.split(" = ");
			String loc = splitInput[0];
			String cell = splitInput[1];
			if(splitInput.length >= 3){
				System.out.println(cell += " = " + splitInput[2]);
			}
			if(cell.contains("\"")){
				cell = cell.replace("\"", "");
			}
			SpreadsheetLocation location = new SpreadsheetLocation(loc);
			excel[location.getRow()][location.getCol()] = new TextCell(cell);
	    	return getGridText(); 
		}
		else if(split.length <= 3){
			SpreadsheetLocation location = new SpreadsheetLocation(command);
			return excel[location.getRow()][location.getCol()].fullCellText();
		}
		return getGridText();
	}
	
	
	
	
	public void setCell(SpreadsheetLocation loc, Cell value) {
		excel[loc.getRow()][loc.getCol()] = value;
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
				excel[i][j] = new EmptyCell();
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
		return excel[row][column];
		
	}

	@Override
	public String getGridText()
	{
		String header= "   |";
		for(int col=0; col< 11; col++){
			header += (char) (col + 'A') + "         |";
		}
			
		for(int i = 1; i <= getRows(); i++){
			header= header + "\n";
			if(i < 10){
				header= header + i + "  |";
			}else{
				header= header + i + " |";
			}
			for(int j = 0; j < 12; j++){
				header= header + excel[i-1][j].abbreviatedCellText() + "|";
			}
		}
		header= header + "\n";
		return header;
	
	
		
		
		
		
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
