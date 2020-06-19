package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="search")
	@CacheLookup
	private WebElement searchField;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	private WebElement searchBtn;
	
	public void searchForCampground(String campground) {
		waitForElementToAppear(searchField);
		waitForElementToAppear(searchBtn);
		searchField.sendKeys(campground);
		searchField.getAttribute("value");
		System.out.println("Searched for test value: " + campground);
		searchBtn.click();
		waitForTextToDisappear(searchField, campground);
	}

}
