package com.expedia.TestCases;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.expedia.PageObjects.Helper;

public class DataTest extends Helper {
	
	static DataFormatter dataFormatter = new DataFormatter();

	@Test
	public static void ReadExcelData() throws Exception {
		
		OpenBrowser();
		FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/TestData.xlsx");
	
		workbook = new XSSFWorkbook(ExcelFile);
		sheet = workbook.getSheetAt(0);
		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			// Import second row, first cell data
	        cell = sheet.getRow(i).getCell(0);
	        cell.setCellType(CellType.STRING);
	        WebElement destination = driver.findElement(By.xpath("//input[@id='hotel-destination-hp-hotel']"));
	        destination.sendKeys(cell.getStringCellValue());
	
	        // Import second row, second cell data
	        cell = sheet.getRow(i).getCell(1);
	        cell.setCellType(CellType.NUMERIC);	// date stored as numeric
	        String cellStringValue = dataFormatter.formatCellValue(cell);
	        //System.out.println("data in excel file: " + cellStringValue);
	        WebElement checkIn = driver.findElement(By.xpath("//input[@id='hotel-checkin-hp-hotel']"));
	        checkIn.sendKeys(cellStringValue);
	        
	        // Import second row, third cell data
	        
		}
		
	}
	
	@Test
	public void WriteExcelData() {
		
	}

}
