package com.selenium_framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium_framework.common.WebDriverFactory;

public class HomePage 
{
    @FindBy (id= "welcome")       // xpath: //li[text="welcome"]
    private WebElement welComeText;
    
    @FindBy(id="menu_admin_viewAdminModule")
    private WebElement adminTab;
    
    @FindBy(id="menu_pim_viewPimModule")
	private WebElement clickPIM;

 public HomePage()
 
	     //constructor (no return type) ; Constructor always returns itself's object hence no return type
	   {
		   PageFactory.initElements(WebDriverFactory.getDriver(), this);
		              //staticMethod
		        //class.method( , )
	   }
 
 
 public HomePage verifyAdminLinkisgettingDisplayed()
 {
	 System.out.println(welComeText.isDisplayed());
	 Assert.assertEquals(welComeText.isDisplayed(), true);
	 
	 Assert.assertEquals(welComeText.getText(), "Welcome Admin");
	 
	 return this;

 }
 
 public AdminPage naviagateToAdminPage()
 {
	 adminTab.click();  
	                                                           /*try 
	                                                          {
		                                                     Thread.sleep(5000);
	                                                           } 
	                                                              catch (InterruptedException e)     //exception exception
	                                                             {
		                                                           e.printStackTrace();
	                                                              } */
	 
	 return new AdminPage();
 }
 
 
 
 public PimPage naviagateToPimPage()
 {
	 clickPIM.click();
	 return new PimPage();
	 
 }
 
 public HomePage isPageLaoded()
 {
	   Assert.assertTrue(welComeText.isDisplayed(), "Welcome text not loaded");
	   Assert.assertTrue(adminTab.isDisplayed(), "admin tab not loaded");
	   
	   return this;
	   
	   
 }
 
}
