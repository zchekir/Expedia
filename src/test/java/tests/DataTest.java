package tests;

import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class DataTest extends BaseTest {
	
	Logger logger = LogManager.getLogger(DataTest.class);
	static DataFormatter dataFormatter = new DataFormatter();
	LandingPage landingPage;

	//@Test
	public void ReadExcelData() throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/TestData.xlsx");
		
			workbook = new XSSFWorkbook(ExcelFile);
			sheet = workbook.getSheetAt(0);
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				// Import second row, first cell data
		        cell = sheet.getRow(i).getCell(0);
		        cell.setCellType(CellType.STRING);
		        WebElement destination = getDriver().findElement(By.xpath("//input[@id='hotel-destination-hp-hotel']"));
		        destination.sendKeys(cell.getStringCellValue());
		
		        // Import second row, second cell data
		        cell = sheet.getRow(i).getCell(1);
		        cell.setCellType(CellType.NUMERIC);	// date stored as numeric
		        String cellStringValue = dataFormatter.formatCellValue(cell);
		        //System.out.println("data in excel file: " + cellStringValue);
		        WebElement checkIn = getDriver().findElement(By.xpath("//input[@id='hotel-checkin-hp-hotel']"));
		        checkIn.sendKeys(cellStringValue);
	
		        workbook.close();
			}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
			
			
		
		
	}
	
	
	@Test(dataProvider="SearchProvider")
	public void verify_search_campgrounds(String campground) throws InterruptedException {
		landingPage = new LandingPage(super.getDriver());
		landingPage.searchForCampground(campground);
		
		//String expectedMsg = "No campgrounds match that query, please try again.";
		boolean actualMsg = getDriver().findElement(By.xpath("//h4[contains(text(),'No campgrounds match that query, please try again.')]")).isDisplayed();
		System.out.println("The outcome of this boolean is: " + actualMsg);
		Assert.assertTrue(actualMsg, "The actualMsg element is present!");
		//Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@DataProvider(name="SearchProvider")
	public Object[][] getDataFromDataProvider() {
		return new Object[][]
			{
				{"test"},
				{"zak"},
				{"ice"}
			};
	}

}
