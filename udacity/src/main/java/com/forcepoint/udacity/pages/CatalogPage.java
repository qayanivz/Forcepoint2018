package com.forcepoint.udacity.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchField;
	@FindBy(xpath = "//div[@class='result-count']")
	WebElement catalogRresultsText;

	@FindBy(xpath = "//*[@class='page-us page-courses page-courses-all sticky']/ir-content/ir-course-catalog[@class='ng-star-inserted']/ir-experiment[@class='ng-star-inserted']/section[@class='ng-star-inserted']/div[@class='contain']/div[@class='row row-gap-medium']/ir-course-card-catalog/div[@class='course-list']/div[@class='ng-star-inserted']/div[@class='card-wrapper']/div")
	public List<WebElement>courses;

	public CatalogPage(WebDriver driver) {
		super(driver);

		switchTabs();
	}

	public int getNumOfCoursesOnScreen() {
		int i = 0;
		for (WebElement webElement : courses) {
			System.out.println("NOOOOO" + courses.size());
		}
		i = courses.size();
		System.out.println("Number of courses appearing on screen");
		return i;
	}

	public String getNumOfCoursesAfterFiltering() {
		try {
			waitUntilVisibilityElement(catalogRresultsText);
			String result = getText(catalogRresultsText);
			catalogRresultsText.sendKeys(Keys.RETURN);
			System.out.println("Number of courses " + " " + result);
			return result;
		} catch (Exception e) {
		}
		return "Not Element was found";

	}

	public void searchBy(String text) {
		fillText(searchField, text);
	}

	public void check() {

		getText(catalogRresultsText);

	}

}
