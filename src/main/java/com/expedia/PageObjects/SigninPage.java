package com.expedia.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage {
	
	@FindBy(id="header-account-menu") 
	private WebElement accountMenu;
	
	@FindBy(id="account-signin") 
	private WebElement signInLink;
	
	@FindBy(id="gss-signin-email") 
	private WebElement emailField;
	
	@FindBy(id="gss-signin-password") 
	private WebElement passwordField;
	
	@FindBy(id="gss-signin-submit") 
	private WebElement signinBtn;
	
	
	public void loginValidUser(String email, String password) {
		accountMenu.click();
		signInLink.click();
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		signinBtn.click();
	}
	
}
