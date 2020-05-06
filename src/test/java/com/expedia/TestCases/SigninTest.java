package com.expedia.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.expedia.PageObjects.Helper;
import com.expedia.PageObjects.SigninPage;

public class SigninTest extends Helper{

	@Test
	public void signinValidUser() throws Exception {
		OpenBrowser();
		SigninPage signinPage = new SigninPage();
		// PageFactory is used to find elements with @FindBy specified
		PageFactory.initElements(driver, signinPage);
		signinPage.loginValidUser(prop.getProperty("email"), prop.getProperty("password"));
		
		// how to deal with security captcha?
	}
}
