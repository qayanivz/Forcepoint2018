package com.forcepoint.tests;

import org.testng.annotations.Test;

import com.forcepoint.pages.BasePage;
import com.forcepoint.pages.SortPage;
import com.forcepoint.pages.LoginPage;
import com.forcepoint.pages.MainPage;
import com.forcepoint.pages.PersonalPage;

import junit.framework.Assert;

public class TestSearchBy extends BaseTest {

	@Test
	public void Test() throws InterruptedException {

		MainPage mainPage = new MainPage(driver);
		mainPage.searchRepo("selenium");
		

		Assert.assertEquals("", "");
		

	}

}
