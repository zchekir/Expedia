package com.expedia.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends com.expedia.tests.HelperClassTest {
	
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
	
	
	public void initWebElements() {
		// PageFactory is used to find elements with @FindBy specified
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginValidUser(String username, String password) {
		viewAllCampgroundsLink.click();
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
