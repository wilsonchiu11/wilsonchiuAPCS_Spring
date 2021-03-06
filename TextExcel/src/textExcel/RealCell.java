//Wilson Chiu APCS2
package textExcel;
public abstract class RealCell implements Cell {
	private String userInput = "";
	private int counter = 0;
	
	public abstract double getDoubleValue();
	public String abbreviatedCellText() {
		if(userInput.length() < 10){
			//check if it is a percent
			if(userInput.contains("%")){
				//creates placeholder
				String placeholder = userInput.substring(0, userInput.indexOf(".")) + "%";
				//fill up to 10 spaces
				return addSpaces(placeholder);
			}
			//checks if it is a whole number
			if(!userInput.contains(".") && !userInput.contains("(")){
				String anotherPlaceholder = userInput + ".0";
				return addSpaces(anotherPlaceholder);
			}
			//the one exception to having 2 zeros next to each other, treats it differently and just adds spaces
			if(userInput.equals("0.0")){
				userInput = addSpaces(userInput);
				return userInput;
			}
			//reverse for loop to check for two or more zeros together from the end
			if(!userInput.contains("(")){
				for(int i = userInput.length()-1; i >=0; i--){
					//ends the loop if its not a zero
					if(userInput.charAt(i) != '0'){
						i = 0;
					}
					if(userInput.charAt(i) == '0'){
						counter ++;
						//checks for 2 zeros in a row
	
						if(counter >= 2){
							userInput = userInput.substring(0, i);
						}
					}

				}
			}
			//adds a .0 if nothing after decimal
			if(userInput.charAt(userInput.length()-1) == '.'){
				userInput = userInput + "0";
			}
			userInput = addSpaces(userInput);
			//truncate to length of 10
		} else if(userInput.length() > 10){
			return userInput.substring(0, 10);
		}
		return userInput;
	}

	public String getRealCell(){
		return userInput;
	}
	public void setRealCell(String value){
		userInput = value;
	}
	public String fullCellText() {
		RealCell realcell;
		if(userInput.equals("0")){
			return "0";
		}
		//checks for type of cell
		if(userInput.contains("%")){
			realcell = new PercentCell(userInput);
		}else{
			realcell = new ValueCell(userInput);
		}
		//switches double to string to get rid of extra 0s at the end
		String removeZeros = realcell.getDoubleValue() + "";
		//number is positive and is longer than one place value
		if((removeZeros.substring(removeZeros.indexOf(".")).equalsIgnoreCase(".0")) && ((realcell.getDoubleValue() > 0) && (removeZeros.length() > 3))){
			return removeZeros.substring(0, removeZeros.indexOf("."));
		}
		return realcell.getDoubleValue() + "";

}
	public String addSpaces(String placeholder){
		//formats abbreviatedCellText to length 10 if its too short
		while(placeholder.length() < 10){
			placeholder += " ";
		}
		return placeholder;
	}
	
}


