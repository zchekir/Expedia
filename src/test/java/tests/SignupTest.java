package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {
	// creating log object for logging messages to console/main.log file
	Logger logger = LogManager.getLogger(SignupTest.class);
	
	
	@Test 
	public void validateTitle() {
		Assert.assertEquals(getDriver().getTitle(), "YelpCamp");
		logger.info("Validated document tab title");
	}
	
	// ***Debug why this second test case does not appear in extent report***
	@Test
	public void verifyLogo() throws IOException, InterruptedException {
		getDriver().findElement(By.linkText("View All Campgrounds")).click();
		Thread.sleep(3000);
		WebElement brandLogo = getDriver().findElement(By.id("navbar-brand-img"));
		// get screenshot of element and store as a file
		File file = brandLogo.getScreenshotAs(OutputType.FILE);
		// store screenshot in local directory
		String path = System.getProperty("user.dir") + "/Screenshots/brandLogo" + dateName + ".png";
		File destFile = new File(path);
		try {
			FileUtils.copyFile(file, destFile);
		}
		catch(Exception e) {
			System.out.println("Saving screeshot capture of logo failed - " + e.getMessage());
		}
		logger.info("Verified YelpCamp logo");
	}
	

}
