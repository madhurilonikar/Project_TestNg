package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import factory.Hooks;
//import pageObject.GetStartedPage;
import pageObject.HomePage;
import pageObject.RegisterPage;
//import pageObject.SignInPage;
//import utilities.DataProviders;

public class RegisterPageTest extends Hooks {

	
Logger logger = BaseClass.getLogger();
	
	@Test (priority =1, groups ={"smoke","regression"})
	public void RegisterNewAccount() {
		 //logger.info("Register a new user with Valid Details.............");
		 RegisterPage rp = new RegisterPage(BaseClass.getDriver());
		 rp.registerValidNewUser();
		 HomePage hp = new HomePage(BaseClass.getDriver());
		 //logger.info("Check 'New Account Created' message at home page....");
		 boolean status = hp.checkNewAccCreatedMsg();
		 Assert.assertTrue(status);
	  }
}
