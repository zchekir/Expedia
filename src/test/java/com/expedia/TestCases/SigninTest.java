package com.expedia.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.expedia.PageObjects.Helper;
import com.expedia.PageObjects.HomePage;

public class SigninTest extends Helper{

	@Test
	public void Signin() throws Exception {
		OpenBrowser();
		HomePage homePage = new HomePage();
		// PageFactory is used to find elements with @FindBy specified
		PageFactory.initElements(driver, homePage);
		homePage.login(prop.getProperty("email"), prop.getProperty("password"));
		
		// how to deal with security captcha?
	}
}
