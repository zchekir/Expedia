package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utility.Constant;

public class LoginTest extends BaseTest {
	Logger logger = LogManager.getLogger(LoginTest.class);
	LoginPage loginPage;
	
	//@Test
	public void loginInvalidUser() {
		loginPage = new LoginPage(super.getDriver());
		loginPage.loginInvalidUser("invalidUser", "invalidPassword");
	}
	
	@Test
	public void loginValidUser() {
		loginPage = new LoginPage(super.getDriver());
		loginPage.loginValidUser(Constant.Username, Constant.Password);
		logger.info("TESTINGGGGGGG");
	}
	
	
	
}
