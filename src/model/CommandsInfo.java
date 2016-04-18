package model;
import java.util.HashMap;


/**
 * Model for CommandsInfo
 * containing getter and setters
 * @author kedar
 *
 */
public class CommandsInfo {
	
	// hasMap for hotResponse and coldResponse
	public  HashMap<String, String> hotResponse = new HashMap<String, String>();
	public  HashMap<String, String> coldResponse = new HashMap<String, String>();
	
	
	public HashMap<String, String> getHotResponse() {
		return hotResponse;
	}
	public void setHotResponse(HashMap<String, String> hotResponse) {
		this.hotResponse = hotResponse;
	}
	public HashMap<String, String> getColdResponse() {
		return coldResponse;
	}
	public void setColdResponse(HashMap<String, String> coldResponse) {
		this.coldResponse = coldResponse;
	}


}
