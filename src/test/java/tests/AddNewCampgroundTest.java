package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utility.Constant;


public class AddNewCampgroundTest extends BaseTest {
	
	Logger logger = LogManager.getLogger(AddNewCampgroundTest.class);
	
	@BeforeSuite
	public void initElements() {
		BasePage.homePage = new HomePage(super.getDriver());
		BasePage.loginPage = new LoginPage(super.getDriver());
	}
	
	@Test
	public void verify_add_new_campground() throws InterruptedException {
		BasePage.loginPage.loginValidUser(Constant.Username, Constant.Password);
		logger.info("User is logged in");
		Thread.sleep(3000);
		BasePage.homePage.submitNewCampground();
		logger.info("Added new campground");
	}

		
}
