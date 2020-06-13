package com.expedia.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.expedia.webpages.LoginPage;

public class LoginTest extends BaseTest {
	Logger logger = LogManager.getLogger(LoginTest.class);
	
	//@Test(description="Attempt to login with invalid credentials")
	public void loginInvalidUser() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.loginInvalidUser("invalidUser", "invalidPassword");
	}
	
	@Test
	public void loginValidUser() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.loginValidUser(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("User has logged in");
	}
	
	
	
}
