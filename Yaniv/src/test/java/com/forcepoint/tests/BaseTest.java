package com.forcepoint.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.forcepoint.utilities.Utilities;

public class BaseTest {

	public WebDriver driver;

	public static Logger log = Logger.getLogger("errorLogger");

	@BeforeClass
	public WebDriver init() throws IOException, InterruptedException {
		driver = Utilities.getBrowser();
		driver.get(Utilities.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
