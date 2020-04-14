package Zak;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

 public class OpenBrowser {
    	 
   static WebDriver driver;  // web driver
  // static WebDriver driver = new ChromeDriver();
   ExtentTest test;        // what details should be populated in the report
   ExtentReports extent;    // specify location of report
   
  
	
	@BeforeTest
    public void startReport() {
        @SuppressWarnings("deprecation")
		ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ZakExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(html);
        
    }
    
	
	@Parameters({"url"})
	@Test
	public void  webDriver(String url) throws AWTException 
	    {
		
		 extent.createTest("weDriver Methode");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\zchekir\\Desktop\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--headless");
		 driver = new ChromeDriver(options); // headless mode
         driver.get(url);
         
         }
   
	
     @Test
	 public void clickLogin() 
	   {
       extent.createTest("ClickLogin Button"); 
	   WebDriverWait w = new WebDriverWait(driver,1);
	   WebElement click_Login = driver.findElement(By.xpath("//*[@ type='submit']")); 
	   w.until(ExpectedConditions.elementToBeClickable(click_Login));
	   click_Login.click();
	   for(String winHandle1 : driver.getWindowHandles())
	   {
	   driver.switchTo().window(winHandle1); // switch Iframe
		   
		}
	 }
	
    
    @Parameters({"username","PW"})
    @Test  
	public  void EnterCredentials(String UserName, String Password ) throws InterruptedException
	   {
    	
    	extent.createTest("EnterCredentials");
      	
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   
		WebElement Enteruser_Name = driver.findElement(By.xpath("//input[@id='i0116']"));
		Enteruser_Name.sendKeys(UserName);
		WebElement clickNext = driver.findElement(By.xpath("//input[@id='idSIButton9']"));
		clickNext.click();	
		
		Thread.sleep(1000);
		WebElement EnterPassword = driver.findElement(By.xpath("//input[@id='i0118']"));
		EnterPassword.sendKeys(Password);
		
		Thread.sleep(1000);
		WebElement ClickSighin= driver.findElement(By.xpath("//input[@type='submit']"));
		ClickSighin.click();
		
		
		WebElement ClickNo= driver.findElement(By.xpath("//input[@type='button']"));
		ClickNo.click();
		
	
		
		
	   }
    
    @DataProvider
    public Object[][] getdata() {
    	Object[][] data = new Object[2][2];
    	data[0][0]= "zchekir@cogstate.com";
    	data[0][1]="Mamine2010@@";
    	
    	data[1][0]= "zchekir@cogstate.com";
    	data[1][1]="Mamine2010@@";
    	return data;
    }
    
    // Update the log reports 
    @AfterMethod
    public void closeDown() {
    extent.flush();    // to write/update logs to file
	
        
    }
    
	
    
  
    
    
    
    
   
}
