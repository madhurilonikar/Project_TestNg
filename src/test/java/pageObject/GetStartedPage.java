package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GetStartedPage extends BasePage {
	
	public GetStartedPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="//button[normalize-space()='Get Started']")
	private WebElement GetStartedBtn;
	
	
	public void clickGetStartedSP() {
		GetStartedBtn.click();
	}
	
}