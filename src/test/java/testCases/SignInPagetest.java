package testCases;

//import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import factory.BaseClass;
import factory.Hooks;
import pageObject.GetStartedPage;
import pageObject.HomePage;
//import pageObject.RegisterPage;
import pageObject.SignInPage;
import utilities.DataProviders;

public class SignInPagetest extends Hooks{

	Logger logger = BaseClass.getLogger();		

	@Test (dataProvider="LoginData", dataProviderClass=DataProviders.class, priority=1, groups="regression")
	public void checkValidAndInvalidLoginTest(String user, String pwd, String result ) {
		 logger.info("Enter the login details and click Login at login page using DDT.............");
	     GetStartedPage gsp = new GetStartedPage(BaseClass.getDriver());
		 gsp.clickGetStartedSP();
	     HomePage hp = new HomePage(BaseClass.getDriver());
		 hp.clickSigIn();
		 SignInPage sp = new SignInPage(BaseClass.getDriver());	
		 sp.enterUsername(user);
		 sp.enterpassword(pwd);
		 sp.clickLogin();
		 
	  	 if (result.equalsIgnoreCase("Valid")){
			     boolean display = hp.YouAreLoggedInMsg();
					if (display==true) {
						Assert.assertTrue(true);
						logger.info("Test Passed");
					  }
					else{
						Assert.fail();
						logger.error("Test Failed");
					  }
			    }
			
			if (result.equalsIgnoreCase ("Invalid")){
				boolean display = sp.InvalidUsrNamePwdErrorMsg();
					if (display==true){
						Assert.assertTrue(true);
						logger.info("Test Passed");
					   }
					else {
						Assert.assertTrue(false);
						logger.error("Test Failed");
					   }
		        	}
	   }
		
	
				
			
}