package com.expedia.PageObjects;

import org.apache.commons.io.FileUtils;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class Helper {

	public static WebDriver driver;
	
	public static Properties prop = new Properties();
	
	// excel sheet classes
	public static XSSFSheet sheet;
	public static XSSFWorkbook workbook;
	public static XSSFCell cell;
	public static XSSFRow row;
	
	// extent classes
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void loadDataPropFile() throws Exception {
		// load data.properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
		prop.load(file);
	}
	
	public static void OpenBrowser() throws Exception {
		loadDataPropFile();
		// configuring drivers
		if (prop.getProperty("browser").equals("chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(false);
			options.setAcceptInsecureCerts(true);
			options.addArguments("start-maximized", "disable-extensions");
			// to hide "Chrome is being controlled by automated" infobar message
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
		} else if (prop.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setHeadless(true);
			ffOptions.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(ffOptions);
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	// to take screenshots
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	  
		// store screenshot in local project directory
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
}