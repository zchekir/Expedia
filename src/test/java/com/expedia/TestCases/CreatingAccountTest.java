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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.expedia.PageObjects.Helper;

@SuppressWarnings("deprecation")
public class CreatingAccountTest extends Helper {
	// creating log object for logging messages to console/main.log file
	private static final Logger logger = LogManager.getLogger(CreatingAccountTest.class);
	
	@BeforeTest
	public void extentReportSetup() {
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
	
	@BeforeMethod
	public void browserSetup() {
		OpenBrowser();
		logger.info("Navigated to expedia.com");
	}
	
	@Test 
	public void validateTitle() {
		test = extent.createTest("Validate Expedia Title");
		Assert.assertEquals(driver.getTitle(), "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations");
		logger.info("Validated document tab title");
	}
	
	//@Test
	public void verifyLogo() throws IOException {
		test = extent.createTest("Verify Expedia Logo");
		WebElement headerLogo = driver.findElement(By.xpath("//a[@class='header-logo uitk-cell all-cell-shrink all-y-padding-two all-r-padding-two']//img"));
		// get screenshot of element and store as a file
		File file = headerLogo.getScreenshotAs(OutputType.FILE);
		// store file in our local machine
		File destFile = new File(System.getProperty("user.dir") + "/Screenshots/header-logo.png");
		FileUtils.copyFile(file, destFile);
		logger.info("Verified expedia logo on homepage");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			// add testcase name and exception to report
			test.fail(MarkupHelper.createLabel(result.getName()+" - "+result.getThrowable().getMessage(), ExtentColor.RED));
			// take and store screenshot
			String screenshotPath = getScreenshot(driver, result.getName());
			// add screenshot to report
			test.fail("Test Failed Screenshot below ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} 
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case SKIPPED", ExtentColor.ORANGE)); 
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		
		extent.flush();
		driver.quit();
		logger.info("Test result sent to extent report");
	}

}
