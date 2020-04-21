package com.expedia.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.expedia.PageObjects.Helper;

public class SignInTest extends Helper{

	@Test
	public void ExcelData() throws Exception {
		
		OpenBrowser();
		driver.findElement(By.xpath("//button[@id='header-account-menu']")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='account-signin']")).click();
		driver.findElement(By.xpath("//input[@id='gss-signin-email']")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath("//input[@id='gss-signin-password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@id='gss-signin-submit']")).click();
		
		// dealing with picture captcha
	
	}
}
