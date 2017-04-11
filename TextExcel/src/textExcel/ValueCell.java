package textExcel;

public class ValueCell extends RealCell {
	
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
