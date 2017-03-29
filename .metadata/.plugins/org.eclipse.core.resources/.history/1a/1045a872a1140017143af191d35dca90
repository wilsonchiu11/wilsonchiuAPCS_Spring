package textExcel;

public class PercentCell extends RealCell {
	/*
	public PercentCell(String input) {
		super(input);
	}
	public String abbreviatedCellText(){
		String percent=getUserInput();
		if(percent.length() < 10){
			percent=percent.substring(0,percent.indexOf("."))+"%";
			int difference = 10 - percent.length();
			for(int i = 0; i < difference; i++){
				percent += " ";
			}
		}
		return percent.substring(0,10);
	}
	
	public String fullCellText() {
		return (getDoubleValue()/100.0) + "";					
	}
	public double getDoubleValue(){
		
		return (Double.parseDouble(getUserInput().substring(0, getUserInput().indexOf("%")))/100);
	}
	*/
	String percent=getUserInput();
	
	
	
	public double getDoubleValue(){
		
		percent=percent.substring(0,percent.length()-1);
		double decimal=Double.parseDouble(percent);
		return decimal/100;
	}
	
	public PercentCell(String cellText){
		super(cellText);
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String percent=getUserInput();
		percent=percent.substring(0,percent.indexOf("."))+"%";
		percent+="            ";
		return percent.substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return getDoubleValue()+"";
		
	}
}
