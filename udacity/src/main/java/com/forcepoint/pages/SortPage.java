package com.forcepoint.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.forcepoint.utilities.SortManager;

public class SortPage extends BasePage {

	@FindBy(xpath = "//u[contains(text(),'relevance')]")
	WebElement sortByRelevanceBtn;
	@FindBy(xpath = "//a[contains(text(),'popular')]")
	WebElement sortByPopularBtn;
	@FindBy(xpath = "//a[contains(text(),'newest')]")
	WebElement sortNewestBtn;

	@FindBy(xpath = "//*[contains(text(), 'Last Release on')]")
	public List<WebElement>releaseDate;
	
	
	
	public SortPage(WebDriver driver) {
		super(driver);
	}

	public SortManager searchBy(SortManager sort)
	{
		
		return sort;
		
	}
	
	public void sortByNewest()
	{
		click(sortNewestBtn);
		

		
		
		
		
	}

}
