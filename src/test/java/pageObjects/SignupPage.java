package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Log;

public class SignupPage extends BasePage {

	public SignupPage(WebDriver driver) {
		super(driver);
	}
	
	By signupLink = By.linkText("Sign Up");
	By usernameField=By.name("username");
	By passwordField=By.name("password");
	By firstNameField=By.name("firstName");
	By lastNameField=By.name("lastName");
	By emailField=By.name("email");
	By signupBtn=By.xpath("//button[@class='btn btn-primary']");
	
	public void clickSignupLink() {
		driver.findElement(signupLink).click();
	}
	
	public void completeSignupFields(String username, String pw, String firstName, String lastName, String email) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(pw);
		driver.findElement(firstNameField).sendKeys(firstName);
		driver.findElement(lastNameField).sendKeys(lastName);
		driver.findElement(emailField).sendKeys(email);
		Log.info("Entered in all required fields");
		driver.findElement(signupBtn).click();
		Log.info("Clicked Sign Up button");
	}
	

}
