package com.expedia.TestCases;

import org.testng.annotations.Test;

import com.expedia.PageObjects.Helper;

public class TC_CreatingAccount extends Helper {
	
	@Test
	public void launchBrowser() throws Exception {
		OpenBrowser();
		driver.quit();
		
	}

}
