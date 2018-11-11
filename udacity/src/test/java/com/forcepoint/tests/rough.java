package com.forcepoint.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class rough {

	public static void main(String[] args) throws ParseException {

		System.setProperty("webdriver.gecko.driver", "C://Users//yaniv-z//SeleniumDrivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://mvnrepository.com/");

		driver.findElement(By.xpath("//input[@id='query']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		WebElement foundItems = driver.findElement(By.cssSelector("#maincontent > h2"));
		String text = foundItems.getAttribute("innerText");
		System.out.println(foundItems.getAttribute("innerText"));

		driver.findElement(By.xpath("//a[contains(text(),'newest')]")).click();

		List<WebElement> elementList = driver.findElements(By.xpath("//*[contains(text(), 'Last Release on')]"));

		ArrayList<String> dateList = new ArrayList<String>();
		ArrayList<String> sortDateList = new ArrayList<String>();

		for (WebElement el : elementList) {

			dateList.add(el.getAttribute("innerText"));
		}
		getDateOnly(dateList);
		getDateFormat(dateList);
		System.out.println(dateList);
		
		System.out.println();

		driver.close();
	}

	public static class MyObject implements Comparable<MyObject> {

		private Date dateTime;

		public Date getDateTime() {
			return dateTime;
		}

		public void setDateTime(Date datetime) {
			this.dateTime = datetime;
		}

		public int compareTo(MyObject o) {
			return getDateTime().compareTo(o.getDateTime());
		}
	}

	public static ArrayList<String> getDateFormat(ArrayList<String> list) throws ParseException {
		Locale loc = new Locale("en", "US");
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
		Date date = null;
		for (int i = 0; i < list.size(); i++) {
			date = dateFormat.parse(list.get(i));
			list.set(i, date.toString());
		}
		return list;
	}

	public static ArrayList<String> getDateOnly(ArrayList<String> list) {

		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);

			list.set(i, s.substring(16, s.length()));

		}
		return list;
	}

}
