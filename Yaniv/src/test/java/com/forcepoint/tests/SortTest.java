package com.forcepoint.tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.forcepoint.pages.MainPage;

public class SortTest extends BaseTest{
	@Test
	public void popularResultsIsSortedTest() {
		
		test = report.createTest("popularResultsIsSortedTest");
		MainPage mainPage = new MainPage(driver, test);
		mainPage.searchItem("Selenium");
		mainPage.selectFilterByPopular();
		assertTrue(mainPage.checkIfListIsSorted());
	}
}
