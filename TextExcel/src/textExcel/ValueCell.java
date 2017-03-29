package textExcel;

public class ValueCell extends RealCell {
	/*
	private String value;
	
	public ValueCell(String input){
		this.value= input;
		
		getContents(input);
	}
	public double getDoubleValue(){
		return 0.0;
		
	}
	*/
	/*
	public ValueCell(String userInput) {
		super(userInput);
	}
	
	public String abbreviatedCellText() {
		double doubleValue = this.getDoubleValue();
		String lengthCount = "" + doubleValue;
		String returnString = lengthCount;
		if(lengthCount.length() > 10) {
			return(lengthCount.substring(0, 10));
		}
		else {
			for(int i = 0; i < 10 - lengthCount.length(); i++) {
				returnString += " ";
			}
		}
		return returnString;
	}
	*/
	String text=super.fullCellText();
	double decimal=Double.parseDouble(text);
	
	
	
	public double getDoubleValue(){
		return decimal;
	}
	public ValueCell(String cellText){
		super(cellText);
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		text=decimal+"";
		if(text.indexOf(".")==-1){
			text+=(".0");
		}
		
		text+="            ";
		return text.substring(0, 10);
		
		
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return super.fullCellText();
	}
}
