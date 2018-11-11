package com.forcepoint.tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.forcepoint.pages.MainPage;



public class SortTest extends BaseTest{
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void popularResultsIsSortTest() {
		
		MainPage mainPage = new MainPage(driver, test);
		mainPage.searchItem("Selenium");
		mainPage.selectFilterByPopular();
		assertTrue(mainPage.checkIfListIsSorted());
	}
}
