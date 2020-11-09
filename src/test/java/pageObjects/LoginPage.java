package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import utility.Log;


public class LoginPage extends BasePage {

	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText="View All Campgrounds") 
	@CacheLookup
	private WebElement viewAllCampgroundsLink;
	
	@FindBy(linkText="Login") 
	@CacheLookup
	private WebElement loginLink;
	
	@FindBy(name="username") 
	@CacheLookup
	private WebElement usernameField;
	
	@FindBy(name="password") 
	@CacheLookup
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@class='btn btn-primary']") 
	@CacheLookup
	private WebElement loginBtn;
	
	@FindBy(linkText="Logout") 
	@CacheLookup
	private WebElement logoutBtn;
	
	
	public void loginValidUser(String username, String password) {
		waitForElementToAppear(viewAllCampgroundsLink);
		viewAllCampgroundsLink.click();
		waitForElementToAppear(loginLink);
		loginLink.click();
		waitForElementToAppear(usernameField);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		Log.info("Username and password entered into text fields");
		loginBtn.click();
		Log.info("User has logged in");
		waitForElementToAppear(logoutBtn);
		logoutBtn.click();
		Log.info("User has logged out");
	}
	public void loginInvalidUser(String username, String password) {
		waitForElementToAppear(viewAllCampgroundsLink);
		viewAllCampgroundsLink.click();
		waitForElementToAppear(loginLink);
		loginLink.click();
		waitForElementToAppear(usernameField);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		Log.info("Username and password entered into text fields");
		loginBtn.click();
		Log.info("Invalid user could not log in");
	}
	
	// For Cucumber...
	public void setLoginCredentials(String username, String password) {
		waitForElementToAppear(usernameField);
		usernameField.sendKeys(username);
		waitForElementToAppear(passwordField);
		passwordField.sendKeys(password);
	}
	public void clickLogin() {
		waitForElementToAppear(loginBtn);
		loginBtn.click();
	}
	public void clickLogout() {
		waitForElementToAppear(logoutBtn);
		logoutBtn.click();
	}
	
}
