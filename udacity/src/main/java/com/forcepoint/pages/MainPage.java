package com.forcepoint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

	@FindBy(xpath = "//input[@id='query']")
	WebElement searchTextField;
	@FindBy(xpath = "//input[@value='Search']")
	WebElement searchBtn;
	
	private final String siteUrl = "https://mvnrepository.com/";
	private final String expectedUrl = "https://mvnrepository.com/";

	private final String homePageError = "home page is not displayed";

	public MainPage(WebDriver driver) {
		super(driver);

	}

	public Boolean urlContains(String url) {
		try {
			return wait.until(ExpectedConditions.urlContains(url));
		} catch (Exception ex) {
			log.fatal(ex.getMessage());
			return false;
		}
	}

	public void searchRepo(String text) {

		fillText(searchTextField, text);
		click(searchBtn);
	}

}
