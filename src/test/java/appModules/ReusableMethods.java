package appModules;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import utility.Constant;


public class ReusableMethods {
	
	public static void logUserIn(WebDriver driver) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginValidUser(Constant.Username, Constant.Password);
		
	}

}
