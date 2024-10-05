package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import factory.BaseClass;
import pageObject.DataStructurePage;
import pageObject.GraphPage;
import pageObject.HomePage;
import pageObject.SignInPage;

public class GraphPageTests extends BaseClass {

	Logger logger = BaseClass.getLogger();
	public void checkValidAndInvalidLoginTest(String user, String pwd) {
		SignInPage sp= new SignInPage(BaseClass.getDriver());
		logger.info("Enter the username at login page.............");
		 sp.enterUsername(user);
		 sp.enterpassword(pwd);
		 sp.clickLogin();
		}

		 @Test(priority=4,groups="regression")
		 public void check_TryHereButton() 
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
		     Hp.Login_HomePage();
		     Hp.clickGraphGetStarted();
		     GraphPage Gp = new GraphPage (BaseClass.getDriver());
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	
			
			 Gp.check_GraphHomePage();
			    Gp.click_GraphLink();
			    Gp.clickTryHereBtn();
			 Gp.check_TryEditorPage();
			    boolean status= Gp.check_TryEditorPage();
				 Assert.assertEquals(status, true);
				 logger.info("TryEditor page is displayed");
		 }
		
		 @Test(priority=4,groups="regression")
		 public void check_PythonEditorValidInput() 
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
			 Hp.Login_HomePage();
			    Hp.clickGraphGetStarted();
			  GraphPage Gp = new GraphPage (BaseClass.getDriver());
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	
			 Gp.check_GraphHomePage();
			    Gp.click_GraphLink();
			    Gp.clickTryHereBtn();
			 Gp.check_TryEditorPage();
			 logger.info("Entering valid python code..........");
			  ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
			  ds.click_DS_PythonEditor_RunBtn();  
			  ds.validate_Console_Output();     
				
				  logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
				  Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );
				  
		 }
		
		 @Test(priority=4,groups="regression")
		 public void check_PythonEditorInvalidInput() 
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
			 Hp.Login_HomePage();
			    Hp.clickGraphGetStarted();
			  GraphPage Gp = new GraphPage (BaseClass.getDriver());
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	
			 Gp.check_GraphHomePage();
			    Gp.click_GraphLink();
			    Gp.clickTryHereBtn();
			 Gp.check_TryEditorPage();
			 logger.info("User Entering invalid pythod code on the editor ..... ");
			 ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
			 ds.Validate_OutputConsole_InvalidCodes();
			 logger.info("Alert Message in Python Editor " + ds.Alertmesg);		
		     Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));
		        
		 }
	
		 @Test(priority=4,groups="regression")
		 public void check_PythonEditorNoInput() 
		 {
			 HomePage Hp = new HomePage(BaseClass.getDriver());		
			 Hp.Login_HomePage();
			    Hp.clickGraphGetStarted();
			  GraphPage Gp = new GraphPage (BaseClass.getDriver());
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());		
			 Gp.check_GraphHomePage();
			 Gp.click_GraphLink();
			   
			    logger.info("user clicked Graph link.........");
			    Gp.check_GraphPage();
			    logger.info("Redirecting to Graph page..............");
			    Gp.clickTryHereBtn();
			 ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
			 String Current_URL = BaseClass.getDriver().getCurrentUrl();
			 Assert.assertEquals(true, Current_URL.contains("tryEditor"));
		
		 }
		 
	
}
