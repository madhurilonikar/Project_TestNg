package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import factory.BaseClass;
import factory.Hooks;
import pageObject.GetStartedPage;
import pageObject.HomePage;

public class GetStartedPageTest extends Hooks{
	


	Logger logger = BaseClass.getLogger();

@Test (priority=1, groups={"smoke","regression"})
public void TestGetStartedButton()  {
	//logger.info("Clicking the GetStarted Button.............");
	GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
	HomePage hp = new HomePage(BaseClass.getDriver());
	sp.clickGetStartedSP();
	
	}
}