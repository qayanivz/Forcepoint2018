package com.forcepoint.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

public class MainPage extends BasePage {

	@FindBy(xpath = "//input[@id='query']")
	private WebElement searchField;
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchBtn;
	@FindBy(xpath = "//a[contains(text(),'popular')]")
	private WebElement popularBtn;
	@FindBy(xpath = "//a[contains(text(),'newst')]")
	private WebElement newstBtn;
	@FindBy(xpath = "//a[@class='im-usage']")
	private List<WebElement> usage;

	public MainPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public void searchItem(String text) {
		fillText(searchField, text);
		click(searchBtn);
		
	}

	public void selectFilterByNewst() {
		click(newstBtn);
	}

	public void selectFilterByPopular() {
		click(popularBtn);
	}

	public List<Integer> getUnsotrtedList() {

		List<String> obtainedList = new ArrayList<>();
		List<Integer> lList = new ArrayList<Integer>();
		List<WebElement> elementList = usage;

		//Take out only the digits from list
		for (WebElement el : elementList) {
			obtainedList.add(el.getText().substring(0, 3));
		}

		for (int i = 0; i < obtainedList.size(); i++) {
			obtainedList.set(i, obtainedList.get(i).replaceAll("\\s+", ""));
		}

		for (String str : obtainedList) {
			lList.add(Integer.parseInt(str));

		}
		return lList;

	}

	public List<Integer> getSortedList() {

		ArrayList<Integer> sortedList = new ArrayList<>();

		//duplicate unSorted list
		for (Integer i : getUnsotrtedList()) {
			sortedList.add(i);
		}

		//sort list
		Collections.sort(sortedList, Collections.reverseOrder());

		return sortedList;
	}
	
	public boolean checkIfListIsSorted()
	{

		boolean sorted = getSortedList().equals(getUnsotrtedList());
		return sorted;
		
		
	}

}
