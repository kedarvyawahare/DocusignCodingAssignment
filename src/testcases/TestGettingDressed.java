package testcases;

import static org.junit.Assert.*;
import model.CommandsInfo;

import org.junit.Test;

import controller.GettingDressed;

public class TestGettingDressed {

	GettingDressed gettingDressed = new GettingDressed();
	
	
	/**
	 * This class return CommandsInfo object
	 * @param str 
	 * @return CommandsInfo
	 */
	private  CommandsInfo getComandInfo(String str)
	
	{
		return  gettingDressed.loadData(str);
	}


	@Test
	//test case for HOT temperature and pass with InputClass read
	public final void testGettingReadyForHotTemperature() {

		CommandsInfo commandsInfo= getComandInfo("InputClass");

		assertEquals("Removing PJs, shorts, t-shirt, sun visor, sandals, leaving house", gettingDressed.gettingReady("HOT 8, 6, 4, 2, 1, 7" , commandsInfo));
	}
	
	@Test
	//test case for HOT temperature and pass with XML read
	public final void loadFromXML() {

		CommandsInfo commandsInfo= getComandInfo("XML");
		
		System.out.println(gettingDressed.gettingReady("HOT 8, 6, 4, 2, 1, 7" , commandsInfo));
	

		assertEquals("Removing PJs, shorts, t-shirt, sun visor, sandals, leaving house", gettingDressed.gettingReady("HOT 8, 6, 4, 2, 1, 7" , commandsInfo));
	}

	
	@Test

	//test case for HOT temperature and fail
	public final void failToGetReadyForHotTemperature() {

		CommandsInfo commandsInfo= gettingDressed.loadData("InputClass");

		assertEquals("Removing PJs, shorts, fail", gettingDressed.gettingReady("HOT 8, 6, 6" , commandsInfo));
	}




	@Test

	//test case for COLD temperature and pass
	public final void testGettingReadyForColdTemerature() {

		CommandsInfo commandsInfo= gettingDressed.loadData("InputClass");

		assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house", gettingDressed.gettingReady("COLD 8, 6, 3, 4, 2, 5, 1, 7" , commandsInfo));
	}
	
	
	@Test

	//test case for COLD temperature and pass
	public final void testGettingReadyForColdTemeratureFromXMLLoad() {

		CommandsInfo commandsInfo= gettingDressed.loadData("XML");

		assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house", gettingDressed.gettingReady("COLD 8, 6, 3, 4, 2, 5, 1, 7" , commandsInfo));
	}
	
	
	@Test

	//test case for Hot temperature and having socks
	public final void testCaseForHotTemeratureWithSocks() {

		CommandsInfo commandsInfo= gettingDressed.loadData("InputClass");

		assertEquals("Removing PJs, shorts, fail", gettingDressed.gettingReady("HOT 8, 6, 3" , commandsInfo));
	}
	
	
	@Test

	//test case for fail to get ready COLD temperature 
	public final void failToGetReadyReadyForColdTemerature() {

		CommandsInfo commandsInfo= gettingDressed.loadData("InputClass");

		assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, fail", gettingDressed.gettingReady("COLD 8, 6, 3, 4, 2, 5, 7" , commandsInfo));
	}
	
	
	
	@Test

	//test case for COLD temperature and without Take off pajamas
	public final void testGettingReadyForColdTemeratureWithoutTakeOffPajamas() {

		CommandsInfo commandsInfo= gettingDressed.loadData("InputClass");

		assertEquals("fail", gettingDressed.gettingReady("COLD 6" , commandsInfo));
	}
	
	@Test

	//test case for Hot temperature and without Take off pajamas
	public final void testGettingReadyForHotTemeratureWithoutTakeOffPajamas() {

		CommandsInfo commandsInfo= gettingDressed.loadData("InputClass");

		assertEquals("fail", gettingDressed.gettingReady("HOT 6" , commandsInfo));
	}
	
	
	@Test

	//test case for Hot temperature and without enough clothes
	public final void testGettingReadyForHotTemeratureWithoutEnoughClothes() {

		CommandsInfo commandsInfo= gettingDressed.loadData("InputClass");

		assertEquals("Removing PJs, shorts, t-shirt, sun visor, fail", gettingDressed.gettingReady("HOT 8, 6, 4, 2, 7" , commandsInfo));
	}


}
