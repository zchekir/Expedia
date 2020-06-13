package com.expedia.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.expedia.webpages.HomePage;
import com.expedia.webpages.LoginPage;


public class AddNewCampgroundTest extends BaseTest {
	
	Logger logger = LogManager.getLogger(AddNewCampgroundTest.class);
	
	LoginPage loginPage = new LoginPage(getDriver());
	HomePage homePage = new HomePage(getDriver());
	
	@Test
	public void addNewCampground() {
		loginPage.loginValidUser(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("User is logged in");
		homePage.submitNewCampground();
		logger.info("Added new campground");
	}

		
}
