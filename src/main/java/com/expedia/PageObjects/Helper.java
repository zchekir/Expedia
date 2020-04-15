package com.expedia.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Helper {

	
	static WebDriver driver = new ChromeDriver();
	
	
	public void OpenBrowser() throws Exception {
		
		String url ="Expedia.com";
		
		// Additional code to help chromewebdriver:
		
		WebDriver driver = null;
		//WebDriverManager.chromedriver().version("77.0.3865.40").setup();
		//ChromeDriverManager.getInstance().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu"); 
		driver = new ChromeDriver(options); 
		driver.get(url); 
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\zchekir\\Desktop\\chromedriver.exe");
		driver.get(url);
}
}