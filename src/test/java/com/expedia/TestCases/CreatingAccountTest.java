package com.expedia.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.expedia.PageObjects.Helper;

public class CreatingAccountTest extends Helper {
	// The name of this Logger will be "org.apache.logging.Parent"
	private static final Logger log = LogManager.getLogger(CreatingAccountTest.class);
	
	
	@Test
	public void launchBrowser() throws Exception {
		OpenBrowser();
		log.debug("testing debug log");
		log.error("testing error log");
		log.info("testing info log");
		log.warn("testing warning log");
		driver.quit();
		log.info("Closing down all browsers");
		
	}

}
