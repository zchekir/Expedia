package com.expedia.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Helper {
	
	@FindBy(linkText="Login") 
	private WebElement loginLink;
	
	@FindBy(name="username") 
	private WebElement usernameField;
	
	@FindBy(name="password") 
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@class='btn btn-primary']") 
	private WebElement loginBtn;
	
	
	public void launchBrowser() {
		OpenBrowser();
		// PageFactory is used to find elements with @FindBy specified
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginValidUser(String username, String password) {
		loginLink.click();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}
	
	public void loginInValidUser(String username, String password) {
		loginLink.click();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}
	
}
