package com.expedia.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText="Add New Campground") 
	private WebElement addNewCampgroundBtn;
	
	@FindBy(name="campground[name]")
	private WebElement nameField;
	
	@FindBy(name="image")
	private WebElement imageField;
	
	@FindBy(name="campground[price]")
	private WebElement priceField;
	
	@FindBy(name="campground[description]")
	private WebElement descriptionField;
	
	@FindBy(id="location")
	private WebElement locationField;
	
	@FindBy(className="btn btn-primary")
	private WebElement submitBtn;
	
	
	public void submitNewCampground() {
		waitForElementToAppear(addNewCampgroundBtn);
		addNewCampgroundBtn.click();
		nameField.sendKeys("campground one");
		priceField.sendKeys("10");
		descriptionField.sendKeys("Lorem ipsum blah blah");
		locationField.sendKeys("Atlanta, Georgia");
		waitForElementToAppear(submitBtn);
		submitBtn.click();
	}
	
}
