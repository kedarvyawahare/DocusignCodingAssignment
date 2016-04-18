package concretFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.CommandsInfo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import interfaces.LoadCommnds;

/**
 * This class loads data from XML file
 * @author kedar
 *
 */
public class LoadFromXML implements LoadCommnds{


	private final CommandsInfo commandsInfo;
	
	private static Logger logger = Logger.getLogger("DocusignLog");

	LoadFromXML(final CommandsInfo commandsInfo)
	{
		this.commandsInfo=commandsInfo;

	}

	@Override
	public void load() 
	{
		//open file
		final File fXmlFile = new File("Commands.xml");       
		final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder dBuilder;

		try 
		{
			dBuilder = dbFactory.newDocumentBuilder();

			final Document doc = dBuilder.parse(fXmlFile);       //parsing xml

			final NodeList nList = doc.getElementsByTagName("Command");

			for (int i = 0; i < nList.getLength(); i++) {

				final Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					final Element eElement = (Element) nNode;

					commandsInfo.coldResponse.put(eElement.getElementsByTagName("CommandNumber").item(0).getTextContent(), eElement.getElementsByTagName("ColdResponse").item(0).getTextContent());
					commandsInfo.hotResponse.put(eElement.getElementsByTagName("CommandNumber").item(0).getTextContent(), eElement.getElementsByTagName("HotResponse").item(0).getTextContent());
				}
			}
		}

		catch(FileNotFoundException e)
		{
			logger.info(e.getMessage());
		}

		catch(Exception e)
		{
			
			logger.info(e.getMessage());
		}
	}

	@Override
	public CommandsInfo getCommandsInfo() {
		return commandsInfo;

	}		

}