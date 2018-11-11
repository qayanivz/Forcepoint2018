package com.forcepoint.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.forcepoint.utilities.Utilities;

public class BasePage {

	public WebDriver driver;
	WebDriverWait wait;
	Utilities utilities = new Utilities();
	public static String browser;
	public static ExtentTest test;

	String textColor = "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');";

	public BasePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void click(WebElement el) {
		try {
			visibilityOfElement(el);
			utilities.colorElement(el, textColor);
			el.click();
			test.log(Status.INFO, "Click on " + el);
		} catch (Exception e) {
		}
	}

	public void fillText(WebElement el, String text) {
		try {
			visibilityOfElement(el);
			el.clear();
			utilities.colorElement(el, textColor);
			el.sendKeys(text);
			sleep(1000);
			test.log(Status.INFO, "Insert the text: " + text + " on " + el);
		} catch (Exception e) {
		}

	}

	
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getText(WebElement el) {
		try {
			el.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return el.getText();
	}

	public String getValue(WebElement el) {

		visibilityOfElement(el);
		return el.getAttribute("value");
	}

	public void clear(WebElement el) {
		el.clear();
		sleep(2000);
	}

	public String getMsg(WebElement el) {
		try {
			visibilityOfElement(el);
			WebElement error = el;
			return error.getText();
		} catch (Exception err) {
			return "No Error Found";
		}
	}

	public void selectFromList(WebElement el, String value) {
		Select select1 = new Select(el);
		utilities.colorElement(el, textColor);
		select1.selectByVisibleText(value);
		sleep(2000);
	}

	public WebElement visibilityOfElement(WebElement el) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(el));
		return element;
	}

	public String currentWindowHandle() {
		return driver.getWindowHandle();
	}

	public String newWindowHandle() {
		Set<String> windowsList = driver.getWindowHandles();
		String newWindow = "";
		for (String s : windowsList) {
			newWindow = s;
		}
		return newWindow;
	}
}
