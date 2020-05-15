package com.expedia.TestCases;

import org.testng.annotations.Test;

import com.expedia.PageObjects.Helper;
import com.expedia.PageObjects.LoginPage;

public class TestLogin extends Helper{
	
	@Test(description="Attempt to login with invalid credentials")
	public void loginInValidUser() {
		LoginPage loginPage = new LoginPage();
		loginPage.launchBrowser();
		loginPage.loginInValidUser("invalidUser", "pw");
	}
	
	@Test(description="Login with valid credentials")
	public void loginValidUser() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.launchBrowser();
		loginPage.loginValidUser(prop.getProperty("email"), prop.getProperty("password"));
		
		// how to deal with security captcha?
	}
}
