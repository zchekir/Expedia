package com.expedia.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {

	public static WebDriver driver;
	
	
	
	public void OpenBrowser() throws Exception {
		
		
		
		Properties pro = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\zchekir\\eclipse-workspace\\Expedia-1\\src\\main\\java\\com\\expedia\\PageObjects\\Data.properties");
		pro.load(file);
		
		if (pro.getProperty("browser").equals("chrome")){
			
			driver = new ChromeDriver();
		}
		else if (pro.getProperty("browser").equals("firefox")){
			
			driver = new FirefoxDriver();
		}
		driver.get(pro.getProperty("url"));
		
		
		// configuring chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu"); 
		driver = new ChromeDriver(options); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	
		
	}

	
	
}