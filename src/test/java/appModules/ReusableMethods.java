package appModules;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import utility.Constant;

// all reusable methods will go in this class

public class ReusableMethods {
	
	public static void Execute(WebDriver driver) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginValidUser(Constant.Username, Constant.Password);
		
	}

}
