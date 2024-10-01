package pageObject;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;



public class HomePage extends BasePage{
	
		   
		public static  Properties p;

		
		public HomePage(WebDriver driver) {
			super(driver);
		}
		
		@FindBy(xpath="//a[normalize-space()='Sign in']")
		private WebElement SignInLink;
		
			@FindBy (xpath ="//div[contains(text(),'You are not logged in')]")
			private WebElement NotLoggedInErrMsg;  
			
			@FindBy (xpath="//a[@href='data-structures-introduction']")
			private WebElement DataStructureGetStartedBtn;
			
			@FindBy (xpath="//a[@href='array']")
			private WebElement ArrayGetStartedBtn;
			
			@FindBy (xpath="//a[@href='linked-list']")
			private WebElement LinkedListGetStartedBtn;
			
			@FindBy (xpath="//a[@href='stack']")
			private WebElement StackGetStartedBtn;
			
			@FindBy (xpath="//a[@href='queue']")
			private WebElement QueueGetStartedBtn;
			
			@FindBy (xpath="//a[@href='tree']")
			private WebElement TreeGetStartedBtn;
			
			@FindBy (xpath="//a[@href='graph']")
			private WebElement GraphGetStartedBtn;
			

			@FindBy(xpath="//div[contains(text(),'You are logged in')]")
			private WebElement YouAreLoggedInMsg;
			
			@FindBy(xpath="//a[normalize-space()='Register']")
			private WebElement RegisterLink;
			
			@FindBy (xpath="//div[contains(text(),'New Account Created.')]")
			private WebElement NewAccCreatedMsg;
			
			public void Login_HomePage() 
			{
				SignInPage sp = new SignInPage(BaseClass.getDriver());	
				GetStartedPage Gp = new GetStartedPage(BaseClass.getDriver());
				Gp.clickGetStartedSP();
				clickSigIn();

				try {
					sp.enterUsername(BaseClass.getProperties().getProperty("username"));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				try {
					sp.enterpassword(BaseClass.getProperties().getProperty("password"));
				} catch (IOException e) {
					
					e.printStackTrace();
				}		

				 sp.clickLogin();	 


			}
			
			public boolean NotLoggedInErrorMsg() {
				boolean status = NotLoggedInErrMsg.isDisplayed();
				return status;
				
			}
			public boolean YouAreLoggedInMsg() {
				boolean status =  YouAreLoggedInMsg.isDisplayed();
				return status;
			}
			
			public void clickSigIn() {
				SignInLink.click();
			}
			
			
		
			public void clickDataStrucGetStarted() {
				DataStructureGetStartedBtn.click();
			}
			
			public void clickArrayGetStarted()  {
				ArrayGetStartedBtn.click();
			}
			
			public void clickLinkedListGetStarted() {
				LinkedListGetStartedBtn.click();
			}
			
			public void clickStackGetStarted(){
				StackGetStartedBtn.click();
			}
			
			public void clickQueueGetStarted() {
				QueueGetStartedBtn.click();
				}
			
			public void clickTreeGetStarted() {
				TreeGetStartedBtn.click();
			}
			
			public void clickGraphGetStarted(){
				GraphGetStartedBtn.click();
				
			}
			
			public void clickRegisterLink() {
				RegisterLink.click();
			}
			
			public boolean checkNewAccCreatedMsg() {
				boolean display = NewAccCreatedMsg.isDisplayed();
				return display;
			}
			public void clickAnyGetStarted(String topic) {
				switch (topic)
				{
				case "DataStructure": clickDataStrucGetStarted();break;
				case "Array":clickArrayGetStarted();break;
				case"LinkedList": clickLinkedListGetStarted();break;
				case "Stack":clickStackGetStarted();break;
				case "Queue":clickQueueGetStarted();break;
				case "Tree":clickTreeGetStarted();break;
				case "Graph":clickGraphGetStarted();break;
				default: System.out.println("Unable to find this topic....");break;		
				}
			}
			
}