package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utility.Constant;


public class AddNewCampgroundTest extends BaseTest {
	
	@BeforeSuite
	public void initElements() {
		BasePage.homePage = new HomePage(super.getDriver());
		BasePage.loginPage = new LoginPage(super.getDriver());
		
	}
	
	@Test
	public void verify_add_new_campground() throws InterruptedException {
		BasePage.loginPage.loginValidUser(Constant.Username, Constant.Password);
		BasePage.homePage.submitNewCampground();
	}

		
}
