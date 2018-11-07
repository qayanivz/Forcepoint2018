package com.forcepoint.udacity.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class rough {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C://Users//yaniv-z//SeleniumDrivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.udacity.com/");

		driver.findElement(
				By.xpath("//div[@class='normal ng-star-inserted']//a[@title='Sign In'][contains(text(),'Sign In')]"))
				.click();

	}

}
