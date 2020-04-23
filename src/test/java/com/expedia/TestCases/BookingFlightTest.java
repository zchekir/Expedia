package com.expedia.TestCases;

import org.testng.annotations.Test;

import com.expedia.PageObjects.Helper;


public class BookingFlightTest extends Helper {
	
	@Test
	public void BookingFlight() throws Exception {
		OpenBrowser();
		System.out.println("Booking flight pass");
		System.out.println("Jenkins working as expected");
	}

}
