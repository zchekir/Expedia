package com.expedia.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath="//button[@id='header-account-menu']") 
	private WebElement accountMenu;
	
	@FindBy(xpath="//a[@id='account-signin']") 
	private WebElement signInLink;
	
	@FindBy(xpath="//input[@id='gss-signin-email']") 
	private WebElement emailTextBox;
	
	@FindBy(xpath="//input[@id='gss-signin-password']") 
	private WebElement passwordTextBox;
	
	@FindBy(xpath="//button[@id='gss-signin-submit']") 
	private WebElement signInBtn;
	
	
	public void login(String email, String pw) {
		accountMenu.click();
		signInLink.click();
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(pw);
		signInBtn.click();
	}
	
}
