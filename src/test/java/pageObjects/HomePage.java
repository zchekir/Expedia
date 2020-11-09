package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static pageObjects.HomePageWebElement.*;
import utility.Log;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText=addNewCampgroundLink) 
	@CacheLookup
	private WebElement addNewCampgroundBtn;
	public void clickAddNewCampgroundLink() {
		try {
			waitForElementToAppear(addNewCampgroundBtn);
			addNewCampgroundBtn.click();
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}
	
	@FindBy(name=campgroundName)
	@CacheLookup
	private WebElement nameField;
	public void enterCampgroundName() {
		try {
			waitForElementToAppear(nameField);
			nameField.sendKeys("campground one");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}
	
//	@FindBy(name=image)
//	@CacheLookup
//	private WebElement imageField;
//	public void clickImage() {
//		try {
//			waitForElementToAppear(addNewCampgroundBtn);
//			addNewCampgroundBtn.click();
//		} catch (Exception e) {
//			Log.error(e.getMessage());
//		}
//	}
	
	@FindBy(name=campgroundPrice)
	@CacheLookup
	private WebElement priceField;
	public void enterPrice() {
		try {
			waitForElementToAppear(priceField);
			priceField.sendKeys("10");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}
	
	@FindBy(name=campgroundDescription)
	@CacheLookup
	private WebElement descriptionField;
	public void enterDescription() {
		try {
			waitForElementToAppear(descriptionField);
			descriptionField.sendKeys("automated adding campground");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}
	
	@FindBy(id=location)
	@CacheLookup
	private WebElement locationField;
	public void enterLocation() {
		try {
			waitForElementToAppear(locationField);
			locationField.sendKeys("Atlanta, Georgia");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}
	
	@FindBy(className=clickSubmit)
	@CacheLookup
	private WebElement submitBtn;
	public void clickSubmitBtn() {
		try {
			waitForElementToAppear(submitBtn);
			submitBtn.click();
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}
	
	
	public void submitNewCampground() {
		clickAddNewCampgroundLink();
		enterCampgroundName();
		enterPrice();
		enterDescription();
		enterLocation();
		clickSubmitBtn();
	}
	
}
