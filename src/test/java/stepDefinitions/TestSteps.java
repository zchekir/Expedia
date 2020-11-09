package stepDefinitions;



import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import pageObjects.LoginPage;
import pageObjects.SignupPage;
import utility.Log;

public class TestSteps extends tests.BaseTest {
	// For every step in Login.feature we have implemented a method
	//private Logger logger = LogManager.getLogger("async_logger");
	private LoginPage loginPage;
	private SignupPage signupPage;
	
	
	@Before
	public void configBrowserAndReport() throws Exception {
		super.startupBrowser();
		loginPage = new LoginPage(super.getDriver());
		signupPage = new SignupPage(super.getDriver());
		
	}
	
	// Add Login feature step definitions...
	@Given("I am on the login page {string}")
	public void I_am_on_the_login_page(String url) throws Exception {
		super.getDriver().get(url);
	    Log.info("Navigated to " + url);
	}

	@When("I enter my username {string} and password {string}")
	public void I_enter_my_username_and_password(String username, String password) {
		loginPage.setLoginCredentials(username, password);
		Log.info("Filled in login credentials");
	}

	@Then("I am successfully logged in")
	public void I_am_successfully_logged_in() {
		loginPage.clickLogin();
		Log.info("Logged in");
	    loginPage.clickLogout();
	    Log.info("Logged out");
	    super.quitAllBrowsers();
	    Log.info("Scenario completed. Closing all browsers");
	}
	
	
	// Add Sign up feature step definitions...
	@Given("I am on the homepage {string}")
	public void I_am_on_the_homepage(String url) throws Throwable {
	    super.getDriver().get(url);
	    Log.info("Navigated to " + url);
	}

	@When("I click on the Sign Up link")
	public void I_click_on_the_Sign_Up_link() throws Throwable {
	    signupPage.clickSignupLink();
	    Log.info("Clicked on sign up link");
	}

	@And("I fill in my personal information")
	public void I_fill_in_my_personal_information() throws Throwable {
		String rEmail = super.randomString() + "@email.com";
		Log.info("Generated the random email address => " + rEmail);
		signupPage.completeSignupFields(randomString(), randomString(), randomString(), randomString(), rEmail);
	}

	@And("I click on the Sign Up button")
	public void I_click_on_the_Sign_Up_button() throws Throwable {
		signupPage.clickSignupBtn();
	}

	@Then("A new account is created and I am automatically logged in")
	public void A_new_account_is_created_and_I_am_automatically_logged_in() throws Throwable {
		super.quitAllBrowsers();
		Log.info("Scenario completed. Closing all browsers");
	}
	
}
