package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utility.Constant;


public class AddNewCampgroundTest extends BaseTest {
	
	Logger logger = LogManager.getLogger(AddNewCampgroundTest.class);
	
	LoginPage loginPage = new LoginPage(getDriver());
	HomePage homePage = new HomePage(getDriver());
	
	@Test
	public void addNewCampground() {
		loginPage.loginValidUser(Constant.Username, Constant.Password);
		logger.info("User is logged in");
		homePage.submitNewCampground();
		logger.info("Added new campground");
	}

		
}
