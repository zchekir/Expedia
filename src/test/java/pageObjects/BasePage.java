package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	private static final int TIMEOUT = 4;
    private static final int POLLING = 500;
	
	protected WebDriver driver;
	private WebDriverWait wait;
	
	// creating objects for webpage
	public static LandingPage landingPage;
	public static HomePage homePage;
	public static LoginPage loginPage;
	public static SignupPage signupPage;
	
	// constructor takes driver object
	public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        // PageFactory is used to find elements with @FindBy specified
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }
	
	// utility wait methods to handle the various waits 
    protected void waitForElementToAppear(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected void waitForElementToDisappear(WebElement locator) {
        wait.until(ExpectedConditions.invisibilityOf(locator));
    }

    protected void waitForTextToDisappear(WebElement locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(locator, text)));
    }

}
