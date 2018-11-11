package com.forcepoint.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;



public class Utilities {

	static WebDriver driver;
	public static String screenshotName;
	public static String screenshotPath;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}
	
	public static String readProp(String key) {
		Properties prop = new Properties();
		String value = "";
		try {
			InputStream input = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			// load a properties file
			prop.load(input);

			// get the property value
			value = prop.getProperty(key);
		} catch (Exception err) {
		}
		return value;
	}

	public static WebDriver getBrowser() {
		String browserName = readProp("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					("user.dir") + "\\src\\test\\resources\\executables\\MicrosoftWebDriver");
			driver = new InternetExplorerDriver();
			
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static String getUrl() {
		return readProp("url");
	}

	public void colorElement(WebElement element, String elementstyle) {
		String original_style = element.getAttribute("style");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(elementstyle, element);

		// Change the style after few miliseconds
		js.executeScript(
				"var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', 'background: transparent;');},400);",
				element);

		// Change the style after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ original_style + "');},1000);", element);

	}

}
