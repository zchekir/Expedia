package com.expedia.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(id="header-account-menu") 
	private WebElement accountMenu;
	
	@FindBy(id="account-signin") 
	private WebElement signInLink;
	
	@FindBy(id="gss-signin-email") 
	private WebElement emailTextBox;
	
	@FindBy(id="gss-signin-password") 
	private WebElement passwordTextBox;
	
	@FindBy(id="gss-signin-submit") 
	private WebElement signInBtn;
	
	
	public void login(String email, String pw) {
		accountMenu.click();
		signInLink.click();
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(pw);
		signInBtn.click();
	}
	
}
