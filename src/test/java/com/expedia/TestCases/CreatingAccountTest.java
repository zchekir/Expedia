package com.expedia.TestCases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.expedia.PageObjects.Helper;

@SuppressWarnings("deprecation")
public class CreatingAccountTest extends Helper {
	// creating log object for logging messages to console/main.log file
	private static final Logger logger = LogManager.getLogger(CreatingAccountTest.class);
	
	@BeforeTest
	public void extentReportSetup() throws Exception {
		loadDataPropFile();
		// configuration for extent report
		htmlReporter = new ExtentHtmlReporter(htmlReportPath);
		htmlReporter.loadXMLConfig(htmlReporterConfigPath);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// general information related to application
		extent.setSystemInfo("Application", prop.getProperty("application"));
		extent.setSystemInfo("Environment", prop.getProperty("environment"));
		extent.setSystemInfo("OS", prop.getProperty("os"));
		extent.setSystemInfo("User", prop.getProperty("username"));
		extent.setSystemInfo("Browser", prop.getProperty("browser"));
	}
	
	@AfterTest 
	public void endReport() {
		extent.flush();
	}
	
	@BeforeMethod
	public void browserSetup() throws Exception {
		OpenBrowser();
		logger.info("Navigated to expedia.com");
	}
	
	@Test 
	public void ExpediaTitleValidation() {
		test = extent.createTest("Validate Expedia title");
		Assert.assertEquals(driver.getTitle(), "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations");
		logger.info("Validated expedia title");
	}
	
	@Test
	public void ValidateLogo() throws IOException {
		WebElement headerLogo = driver.findElement(By.xpath("//a[@id='header-logo']//img"));
		// get screenshot of element and store as a file
		File file = headerLogo.getScreenshotAs(OutputType.FILE);
		// store file in our local machine
		File destFile = new File(System.getProperty("user.dir") + "/Screenshots/header-logo.png");
		FileUtils.copyFile(file, destFile);
		Assert.assertEquals("this", "fail");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// add testcase name to extent report and style with markuphelper
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case FAILED", ExtentColor.RED));
			// add error/exception to report
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case FAILED", ExtentColor.RED));
			// take screenshot using function defined in helper class
			String screenshotPath = getScreenshot(driver, result.getName());
			// fail test and add screenshot to extent report
			test.log(Status.INFO, "Test Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case SKIPPED", ExtentColor.ORANGE)); 
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		
		driver.quit();
		logger.info("Closing down all browsers");
	}

}
