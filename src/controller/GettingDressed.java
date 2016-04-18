package controller;

import interfaces.LoadCommnds;

import java.util.Scanner;

import ruleEngine.ColdTemperatureRuleEngine;
import ruleEngine.HotTemparatureRuleEngine;
import concretFactory.LoadFactory;
import model.CommandsInfo;

/**
 * This class contains main function , loads input and check for the outputs
 * @author kedar
 *
 */
public class GettingDressed {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Plase Enter :");
		System.out.println("1 => Read from Input class");
		System.out.println("2 => Read from XML file");

		int inputFileFormatNumber;

		while(true)
		{
			String inputFileFormat = sc.nextLine();

			inputFileFormatNumber = Integer.parseInt(inputFileFormat);

			if(inputFileFormatNumber != 1 &&  inputFileFormatNumber != 2)

			{
				System.out.println("Input is not valid. Please try again.");
			}
			
			else 
				break;
		}

		String fileFormat ="";
		
		//converting number to fileFormat String

		if(inputFileFormatNumber == 1)
		{
			fileFormat ="InputClass";
		}

		else
		{
			fileFormat="XML";
		}

		System.out.println("Plase Enter command input :");
		
		String input = sc.nextLine();

		GettingDressed gettingDressed = new GettingDressed();
		
		//loading data for CommandInfo
		CommandsInfo commandsInfo= gettingDressed.loadData(fileFormat);
		
		//checking for output for all the commands
		System.out.println(gettingDressed.gettingReady(input , commandsInfo));

	}


	public CommandsInfo loadData(String fileFormat)

	{
		// object for CommandsInfo
		final CommandsInfo commandsInfo = new CommandsInfo();

		final LoadFactory loadFactory =new LoadFactory();

		//crating factory for concrete class
		final LoadCommnds loadCommnds= loadFactory.getCommands(fileFormat, commandsInfo);

        //loading data
		loadCommnds.load();

		return commandsInfo;

	}


	public String  gettingReady(String input, CommandsInfo commandsInfo) {
		
        // extracting temperature from Input
		final String temperature = input.substring(0, input.indexOf(" "));

		// extracting commands from Input
		final String commands[] = input.substring(input.indexOf(" ") + 1).split(",");

        // removing spaces
		for (int i = 0; i < commands.length; i++) 
		{
			commands[i]= commands[i].replaceAll(" ", "");
		}

		// function for COLD temperature
		if (temperature.equals("COLD")) 
		{

			final ColdTemperatureRuleEngine coldTemperatureRuleEngine= new ColdTemperatureRuleEngine(commandsInfo);

			final String rules= coldTemperatureRuleEngine.commonRules(commands);

			if(rules.equals("fail"))

			{
				return rules;
			}

			else

			{
				return  coldTemperatureRuleEngine.checkRules(commands);

			}
		}

		
		// function for hot temperature
		else

		{
			HotTemparatureRuleEngine hotTemparatureRuleEngine= new HotTemparatureRuleEngine(commandsInfo);

			String rules= hotTemparatureRuleEngine.commonRules(commands);

			if(rules.equals("fail"))

			{
				return rules;
			}

			else

			{
				return hotTemparatureRuleEngine.checkRules(commands);

			}
		}

	}

}
