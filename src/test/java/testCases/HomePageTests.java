package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import factory.Hooks;
import pageObject.GetStartedPage;
import pageObject.HomePage;
import utilities.DataProviders;

public class HomePageTests extends Hooks{

	Logger logger = BaseClass.getLogger();
	
	  @Test (priority=1, groups ={"smoke","regression"}, dataProvider="GetStartedTopics", dataProviderClass=DataProviders.class)
	  public void clickGetStartedButtonWithoutSignIn(String topic) {
			//logger.info("Clicking GetStarted button of any topic without Login....");
			GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
			sp.clickGetStartedSP();
			logger.info("Clicking the GetStarted Button at home page.............");
			HomePage hp = new HomePage(BaseClass.getDriver());
			hp.clickAnyGetStarted(topic);
			//logger.info("Check the display of 'You are notlogged in' error message.............");
			boolean status = hp.NotLoggedInErrorMsg();
			Assert.assertTrue(status);				
	   }
	
}
