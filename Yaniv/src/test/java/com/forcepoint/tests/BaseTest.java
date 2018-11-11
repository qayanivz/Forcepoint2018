package com.forcepoint.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.forcepoint.pages.BasePage;
import com.forcepoint.utilities.ExtentManager;
import com.forcepoint.utilities.Utilities;


public class BaseTest {

	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports report;
	

	@BeforeClass
	public WebDriver init() throws IOException, InterruptedException {

		driver = Utilities.getBrowser();
//		extent.log(Status.INFO, "Browser Started");
		driver.manage().window().maximize();
//		extent.log(Status.INFO, "Browser Maximize");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Utilities.getUrl());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--enable-extensions");
		options.addArguments("--disable-infobars");
		

		return driver;
	}

	@BeforeTest
	public void setUp()
	{
		report = ExtentManager.getInstance();
		test = report.createTest("Yanivvvv num2");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		report.flush();
	}

}
