package com.forcepoint.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	public MainPage(WebDriver driver) {
		super(driver);
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

		for (WebElement el : elementList) {
			obtainedList.add(el.getText().substring(0, 3));
		}

		for (int i = 0; i < obtainedList.size(); i++) {
			// obtainedList.get(i).replaceAll(" ", "");
			obtainedList.set(i, obtainedList.get(i).replaceAll("\\s+", ""));
		}

		for (String str : obtainedList) {
			lList.add(Integer.parseInt(str));

		}
		return lList;

	}

	public List<Integer> getSortedList() {

		List<String> obtainedList = new ArrayList<>();
		List<Integer> lList = new ArrayList<Integer>();
		List<WebElement> elementList = usage;
		for (WebElement el : elementList) {
			obtainedList.add(el.getText().substring(0, 3));

		}

		for (int i = 0; i < obtainedList.size(); i++) {
			// obtainedList.get(i).replaceAll(" ", "");
			obtainedList.set(i, obtainedList.get(i).replaceAll("\\s+", ""));
		}

		for (String str : obtainedList) {
			lList.add(Integer.parseInt(str));

		}

		ArrayList<Integer> sortedList = new ArrayList<>();

		for (Integer i : lList) {
			sortedList.add(i);
		}

		Collections.sort(sortedList, Collections.reverseOrder());

		return sortedList;
	}
	
	public boolean checkIfListIsSorted()
	{
		selectFilterByNewst();
		if (getSortedList() == getUnsotrtedList() ) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	}

}
