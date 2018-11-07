package com.forcepoint.udacity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalPage extends BasePage{

	public PersonalPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Catalog')]")
	WebElement catalogBtn;
	

	public CatalogPage goToCatalogPage()
	{
		click(catalogBtn);
		return new CatalogPage(driver);	
		
	}
	
	
}
