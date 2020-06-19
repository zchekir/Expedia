package tests;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constant;
import utility.Log;


public class BaseTest {
	
	public WebDriver driver;
	//protected Properties prop = new Properties();
	protected String dateName = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());

	private Logger logger = LogManager.getLogger(BaseTest.class);
	
	// for excel sheet usage
	protected XSSFSheet sheet;
	protected XSSFWorkbook workbook;
	protected XSSFCell cell;
	protected XSSFRow row;
	
	// for extent report usage
	protected String reportPath = System.getProperty("user.dir") + "/test-output/";
	protected ExtentReports extent;
	protected ExtentTest test;
	
	public void configureBrowser() {
		// configure web drivers
		if (Constant.Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.setHeadless(false);
			options.setAcceptInsecureCerts(true);
			options.addArguments("disable-extensions", "disable-popup-blocking");
			// to hide "Chrome is being controlled by automated" info-bar message
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			this.driver = new ChromeDriver(options);
		} 
		else if (Constant.Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setHeadless(false);
			ffOptions.setAcceptInsecureCerts(true);
			this.driver = new FirefoxDriver(ffOptions);
		} 
		else if(Constant.Browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.ignoreZoomSettings();
			ieOptions.introduceFlakinessByIgnoringSecurityDomains();
			this.driver = new InternetExplorerDriver(ieOptions);
		} 
		else logger.error("Please enter a supported browser in Constant.URL variable");
		
		driver.manage().window().maximize();
		// ***will be using explicit waits instead
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(Constant.URL);
		logger.info("Navigating to " + Constant.URL);
	}
	
	public void configureReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setDocumentTitle("YelpCamp Automation");
		spark.config().setReportName("Automation Execution Report");
		spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		// General information to specify in report
		extent.setSystemInfo("Application Name", Constant.Application);
		extent.setSystemInfo("Environment", Constant.Environment);
		extent.setSystemInfo("User", Constant.Username);
		extent.setSystemInfo("Browser", Constant.Browser);
		
		logger.info("Extent report has been setup and configured.");
	}
	
	// return driver to pass to page objects and tests
	public WebDriver getDriver() {
		return this.driver;
	}
	
	// launch browser and go to specified URL
	@BeforeSuite
	// will run before the execution of all the test methods in the suite
	public void startupBrowser() {
		configureBrowser();
		configureReport();
		
	}
	
	@BeforeMethod
	// will be executed before each test method will run
	public void setClassAndTestCaseNames(Method method) {
		// collecting the current running test case name
		String className = this.getClass().getSimpleName();
		test = extent.createTest(className + " - " + method.getName());
		Log.startTestCase(method.getName());
	}
	
	// send test case results to extent report
	@AfterMethod
	// will run after the execution of each test method. To send pass/fail test result to Extent report.
	public void getTestResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// add testcase name and exception to report
			test.fail(MarkupHelper.createLabel(result.getName() + " - " + result.getThrowable().getMessage(), ExtentColor.RED));
			// take and store screenshot
			String screenshotPath = getScreenshot(driver, result.getName());
			//System.out.println("Path of screenshot: " + screenshotPath);
			// add screenshot to report
			test.fail("Test Failed Screenshot below ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} 
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case SKIPPED", ExtentColor.ORANGE)); 
			System.out.println("Test result was Skipped");
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			System.out.println("Test result was Success");
		}
		
		extent.flush();	// to write all test logs to report file
		String actualReportPath = reportPath + "index.html";
		new File(actualReportPath).renameTo(new File(System.getProperty("user.dir") + "/test-output/" + "extent-report" + dateName + ".html"));
		
		Log.endTestCase(result.getName());
		//logger.info("Sending test result for the executed test case.");
	}
	
	@AfterSuite		
	// will run after the execution of ALL the test methods in suite. Closes all open browsers.
	public void quitAllBrowsers() {
		driver.quit();
		logger.info("Closed all browsers.");
	}
	
	// take and store screenshots locally
	public String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
	  
		// store screenshot in local project directory
		String path = System.getProperty("user.dir") + "/Screenshots/FailedScreenshots/" + screenshotName + this.dateName + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} 
		catch(Exception e) {
			System.out.println("Screenshot capture failed - " + e.getMessage());
		}
		
		return path;
	}
	
	
}