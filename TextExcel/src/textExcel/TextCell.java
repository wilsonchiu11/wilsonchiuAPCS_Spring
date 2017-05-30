
package textExcel;
import java.util.Arrays;

public class TextCell implements Cell  {

	private String value = "";
	private String abbreviatedText = "";
	//sets a value
	public TextCell(String strcontents){
		this.value = strcontents;
	}
	public String abbreviatedCellText() {
		
				String newString = "";
				
				//takes out the quotes
				if(value.contains("\"")){
					newString = value.substring(1, value.length() - 1);
				}
				//truncates to length of 10
				if(newString.length() > 10){
					newString = newString.substring(0, 10);
					return newString;
				}else{
					//fills in spaces to make the length equal to 10
					while(newString.length() != 10){
						newString += " ";

					}
					return newString;
				}
	}
	//returns string with proper spacing
	public String fullCellText() {
		return value;
	}
	public void setText(String strcontents){
		this.value = strcontents;
	}

}
