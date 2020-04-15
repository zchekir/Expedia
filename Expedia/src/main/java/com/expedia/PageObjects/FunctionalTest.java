package com.expedia.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTest {
	
	static WebDriver driver = new ChromeDriver();
	
	
	public void OpenBrowser() {
		String url ="Expedia.com";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\zchekir\\Desktop\\chromedriver.exe");
		driver.get(url);
	}

}
