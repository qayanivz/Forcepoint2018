package com.forcepoint.udacity.tests;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.forcepoint.udacity.utilities.Utilities;

public class BaseTest {

	WebDriver driver;

	@BeforeClass
	public WebDriver init() throws IOException, InterruptedException {

		driver = Utilities.getBrowser();
		driver.get(Utilities.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		return driver;
	}

	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();

	}
}
