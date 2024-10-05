package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import factory.BaseClass;
import pageObject.DataStructurePage;
import pageObject.HomePage;

public class DS_IntroductionTests extends BaseClass{
	
	Logger logger = BaseClass.getLogger();	
	
	@Test (priority=0)
	void Test_DS_TimeComplexityLink()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());			
	    Hp.Login_HomePage();		
		 DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
		 Dp.click_GetStartedBtn_DSIroduction(); 
		 Dp.click_TimeComplexityBtn();
    	 String CurrentURL =BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, CurrentURL.contains("time"));
	}

	
	
	@Test  (priority=1)
	void Test_DS_TimeComplexity_Practice_Questions_link() 
	{
		
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());	
		HomePage Hp = new HomePage(BaseClass.getDriver());		
		Hp.Login_HomePage();		
		Dp.click_GetStartedBtn_DSIroduction();
		Dp.click_TimeComplexityBtn();
		Dp.click_DS_PracticeQuestionsBtn();
        String CurURL= BaseClass.getDriver().getCurrentUrl();		
		Assert.assertEquals(true, CurURL.contains("practice"));
		
	}
	
	
	
	
	@Test
	void Test_LeftPanel_TimeComplexity() 
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());		
   	Hp.Login_HomePage();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());		
		Dp.click_GetStartedBtn_DSIroduction();
		Dp.click_TimeComplexityBtn();	
		Dp.click_DS_TimeComplexity_LeftPanel();
		String CurrentURL =BaseClass.getDriver().getCurrentUrl();
		Assert.assertEquals(true, CurrentURL.contains("time"));
	}	
	

	
	@Test
	void DS_TimeComplexity_SignOutBtn() 
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());		
   	Hp.Login_HomePage();
		DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());				
		Dp.click_GetStartedBtn_DSIroduction();
		Dp.click_TimeComplexityBtn();
		Dp.click_Signout_Btn();		
		boolean status = Dp.SignOutErrorMessgae();
		Assert.assertTrue(status);
	}
	
	

	
}