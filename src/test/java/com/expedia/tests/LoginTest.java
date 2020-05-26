package com.expedia.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.expedia.webpages.LoginPage;

public class LoginTest extends HelperClassTest {
	Logger logger = LogManager.getLogger(LoginTest.class);
	
	LoginPage loginPage = new LoginPage();
	
	@BeforeTest
	public void initializeWebElements() {
		loginPage.initWebElements();
	}
	
	//@Test(description="Attempt to login with invalid credentials")
	public void loginInvalidUser() {
		loginPage.loginInValidUser("invalidUser", "pw");
	}
	
	@Test(description="Login with valid credentials")
	public void loginValidUser() throws Exception {
		loginPage.loginValidUser(prop.getProperty("email"), prop.getProperty("password"));
		logger.info("Successfully logged in");
	}
	
}
