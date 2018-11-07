package com.forcepoint.udacity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.forcepoint.udacity.utilities.Utilities;


public class LoginPage extends BasePage {


	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	WebElement email;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//div[@class='tabbed-pane--content--2o3OQ']//div//div//div//button[@type='button'][contains(text(),'Sign In')]")
	WebElement signInBtn;
	
	
	
	public void insertMail() {
		Utilities.readProp("email");
		fillText(email, Utilities.readProp("email"));
	}

	public void insertPass() {
		Utilities.readProp("password");
		fillText(password, "forcepoint18");
	}

	public PersonalPage signIn() {
		insertMail();
		insertPass();
		click(signInBtn);
		return new PersonalPage(driver);
		
	}

}
