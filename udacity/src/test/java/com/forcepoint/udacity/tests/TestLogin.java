package com.forcepoint.udacity.tests;

import org.testng.annotations.Test;

import com.forcepoint.udacity.pages.BasePage;
import com.forcepoint.udacity.pages.CatalogPage;
import com.forcepoint.udacity.pages.LoginPage;
import com.forcepoint.udacity.pages.MainPage;
import com.forcepoint.udacity.pages.PersonalPage;

import junit.framework.Assert;

public class TestLogin extends BaseTest {

	@Test
	public void Test() throws InterruptedException {

		MainPage mainPage = new MainPage(driver);
		LoginPage loginPage = mainPage.getLoginPage();
		PersonalPage personalPage = loginPage.signIn();
		CatalogPage catalogPage = personalPage.goToCatalogPage();
//		catalogPage.getNumOfCoursesOnScreen();
		catalogPage.searchBy("mobile");
		catalogPage.getNumOfCoursesOnScreen();
		catalogPage.getNumOfCoursesAfterFiltering();

		String expected;
		String actual;
		Assert.assertEquals("", "");
		

	}

}
