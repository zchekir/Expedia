package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText="Add New Campground") 
	@CacheLookup
	private WebElement addNewCampgroundBtn;
	
	@FindBy(name="campground[name]")
	@CacheLookup
	private WebElement nameField;
	
	@FindBy(name="image")
	@CacheLookup
	private WebElement imageField;
	
	@FindBy(name="campground[price]")
	@CacheLookup
	private WebElement priceField;
	
	@FindBy(name="campground[description]")
	@CacheLookup
	private WebElement descriptionField;
	
	@FindBy(id="location")
	@CacheLookup
	private WebElement locationField;
	
	@FindBy(className="btn btn-primary")
	@CacheLookup
	private WebElement submitBtn;
	
	
	public void submitNewCampground() {
		waitForElementToAppear(addNewCampgroundBtn);
		addNewCampgroundBtn.click();
		waitForElementToAppear(nameField);
		waitForElementToAppear(submitBtn);
		nameField.sendKeys("campground one");
		priceField.sendKeys("10");
		descriptionField.sendKeys("automated adding campground");
		locationField.sendKeys("Atlanta, Georgia");
		submitBtn.click();
	}
	
}
