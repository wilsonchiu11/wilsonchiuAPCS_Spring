/*
package textExcel;


public class FormulaCell extends RealCell{
	private String value = "";
	private Cell[][] wholeSpreadsheet;
	public FormulaCell(String input, Cell[][] array){
		value = input;
		wholeSpreadsheet = array;
		//stores string in parent class
	}
	public double getDoubleValue(){
		double sum = 0.0;
		String noParenthesis = value.substring(2, value.length() - 2);
		String[] changeValue = noParenthesis.split(" ");
		if(changeValue.length == 1){
			return Double.parseDouble(changeValue[0]);
			} else if(changeValue[0].toUpperCase().equals("AVG") || changeValue[0].toUpperCase().equals("SUM")){
				//get the beginning cell and ending cell
				int counter = 0;
				String beginning = changeValue[1].toUpperCase().substring(0, changeValue[1].indexOf('-'));
				String ending = changeValue[1].toUpperCase().substring(changeValue[1].indexOf('-') + 1);
				if(changeValue[0].toUpperCase().equals("AVG")){
					String placeHolder = beginning;
					while(!(placeHolder.equals(ending))){
						SpreadsheetLocation loc = new SpreadsheetLocation(placeHolder);
						//change the column when its the same row
						if(placeHolder.substring(1).equals(ending.substring(1))){
							//changes the letter by one if the rows are the same
							placeHolder = ((char)(placeHolder.charAt(0) + 1)) + beginning.substring(1);
							if(wholeSpreadsheet[loc.getRow()][loc.getCol()] instanceof RealCell){
								//makes sure its a realcell there before adding one to counter
								counter++;
							}
						}else{
							//Move to next row if the row isnt equal
							placeHolder = placeHolder.charAt(0) + "" + (Integer.parseInt(placeHolder.substring(1)) + 1);
							if(wholeSpreadsheet[loc.getRow()][loc.getCol()] instanceof RealCell){
								counter++;
							}
						}
				}
					//average and sum are basically same method just average divides
				return (sum(beginning, beginning, ending)) / (counter+1);
			}else if(changeValue[0].toUpperCase().equals("SUM")){
				return (sum(beginning,beginning,ending));
			}
		} else{
			//checks to see if its a cell or number
			if(changeValue[0].toUpperCase().charAt(0) >= 'A' && changeValue[0].toUpperCase().charAt(0) <='L'){
				SpreadsheetLocation cell = new SpreadsheetLocation(changeValue[0].toUpperCase());
				if(wholeSpreadsheet[cell.getRow()][cell.getCol()] instanceof RealCell){
					sum = ((RealCell)wholeSpreadsheet[cell.getRow()][cell.getCol()]).getDoubleValue();
				}
			}else{
				sum = Double.parseDouble(changeValue[0]);
			}
			for(int i = 1; i < changeValue.length - 1; i += 2 ){
				//checks whether number or a cell
				double num=0.0;
				if(changeValue[i + 1].toUpperCase().charAt(0) >= 'A' && changeValue[i + 1].toUpperCase().charAt(0) <='L'){
						changeValue[i + 1] = changeValue[i + 1].toUpperCase();
						SpreadsheetLocation loc = new SpreadsheetLocation(changeValue[i + 1]);
						if(wholeSpreadsheet[loc.getRow()][loc.getCol()] instanceof RealCell){
							//casts to RealCell to call doubleValue
							num = ((RealCell)wholeSpreadsheet[loc.getRow()][loc.getCol()]).getDoubleValue();
						}
				}else{
					num = Double.parseDouble(changeValue[i + 1]);
				}
				if(changeValue[i].equals("/")){
					sum /=  num;
				}else if(changeValue[i].equals("*")){
					sum *= num;
				}else if(changeValue[i].equals("+")){
					sum += num;
				}else{
					sum -= num;
				}
			}
		}
		return sum;
	}
	public String fullCellText(){
		return value;
	}
	public String abbreviatedCellText() {
		String value = getDoubleValue() + "";
		if (value.length() > 10) {
			return value.substring(0, 10);
		} else {
			for (int i = value.length(); i < 10; i++) {
				value += " ";
			}
			return value;
		}
	}
public double sum(String beginning, String changedCell, String end){	
		SpreadsheetLocation loc = new SpreadsheetLocation(changedCell);
		//base case
		if(changedCell.equals(end)){
			if(wholeSpreadsheet[loc.getRow()][loc.getCol()] instanceof RealCell){
				return ((RealCell)wholeSpreadsheet[loc.getRow()][loc.getCol()]).getDoubleValue();
			}else{
				return 0.0;
			}
		}
		//Case 1: if the columns aren't the same, but the rows are, move horizontally
		if(Character.toUpperCase(beginning.charAt(0)) != Character.toUpperCase(end.charAt(0)) 
				&& Integer.parseInt(beginning.substring(1)) == Integer.parseInt(end.substring(1))){
			changedCell = ((char)(changedCell.charAt(0) + 1)) + beginning.substring(1);
			//if the columns are the same,but the rows are not, move vertically
		}else if(Character.toUpperCase(beginning.charAt(0)) == Character.toUpperCase(end.charAt(0))
				&& Integer.parseInt(beginning.substring(1)) <= Integer.parseInt(end.substring(1))){
			
			changedCell = Character.toString(beginning.charAt(0)) + (Integer.parseInt(changedCell.substring(1)) + 1);
			
			//if the columns and the rows aren't the same, move through all of the cells
		}else{
			//when row is less than the ending row, keep going down
			if(Integer.parseInt(changedCell.substring(1)) < Integer.parseInt(end.substring(1))){
				changedCell = Character.toString(changedCell.charAt(0)) + (Integer.parseInt(changedCell.substring(1)) + 1);
				//if the rows are the same, reset and move to next column
			}else if(Integer.parseInt(changedCell.substring(1)) == Integer.parseInt(end.substring(1))){
				changedCell = ((char)(changedCell.charAt(0) + 1)) + "" + beginning.substring(1);
			}
		}
		//gets the value of the cell and keeps it and returns it
		double first =0.0;
		if(wholeSpreadsheet[loc.getRow()][loc.getCol()] instanceof RealCell){
			 first = ((RealCell)wholeSpreadsheet[loc.getRow()][loc.getCol()]).getDoubleValue();
			return (first + sum(beginning, changedCell, end));
		}else{
			return sum(beginning, changedCell, end);
		}
	}
}

*/
/*
package textExcel;

public class FormulaCell extends RealCell implements Cell {
	private Spreadsheet spreadSheet;
	public FormulaCell(String text, Spreadsheet spreadSheet) {
		this.spreadSheet = spreadSheet;
		setValue(text);
	}

	public String abbreviatedCellText() {
		String value = getDoubleValue() + "";
		if (value.length() > 10) {
			return value.substring(0, 10);
		} else {
			for (int i = value.length(); i < 10; i++) {
				value += " ";
			}
			return value;
		}
	}

	public String fullCellText() {
		return getValue();
	}

	public double sum(String locFirst, String locSecond, String locThird) { //used to find the sum of several cells
		if (locSecond.equals(locThird)) {
			SpreadsheetLocation location = spreadSheet.getLocation(locThird);
			Cell cell = spreadSheet.getSheet()[location.getRow()][location.getCol()];
			if (cell instanceof RealCell) {
				return ((RealCell) cell).getDoubleValue();
			} else {
				return 0.0;
			}
		} else if (locSecond.substring(1).equals(locThird.substring(1))) {
			SpreadsheetLocation loc = spreadSheet.getLocation(locSecond);
			locSecond = ((char) (locSecond.charAt(0) + 1)) + locFirst.substring(1);
			Cell cell = spreadSheet.getSheet()[loc.getRow()][loc.getCol()];
			if (cell instanceof RealCell) {
				return ((RealCell) cell).getDoubleValue() + sum(locFirst, locSecond, locThird);
			} else {
				return sum(locFirst, locSecond, locThird);
			}
		} else {
			SpreadsheetLocation loc = spreadSheet.getLocation(locSecond);
			locSecond = locSecond.substring(0, 1) + (Integer.parseInt(locSecond.substring(1)) + 1);
			Cell cell = spreadSheet.getSheet()[loc.getRow()][loc.getCol()];
			if (cell instanceof RealCell) {
				return ((RealCell) cell).getDoubleValue() + sum(locFirst, locSecond, locThird);
			} else {
				return sum(locFirst, locSecond, locThird);
			}
		}

	}

	public double countCell(String locFirst, String locSecond, String locThird) { //used to get the Value from cells
		SpreadsheetLocation loc = spreadSheet.getLocation(locSecond);
		if (locSecond.equals(locThird)) {
			return 1;
		} else if (locSecond.substring(1).equals(locThird.substring(1))) {
			locSecond = (char) (locSecond.charAt(0) + 1) + locFirst.substring(1);
			if (spreadSheet.getSheet()[loc.getRow()][loc.getCol()] instanceof RealCell) {
				return 1 + countCell(locFirst,locSecond, locThird);
			} else {
				return countCell(locFirst,locSecond, locThird);
			}
		} else {
			locSecond = locSecond.substring(0, 1) + (Integer.parseInt(locSecond.substring(1)) + 1);
			if (spreadSheet.getSheet()[loc.getRow()][loc.getCol()] instanceof RealCell) {
				return 1 + countCell(locFirst,locSecond, locThird);
			} else {
				return countCell(locFirst, locSecond, locThird);
			}

		}
	}

	public double getDoubleValue() { //used to get the value in double form

		String formula = this.getValue().substring(2, getValue().length() - 2);
			String[] equation = formula.trim().split(" ");
			if (equation[0].toLowerCase().equals("sum")) {
				String[] range = equation[1].toUpperCase().split("-");
				return sum(range[0], range[0], range[1]);
			} else if (equation[0].toLowerCase().equals("avg")) {
				String[] range = equation[1].toUpperCase().split("-");
				return sum(range[0], range[0], range[1]) / countCell(range[0], range[0], range[1]);
			} else {
				for (int i = 0; i < equation.length; i++) {
					if (equation[i].toUpperCase().charAt(0) >= 'A' && equation[i].toUpperCase().charAt(0) <= 'L') {
						SpreadsheetLocation loc = spreadSheet.getLocation(equation[i].toUpperCase());
						Cell cell = spreadSheet.getSheet()[loc.getRow()][loc.getCol()];
						if (cell instanceof RealCell) {
							equation[i] = ((RealCell) cell).getDoubleValue() + "";
						} else {
							equation[i] = "";
						}
					}
				}
				double standingValue = Double.parseDouble(equation[0]);
				for (int i = 1; i < equation.length; i++) {
					if (equation[i].equals("*"))
						standingValue *= Double.parseDouble(equation[i + 1]);
					else if (equation[i].equals("/"))
						standingValue /= Double.parseDouble(equation[i + 1]);
					else if (equation[i].equals("+"))
						standingValue += Double.parseDouble(equation[i + 1]);
					else if (equation[i].equals("-"))
						standingValue -= Double.parseDouble(equation[i + 1]);
				}
				return standingValue;
			}
	}

}
*/
/*
package textExcel;

public class FormulaCell extends RealCell{
	
	private String formula;
	private Cell[][] grid;

	public FormulaCell(String formula, Cell[][] spreadsheet) {
		// TODO Auto-generated constructor stub
		this.formula = formula;
		this.grid = spreadsheet;
		setRealCell(formula);
	}

	public double getDoubleValue(){
		String[] formula = getRealCell().split(" ");
		if(formula.length == 3){
			System.out.println(formula[1]);
			return Double.parseDouble(formula[1]);
		}
		if((formula[1].toUpperCase().equals("AVG")) || (formula[1].toUpperCase().equals("SUM"))){
			
			
			if(formula[1].toUpperCase().equals("AVG")){
				double count = 0.0;
				formula[2] = formula[2].toUpperCase();

				int startRow = Integer.parseInt(formula[2].toUpperCase().substring(1, formula[2].indexOf('-')));
				char startCol = (char)(formula[2].charAt(0));
				int endRow = Integer.parseInt(formula[2].toUpperCase().substring(formula[2].indexOf('-') + 2));
				char endCol = (char) (formula[2].charAt(formula[2].indexOf('-') + 1));
				for(char i = startCol; i <= endCol; i++ ){
					if(startCol != endCol){
						for(int j = startRow; j <= 20; j++){
							SpreadsheetLocation cell = new SpreadsheetLocation(i + "" + j);
							if(grid[cell.getRow()][cell.getCol()] instanceof RealCell){
								count++;
							}
					
						}
						startRow = 1;
					}else{
						for(int j = startRow; j <= endRow; j++){
							SpreadsheetLocation cell = new SpreadsheetLocation(i + "" + j);
							if(grid[cell.getRow()][cell.getCol()] instanceof RealCell){
								count++;
							}
							
						}
					}
				}
			
				return (sum(formula[2].toUpperCase().substring(0, formula[2].indexOf('-')), 
						formula[2].toUpperCase().substring(formula[2].indexOf('-') + 1))) / count;
			}else{
				
				return (sum(formula[2].toUpperCase().substring(0, formula[2].indexOf('-')), 
						formula[2].toUpperCase().substring(formula[2].indexOf('-') + 1)));
			}
		}else{
			double storeVal = 0.0;
			for(int i = 1; i < formula.length - 2; i += 2 ){
				double num = 0.0;
				double secondNum = 0.0;
				
				if(formula[i].toUpperCase().charAt(0) >= 'A' && formula[i].toUpperCase().charAt(0) <='L'){
						formula[i] = formula[i].toUpperCase();
		
						SpreadsheetLocation cell = new SpreadsheetLocation(formula[i]);
						if(grid[cell.getRow()][cell.getCol()] instanceof RealCell){
							formula[i] = Double.toString(((RealCell)grid[cell.getRow()][cell.getCol()]).getDoubleValue());
						}else{
							formula[i] = "0.0";
						}

						

				}
				
				if(formula[i+2].toUpperCase().charAt(0) >= 'A' && formula[i+2].toUpperCase().charAt(0) <= 'L'){
						formula[i+2] = formula[i+2].toUpperCase();
						SpreadsheetLocation cell = new SpreadsheetLocation(formula[i + 2]);
					
						if(grid[cell.getRow()][cell.getCol()] instanceof RealCell){
							formula[i+2] = Double.toString(((RealCell)grid[cell.getRow()][cell.getCol()]).getDoubleValue());
							System.out.println("Double value at " + cell.getRow() + "" + cell.getCol() + " " + storeVal);
						}else{
							formula[i+2] = "0.0";
						}
						
				}
				
				num = Double.parseDouble(formula[i]);
				System.out.println(num);
				secondNum = Double.parseDouble(formula[i + 2]);
				System.out.println(secondNum);
				
				if(formula[i + 1].equals("*")){
					storeVal = num * secondNum;
				}else if(formula[i + 1].equals("/")){
					storeVal = num / secondNum;
				}else if(formula[i + 1].equals("+")){
					storeVal = num + secondNum;
				}else{
					storeVal = num - secondNum;
				}
				formula[i+2] = Double.toString(storeVal);
			
			}

			return storeVal;
		}
	}
	
	public double sum(String cell, String end){	
		SpreadsheetLocation loc = new SpreadsheetLocation(cell);
		if(cell.equals(end)){
			System.out.println("exit");
			return ((RealCell)grid[loc.getRow()][loc.getCol()]).getDoubleValue();
		}
		String newCell = "";
		
		if(cell.charAt(0) != end.charAt(0) 
				&& Integer.parseInt(cell.substring(1)) == Integer.parseInt(end.substring(1))){
			
			newCell = ((char)(cell.charAt(0) + 1)) + cell.substring(1);
			System.out.println("new Cell value" + newCell);
		}else if(cell.charAt(0) == end.charAt(0) 
				&& Integer.parseInt(cell.substring(1)) <= Integer.parseInt(end.substring(1))){
			newCell = cell.charAt(0) + "";
			newCell += Integer.parseInt(cell.substring(1)) + 1;
		
		}else if(cell.charAt(0) != end.charAt(0) 
				&& Integer.parseInt(cell.substring(1)) <= Integer.parseInt(end.substring(1))){
			if(Integer.parseInt(cell.substring(1)) < Integer.parseInt(end.substring(1))){
				newCell = cell.charAt(0) + "";
				newCell += Integer.parseInt(cell.substring(1)) + 1;
				System.out.println("diff char and int # 1 " + newCell);
			}else if(Integer.parseInt(cell.substring(1)) == 20){
				newCell = ((char)(cell.charAt(0) + 1)) + "" + 1;
				System.out.println("diff char and int  # 2" + newCell);
			}else{
				newCell = ((char)(cell.charAt(0) + 1)) + "" + cell.substring(1);
				System.out.println("diff char and int  # 3 " + newCell);
				
			}
		}

		double first = 0.0;
		if(grid[loc.getRow()][loc.getCol()] instanceof RealCell ){
			 first = ((RealCell)grid[loc.getRow()][loc.getCol()]).getDoubleValue();
			System.out.println("part of recursion " + first);
			return (first + sum(newCell, end));
		}else{
			return sum(newCell, end);
		}
	}

}	
*/
package textExcel;
public class FormulaCell extends RealCell{
	private String value = "";
	private Cell[][] wholeSpreadsheet;
	public FormulaCell(String input, Cell[][] array){
		value = input;
		wholeSpreadsheet = array;
		//stores string in parent class
	}
	public double getDoubleValue(){
		double sum = 0.0;
		String noParenthesis = value.substring(2, value.length() - 2);
		String[] changeValue = noParenthesis.split(" ");
		if(changeValue.length == 1){
			return Double.parseDouble(changeValue[0]);
			} else if(changeValue[0].toUpperCase().equals("AVG") || changeValue[0].toUpperCase().equals("SUM")){
				//get the beginning cell and ending cell
				int counter = 0;
				String beginning = changeValue[1].toUpperCase().substring(0, changeValue[1].indexOf('-'));
				String ending = changeValue[1].toUpperCase().substring(changeValue[1].indexOf('-') + 1);
				if(changeValue[0].toUpperCase().equals("AVG")){
					String placeHolder = beginning;
					while(!(placeHolder.equals(ending))){
						SpreadsheetLocation loc = new SpreadsheetLocation(placeHolder);
						//change the column when its the same row
						if(placeHolder.substring(1).equals(ending.substring(1))){
							//changes the letter by one if the rows are the same
							placeHolder = ((char)(placeHolder.charAt(0) + 1)) + beginning.substring(1);
							if(wholeSpreadsheet[loc.getRow()][loc.getCol()] instanceof RealCell){
								//makes sure its a realcell there before adding one to counter
								counter++;
							}
						}else{
							//Move to next row if the row isnt equal
							placeHolder = placeHolder.charAt(0) + "" + (Integer.parseInt(placeHolder.substring(1)) + 1);
							if(wholeSpreadsheet[loc.getRow()][loc.getCol()] instanceof RealCell){
								counter++;
							}
						}
				}
					//average and sum are basically same method just average divides
				return (sum(beginning, beginning, ending)) / (counter+1);
			}else if(changeValue[0].toUpperCase().equals("SUM")){
				return (sum(beginning,beginning,ending));
			}
		} else{
			//checks to see if its a cell or number
			if(changeValue[0].toUpperCase().charAt(0) >= 'A' && changeValue[0].toUpperCase().charAt(0) <='L'){
				SpreadsheetLocation cell = new SpreadsheetLocation(changeValue[0].toUpperCase());
				if(wholeSpreadsheet[cell.getRow()][cell.getCol()] instanceof RealCell){
					sum = ((RealCell)wholeSpreadsheet[cell.getRow()][cell.getCol()]).getDoubleValue();
				}
			}else{
				sum = Double.parseDouble(changeValue[0]);
			}
			for(int i = 1; i < changeValue.length - 1; i += 2 ){
				//checks whether number or a cell
				double num=0.0;
				if(changeValue[i + 1].toUpperCase().charAt(0) >= 'A' && changeValue[i + 1].toUpperCase().charAt(0) <='L'){
						changeValue[i + 1] = changeValue[i + 1].toUpperCase();
						SpreadsheetLocation loc = new SpreadsheetLocation(changeValue[i + 1]);
						if(wholeSpreadsheet[loc.getRow()][loc.getCol()] instanceof RealCell){
							//casts to RealCell to call doubleValue
							num = ((RealCell)wholeSpreadsheet[loc.getRow()][loc.getCol()]).getDoubleValue();
						}
				}else{
					num = Double.parseDouble(changeValue[i + 1]);
				}
				if(changeValue[i].equals("/")){
					sum /=  num;
				}else if(changeValue[i].equals("*")){
					sum *= num;
				}else if(changeValue[i].equals("+")){
					sum += num;
				}else{
					sum -= num;
				}
			}
		}
		return sum;
	}
	public String fullCellText(){
		return value;
	}
	public String abbreviatedCellText() {
		String value = getDoubleValue() + "";
		if (value.length() > 10) {
			return value.substring(0, 10);
		} else {
			for (int i = value.length(); i < 10; i++) {
				value += " ";
			}
			return value;
		}
	}
public double sum(String beginning, String changedCell, String end){	
		SpreadsheetLocation loc = new SpreadsheetLocation(changedCell);
		//base case
		if(changedCell.equals(end)){
			if(wholeSpreadsheet[loc.getRow()][loc.getCol()] instanceof RealCell){
				return ((RealCell)wholeSpreadsheet[loc.getRow()][loc.getCol()]).getDoubleValue();
			}else{
				return 0.0;
			}
		}
		//Case 1: if the columns aren't the same, but the rows are, move horizontally
		if(Character.toUpperCase(beginning.charAt(0)) != Character.toUpperCase(end.charAt(0)) 
				&& Integer.parseInt(beginning.substring(1)) == Integer.parseInt(end.substring(1))){
			changedCell = ((char)(changedCell.charAt(0) + 1)) + beginning.substring(1);
			//if the columns are the same,but the rows are not, move vertically
		}else if(Character.toUpperCase(beginning.charAt(0)) == Character.toUpperCase(end.charAt(0))
				&& Integer.parseInt(beginning.substring(1)) <= Integer.parseInt(end.substring(1))){
			
			changedCell = Character.toString(beginning.charAt(0)) + (Integer.parseInt(changedCell.substring(1)) + 1);
			
			//if the columns and the rows aren't the same, move through all of the cells
		}else{
			//when row is less than the ending row, keep going down
			if(Integer.parseInt(changedCell.substring(1)) < Integer.parseInt(end.substring(1))){
				changedCell = Character.toString(changedCell.charAt(0)) + (Integer.parseInt(changedCell.substring(1)) + 1);
				//if the rows are the same, reset and move to next column
			}else if(Integer.parseInt(changedCell.substring(1)) == Integer.parseInt(end.substring(1))){
				changedCell = ((char)(changedCell.charAt(0) + 1)) + "" + beginning.substring(1);
			}
		}
		//gets the value of the cell and keeps it and returns it
		double first =0.0;
		if(wholeSpreadsheet[loc.getRow()][loc.getCol()] instanceof RealCell){
			 first = ((RealCell)wholeSpreadsheet[loc.getRow()][loc.getCol()]).getDoubleValue();
			return (first + sum(beginning, changedCell, end));
		}else{
			return sum(beginning, changedCell, end);
		}
	}
}
	

	


