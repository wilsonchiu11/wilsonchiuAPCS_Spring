package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{ 
	String blank;
	public SpreadsheetLocation(String cellName){
		blank=cellName;
		
	}
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        
    	int row= Integer.parseInt(blank.substring(1))-1;
    	return row;
    }

    @Override
    public int getCol()
    {
    	int col= (int)blank.charAt(0)-'A';
        // TODO Auto-generated method stub
        return col;
    }
    
    

}
