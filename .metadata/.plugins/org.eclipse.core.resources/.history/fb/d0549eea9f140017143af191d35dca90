package textExcel;

public abstract class RealCell implements Cell {
	/*
	private String text;
	private int length;
	
	public RealCell(String command){
		text= command;
		
	}
	public double getDoubleValue(){
		return Double.parseDouble(text);
	}
	
	public String getContents(){
		return text;
	}
	@Override
	public String abbreviatedCellText() {
		return (text + "          ").substring(0, 10);
	}

	@Override
	public String fullCellText() {
		return ("\"" + text.substring(0, length) + "\"");
	}
	*/
	private String userInput;
	
	public RealCell (String contents) {
		userInput = contents;
	}
	
	public String abbreviatedCellText() {
		String newCellContents = userInput;
		if(userInput.length() > 10) {
			return(userInput.substring(0, 10));
		}
		else {
			for(int i = 0; i < 10 - userInput.length(); i++) {
				newCellContents += " ";
			}
			return newCellContents;
		}
	
	}

	
	public String fullCellText() {
		String newCellContents = userInput;
		return newCellContents;
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(userInput);
	}
	
	public String getUserInput() {
		return userInput;
	}
}
