package ruleEngine;

import model.CommandsInfo;

/**
 * This is abstaract class containing methods to check common Rules and abstract method for specific rules
 * @author kedar
 *
 */
public abstract class RuleEngine {
	
	final CommandsInfo commandsInfo;
	
	RuleEngine(final CommandsInfo commands)
	
	{
		this.commandsInfo=commands;
	}
	
	public abstract String checkRules(final String commandsInfo[]);
   
	
	/**
	 * @param commands - input commands
	 * @return fail or ""
	 */
	public String commonRules(final String commands[])
	
	{
		//checking that command should start from Removing PJs
		if (Integer.parseInt(commands[0]) != 8)
			return "fail";
		
		return "";
	}
}
