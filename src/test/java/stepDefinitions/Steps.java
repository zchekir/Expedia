package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import tests.BaseTest;

public class Steps extends tests.BaseTest {
	// For every step in Login.feature we have implemented a method
	private Logger logger = LogManager.getLogger(BaseTest.class);
	private LoginPage loginPage;
	
	@Given("User launches chrome browser")
	public void user_launches_chrome_browser() {
		super.startupBrowser();
		logger.info("Browser started up");
	}

	@Given("User opens URL {string}")
	public void user_goes_to(String url) {
	    super.getDriver().get(url);
	    logger.info("The specified url was hit!");
	}

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_and_password(String username, String password) {
		loginPage = new LoginPage(getDriver());
		loginPage.setLoginCredentials(username, password);
		logger.info("Login credentials entered");
	}

	@When("Clicks on login button")
	public void clicks_on_login_button() {
		loginPage = new LoginPage(getDriver());
	    loginPage.clickLogin();
	    logger.info("Logged in user!");
	}

	@Then("User is successfully logged in")
	public void user_is_successfully_logged_in() {
		loginPage = new LoginPage(getDriver());
	    loginPage.clickLogout();
	    logger.info("Logged out user");
	}

	@Then("Browser closes")
	public void browser_closes() {
	    super.quitAllBrowsers();
	}
}
