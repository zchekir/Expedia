package com.expedia.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {

	public static WebDriver driver;
	
	
	
	public void OpenBrowser() throws Exception {
		
		
		
		Properties pro = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/data.properties");
		pro.load(file);
		
		// configuring drivers
		if (pro.getProperty("browser").equals("chrome")){
			
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
		} else if (pro.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(pro.getProperty("url"));
		System.out.println(driver.getTitle());
		
	
		
	}

	
	
}