package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid{

	private Cell[][] spreadsheet= new Cell [20][12];
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
		inspect(command);
		
		
		// TODO Auto-generated method stub
		return command;
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		String header= "   |";
		for(int col=0; col< 11; col++){
			
			
		}
		
		
		
		
		
		
	}
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	public String inspect(String comm){
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
