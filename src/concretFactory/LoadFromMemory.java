package concretFactory;

import java.util.HashMap;

import interfaces.LoadCommnds;
import model.CommandsInfo;

/**
 * @author kedar
 * This class loads data regarding commands 
 *
 */
public class LoadFromMemory implements LoadCommnds{

	final CommandsInfo commandsInfo;

	LoadFromMemory(CommandsInfo commandsInfo)
	{
		this.commandsInfo=commandsInfo;

	}
	
	@Override
	public void load() {
		
		//hashMap for hotResponse
		final HashMap<String, String> hotResponse = new HashMap<String, String>();
		 
		//hashMap for coldResponse
		final HashMap<String, String> coldResponse = new HashMap<String, String>();

		hotResponse.put("1", "sandals");
		hotResponse.put("2", "sun visor");
		hotResponse.put("3", "fail");
		hotResponse.put("4", "t-shirt");
		hotResponse.put("5", "fail");
		hotResponse.put("6", "shorts");
		hotResponse.put("7", "leaving house");
		hotResponse.put("8", "Removing PJs");

		coldResponse.put("1", "boots");
		coldResponse.put("2", "hat");
		coldResponse.put("3", "socks");
		coldResponse.put("4", "shirt");
		coldResponse.put("5", "jacket");
		coldResponse.put("6", "pants");
		coldResponse.put("7", "leaving house");
		coldResponse.put("8", "Removing PJs");

		commandsInfo.hotResponse=hotResponse;
		commandsInfo.coldResponse=coldResponse;



	}
	@Override
	public CommandsInfo getCommandsInfo() {
		return commandsInfo;
	}


}
