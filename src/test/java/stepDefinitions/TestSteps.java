package stepDefinitions;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.SignupPage;
import tests.BaseTest;
import utility.Log;

public class TestSteps extends tests.BaseTest {
	// For every step in Login.feature we have implemented a method
	//private Logger logger = LogManager.getLogger(TestSteps.class);
	private LoginPage loginPage;
	private SignupPage signupPage;
	
	public BaseTest basetest;
	
	@Before
	public void testing() throws Exception {
		super.startupBrowser();
	}
	
	// Add Login feature step definitions...
	@Given("chrome browser launches and goes to url {string}")
	public void chrome_browser_launches_and_goes_to_url(String url) throws Exception {
		super.getDriver().get(url);
	    Log.info("Navigated to " + url);
	}

	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		loginPage = new LoginPage(super.getDriver());
		loginPage.setLoginCredentials(username, password);
		loginPage.clickLogin();
		Log.info("Entered login credentials");
	}

	@Then("successfully logged in")
	public void successfully_logged_in() {
		loginPage = new LoginPage(super.getDriver());
	    loginPage.clickLogout();
	    Log.info("Logged out user");
	    super.quitAllBrowsers();
	    Log.info("Closed all browsers");
	}
	
	
	// Add Signup feature step definitions...

	@Given("navigates to home page {string}")
	public void navigates_to_home_page(String homepageUrl) throws Throwable {
		super.startupBrowser();
	    super.getDriver().get(homepageUrl);
	    Log.info("Navigated to " + homepageUrl);
	}

	@When("user clicks on Sign Up link")
	public void user_clicks_on_Sign_Up_link() throws Throwable {
		signupPage = new SignupPage(super.getDriver());
	    signupPage.clickSignupLink();
	    Log.info("Clicked on sign up link");
	}

	@When("fills in for all required fields and clicks on Sign Up button")
	public void fills_in_for_all_required_fields_and_clicks_on_Sign_Up_button() throws Throwable {
		signupPage = new SignupPage(super.getDriver());
		String rEmail = super.randomString() + "@email.com";
		Log.info("Generated random email address: " + rEmail);
		signupPage.completeSignupFields(randomString(), randomString(), randomString(), randomString(), rEmail);
		Log.info("Filled in data for all required fields");
	}

	@Then("new account has been created")
	public void new_account_has_been_created() throws Throwable {
	    Log.info("New account created");
	}

	@When("user has automatically logged in with that new account")
	public void user_has_automatically_logged_in_with_that_new_account() throws Throwable {
		Log.info("Automatically logged into new account");
	}

	@Then("user can view confirmation message containing their username")
	public void user_can_view_confirmation_message_containing_their_username() throws Throwable {
		String signupConfirmationText = super.getDriver().findElement(By.tagName("body")).getText();
		Assert.assertTrue(signupConfirmationText.contains("Welcome to Yelpcamp"));	// this needs work!!
	}

	@Then("close browser")
	public void close_browser() throws Throwable {
		super.quitAllBrowsers();
		Log.info("Closing all browsers");
	}
	
}
