package pageObject;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;


public class RegisterPage extends BasePage {

	
	public RegisterPage(WebDriver driver) {
		super(driver);
}

	
	@FindBy(xpath="//input[@id='id_username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='id_password1']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='id_password2']")
	private WebElement passwordConfirm;	
	
	@FindBy(xpath="//input[@value='Register']")
	private WebElement RegisterButton;

	public void enterUsername(String user) {
		username.sendKeys(user);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void enterPasswordConfirm(String pwd) {
		passwordConfirm.sendKeys(pwd);
	}
	
	public void clickRegister() {
		RegisterButton.click();
	}
	
	
	public String registerValidNewUser() {
		GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
		sp.clickGetStartedSP();
		HomePage hp = new HomePage(BaseClass.getDriver());
		hp.clickRegisterLink();
		RegisterPage rp = new RegisterPage(BaseClass.getDriver());
	   String user = BaseClass.randomeString();
	   rp.enterUsername(user);
	   String pwd = BaseClass.randomAlphaNumeric();
	   rp.enterPassword(pwd);
	   rp.enterPasswordConfirm(pwd);
	   rp.clickRegister();
	   return user;
	}
	
	
}