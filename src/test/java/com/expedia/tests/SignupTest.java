package com.expedia.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTest extends HelperClassTest {
	// creating log object for logging messages to console/main.log file
	Logger logger = LogManager.getLogger(SignupTest.class);
	
	@BeforeMethod
	// will be executed before each test method will run
	public void beforeMethod(Method method) {
		// collecting the current running test case name
		String className = this.getClass().getSimpleName();
		test = extent.createTest(className + " - " + method.getName());
	}
	
	@Test 
	public void validateTitle() {
		Assert.assertEquals(driver.getTitle(), "YelpCamp");
		logger.info("Validated document tab title");
	}
	
	//@Test
	public void verifyLogo() throws IOException {
		WebElement headerLogo = driver.findElement(By.id("navbar-brand-img"));
		// get screenshot of element and store as a file
		File file = headerLogo.getScreenshotAs(OutputType.FILE);
		// store file in our local machine
		File destFile = new File(System.getProperty("user.dir") + "/Screenshots/header-logo.png");
		FileUtils.copyFile(file, destFile);
		logger.info("Verified YelpCamp logo");
	}
	
	
	
	

}
