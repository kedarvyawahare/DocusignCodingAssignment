package concretFactory;

import model.CommandsInfo;
import interfaces.LoadCommnds;

/**
 * This class is for creating objects for concrete class based on given information.
 * @author kedar
 *
 */
public class LoadFactory  {
	
	/**
	 * @param name - type of concrete class to generate
	 * @param commandsInfo  - object of CommandsInfo class
	 * @return  objects for concrete class based on given information
	 */
	public LoadCommnds getCommands(final String name ,final CommandsInfo commandsInfo)
	{
		if(name.equals("XML"))
			
		{
			return new LoadFromXML(commandsInfo);
		}
		
		else if(name.equals("InputClass"))
			
		{
			return new LoadFromMemory(commandsInfo);
		}
		
		return null;
		
	}
	
	

}
