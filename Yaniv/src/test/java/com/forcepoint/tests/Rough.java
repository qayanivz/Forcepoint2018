package com.forcepoint.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Rough {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zoie\\Work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mvnrepository.com");
		// driver.manage().window().maximize();

		WebElement search = driver.findElement(By.id("query"));
		search.sendKeys("Selenium");

		driver.findElement(By.xpath("//input[@value='Search']")).click();

		List<WebElement> elementList = driver.findElements(By.xpath("//a[@class='im-usage']"));
		List<String> obtainedList = new ArrayList<>();
		List<Integer> lList = new ArrayList<Integer>();

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
		
		for (int i = 0; i < obtainedList.size(); i++) {
			System.out.println(obtainedList.get(i));
		}
	
		System.out.println("****************");
	
		for (int i = 0; i < sortedList.size(); i++) {
			System.out.println(sortedList.get(i));
		}
		
		// ArrayList<Integer> listIntegers = new ArrayList<>();
		//
		// for(String numeric : obtainedList){
		// listIntegers.add(Integer.parseInt(numeric));
		//
		// }

		 Assert.assertTrue(sortedList.equals(obtainedList));

		driver.quit();
	}
}
