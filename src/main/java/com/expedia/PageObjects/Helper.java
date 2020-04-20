package com.expedia.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {

	public static WebDriver driver;
	
	public static void OpenBrowser() throws Exception {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		prop.load(file);
		
		// configuring drivers
		if (prop.getProperty("browser").equals("chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			options.addArguments("--disable-gpu", "--start-maximized","--ignore-certificate-errors", "--no-sandbox"); 
			options.addArguments("--enable-automation", "--disable-notifications", "--disable-browser-side-navigation"); 
			driver = new ChromeDriver(options);
		} else if (prop.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setHeadless(true);
			driver = new FirefoxDriver(ffOptions);
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		//System.out.println(driver.getTitle());
		
	}
	
}