package com.expedia.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
	
	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText="View All Campgrounds") 
	private WebElement viewAllCampgroundsLink;
	
	@FindBy(linkText="Login") 
	private WebElement loginLink;
	
	@FindBy(name="username") 
	private WebElement usernameField;
	
	@FindBy(name="password") 
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@class='btn btn-primary']") 
	private WebElement loginBtn;
	
	
	public void loginValidUser(String username, String password) {
		waitForElementToAppear(viewAllCampgroundsLink);
		viewAllCampgroundsLink.click();
		waitForElementToAppear(loginLink);
		loginLink.click();
		waitForElementToAppear(usernameField);
		usernameField.sendKeys(username);
		waitForElementToAppear(passwordField);
		passwordField.sendKeys(password);
		waitForElementToAppear(loginBtn);
		loginBtn.click();
	}
	
	public void loginInvalidUser(String username, String password) {
		waitForElementToAppear(viewAllCampgroundsLink);
		viewAllCampgroundsLink.click();
		waitForElementToAppear(loginLink);
		loginLink.click();
		waitForElementToAppear(usernameField);
		usernameField.sendKeys(username);
		waitForElementToAppear(passwordField);
		passwordField.sendKeys(password);
		waitForElementToAppear(loginBtn);
		loginBtn.click();
	}
	
}
