package com.forcepoint.pages;

import java.util.ArrayList;
import java.util.Set;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.forcepoint.utilities.ExtentManager;
import com.forcepoint.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;
	Utilities util = new Utilities();
	String textColor = "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');";
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void click(WebElement el) {
		try {
			wait.until(ExpectedConditions.visibilityOf(el));
			util.colorElement(el, textColor);
			el.click();

		} catch (Exception e) {
			System.out.println("Can't click on element" + " " + el.getText());
		}
//		log.debug("Clicking on an Element : "+el);
//		test.log(LogStatus.INFO, "Clicking on : " + el);
	}

	public void fillText(WebElement el, String value) {
		try {
//			wait.until(ExpectedConditions.visibilityOf(el));
			el.clear();
			util.colorElement(el, textColor);
			el.sendKeys(value);
		} catch (Exception e) {

		}
	}

	public void select(WebElement dropdown, String value) {
		wait.until(ExpectedConditions.visibilityOf(dropdown));
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}

	public void switchTabs() {

		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int cout = allWindows.size();

		for (String child : allWindows) {

			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}
	}

	public String getText(WebElement el) {
		return el.getText();
	}

	public String getValue(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
		return el.getAttribute("value");
	}

	public void clear(WebElement el) {
		el.clear();
	}

	public String getMsg(WebElement el) {
		try {
			WebElement massage = el;
			return massage.getText();
		} catch (Exception err) {
			return "Can't get element text";
		}
	}

	public void selectFromList(WebElement el, String value) {
		try {
			Select select1 = new Select(el);
			util.colorElement(el, textColor);
			select1.selectByVisibleText(value);
		} catch (Exception e) {
		}

	}

	public void iFrameHandle(WebElement iframe) {
		try {
			driver.switchTo().frame(iframe);
		} catch (Exception e) {
			System.out.println("No iFrame was found...");
		}

	}

	public boolean isElementPresent(By by) throws InterruptedException {
		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		} finally {
			driver.wait();
		}
	}

	public boolean isElementsPresent(By by) throws InterruptedException {
		try {
			driver.findElements(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		} finally {
			driver.wait();
		}
	}

	public boolean isElementClickable(WebElement el) {
		try {
			String url = el.getAttribute("href");
			if (url != "" || url != null) {
				click(el);
				return true;

			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("");
		}
		return false;
	}

	public void waitUntilVisibilityElement(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));

	}

	public void compereToUrl()
	{
		
	}
	
}
