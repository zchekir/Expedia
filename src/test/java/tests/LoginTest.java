package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LoginPage;
import utility.Constant;

public class LoginTest extends BaseTest {
	
	Logger logger = LogManager.getLogger(LoginTest.class);
	
	@BeforeSuite
	public void initElements() {
		BasePage.loginPage = new LoginPage(super.getDriver());
	}
	
	//@Test
	public void verify_login_of_unauthorized_user() {
		BasePage.loginPage.loginInvalidUser("invalidUser", "invalidPassword");
	}
	
	@Test
	public void verify_login_of_authorized_user() {
		BasePage.loginPage.loginValidUser(Constant.Username, Constant.Password);
		logger.info("Entered in login credentials successfully!");
	}
	
	
	
}
