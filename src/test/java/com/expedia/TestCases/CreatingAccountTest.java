package com.expedia.TestCases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/extent-report.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/src/main/resources/htmlreporter-config.xml");
//		htmlReporter.config().setReportName("Report for CreatingAccountTest");
//		htmlReporter.config().setDocumentTitle("Expedia Automation Report");
//		htmlReporter.config().setTheme(Theme.DARK);
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
		logger.info("Asserted expedia title");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// to add name in extent report and style with markuphelper
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - TEST CASE FAILED", ExtentColor.RED));
			// to add error/exception
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - TEST CASE FAILED", ExtentColor.RED));
			// to capture screenshot path and store it in string 
			String screenshotPath = getScreenshot(driver, result.getName());
			// fail test and add screenshot to extent report
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case SKIPPED", ExtentColor.ORANGE)); 
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		driver.quit();
		logger.info("Closing down all browsers");
	}

}
