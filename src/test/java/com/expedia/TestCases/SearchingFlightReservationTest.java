package com.expedia.TestCases;

import org.testng.annotations.Test;

import com.expedia.PageObjects.Helper;

public class SearchingFlightReservationTest extends Helper {
	
	@Test
	public void SearchingFlightReservation() throws Exception {
		DataTest.ReadExcelData();
	}

}
