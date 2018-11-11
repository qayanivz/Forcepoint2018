package com.forcepoint.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.forcepoint.pages.MainPage;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		MainPage mainPage = new MainPage(driver);
		mainPage.searchItem("Selenium");
		mainPage.selectFilterByNewst();
		mainPage.selectFilterByNewst();
		mainPage.getSortedList();
//		Assert.assertTrue(mainPage.getSortedList().equals(mainPage.getUnsotrtedList()));
		assertTrue(mainPage.checkIfListIsSorted());
	}
}
