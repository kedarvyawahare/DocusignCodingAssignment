package ruleEngine;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import model.CommandsInfo;

public class HotTemparatureRuleEngine extends RuleEngine{

	private static Logger logger = Logger.getLogger("DocusignLog");
	//default Constructor
	public HotTemparatureRuleEngine(final CommandsInfo commandsInfo) {
		super(commandsInfo);
	}

	/* 
	 * method to check Hot temperature specific rules
	 */
	@Override
	public String checkRules(final String[] commands) 
	{

		
			String output = "";

			//hashSet to store previousCommands
			final Set<Integer> previousCommands = new HashSet<Integer>();
			try
			{
			//iterating over commands array
			for (int i = 0; i < commands.length; i++) {


				if(!commandsInfo.hotResponse.containsKey(commands[i]))
				{
					return "fail";
				}

				//check for duplicates commands
				if (previousCommands.contains(Integer.parseInt(commands[i]))) {
					output += "fail";
					return output;
				}

				//checking for least number of clothes required to Leave house
				if (Integer.parseInt(commands[i]) == 7
						&& previousCommands.size() != 5) {
					output += "fail";
					return output;
				}

				previousCommands.add(Integer.parseInt(commands[i]));


				// checking for fail response


				if (commandsInfo.hotResponse.get(commands[i]).equals(
						"fail"))
				{
					output += "fail";
					return output;
				}


				//check for Pants must be put on before shoes
				if (Integer.parseInt(commands[i]) == 1
						&& !previousCommands.contains(6)) {
					output += "fail";
					return output;
				}

				//check for shirt must be put on before the headwear or jacket
				if ((Integer.parseInt(commands[i]) == 2 || Integer.parseInt(commands[i]) == 5)
						&& (!previousCommands.contains(4))) {
					output += "fail";
					return output;
				}


				output += commandsInfo.hotResponse.get(commands[i]) + ", ";


			}

			//checking condition for leave house
			if (Integer.parseInt(commands[commands.length - 1]) != 7) {
				output += "fail";
				return output;
			}

			//removing last ,
			if (previousCommands.size() == 6)
				return output.substring(0, output.length() - 2);

			else {
				output += "fail";
				return output;
			}

		}

		catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		return output;
	}



}
