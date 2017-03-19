package textExcel;

public class TextCell implements Cell {
	private String text;
	private int length;
	
	public TextCell(String textCell){
		text = textCell;
		length = textCell.length();
	}
	
	@Override
	public String abbreviatedCellText() {
		return (text + "          ").substring(0, 10);
	}
	
	@Override
	public String fullCellText() {
		return ("\"" + text.substring(0, length) + "\"");
	}

}
	
