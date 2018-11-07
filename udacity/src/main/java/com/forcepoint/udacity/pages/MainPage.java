package com.forcepoint.udacity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{

	
	@FindBy(xpath = "//div[@class='normal ng-star-inserted']//a[@title='Sign In'][contains(text(),'Sign In')]")
	public WebElement signInBtn;
	
	private final String siteUrl = "https://www.udacity.com/";
	private final String expectedUrl = "https://www.udacity.com/";
	
	private final String homePageError = "home page is not displayed";
	
	public MainPage(WebDriver driver) {
		super(driver);
		
	}
	public Boolean urlContains(String url) {
		try {
			return wait.until(ExpectedConditions.urlContains(url));
		}
		catch (Exception ex) {
			log.fatal(ex.getMessage());
			return false;
		}
	}	
	
	public LoginPage getLoginPage() {
		click(signInBtn);
		return new LoginPage(driver);
	}
	

}
