package com.forcepoint.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rough2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\GitHub_Forcepoint\\Forcepoint2018\\Yaniv\\src\\test\\resources\\executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mvnrepository.com");
		// driver.manage().window().maximize();

		WebElement search = driver.findElement(By.id("query"));
		
		System.out.println(search.getAttribute("webElement"));
		driver.close();
		
	}

}
