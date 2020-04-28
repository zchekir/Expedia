package com.expedia.TestCases;

import java.util.Base64;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.expedia.PageObjects.Helper;


public class BookingFlightTest extends Helper {
	
	static String decodepassword="aGFwcHltYW4xNjM=";
	
	public static String getDecodedpassword() {
		return new String(Base64.getDecoder().decode(decodepassword.getBytes()));
	}
	
	@Test
	public void test1() throws Exception
	{
		OpenBrowser();
		driver.get("https://accounts.google.com/signin/v2/identifier?service=accountsettings&hl=en-US&continue=https%3A%2F%2Fmyaccount.google.com%2Fintro%3Fhl%3Den-US&csig=AF-SEnaCzW0Wem0BCxDm%3A1588104243&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.id("identifierId")).sendKeys("testerTest@gmail.com");
		driver.findElement(By.partialLinkText("Next")).click();
		driver.findElement(By.name("password")).sendKeys(getDecodedpassword());
		driver.findElement(By.id("signIn")).click();
	}
	
	//@Test
		public void BookingFlight() throws Exception {
			OpenBrowser();
			System.out.println("Booking flight pass");
			System.out.println("Jenkins working as expected");
		}
}
