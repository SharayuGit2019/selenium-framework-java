package com.selenium_framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.selenium_framework.common.WebDriverFactory;

public class LoginPage
{
	private WebDriverWait wait;
	
   @FindBy(id="txtUsername")           
   private WebElement userName;
   
   @FindBy(id="txtPassword")
   private WebElement userPass;
   
   @FindBy(id="btnLogin")
   private WebElement userLogin; 
   
   public LoginPage()     //constructor (no return type) ; Constructor always returns itself's object hence no return type
   {
	   PageFactory.initElements(WebDriverFactory.getDriver(), this);
	              //staticMethod
	        //class.method( , )
	   
	   wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);
	   
   }
   
   public LoginPage navigateToLoginPage()
   {
	   WebDriverFactory.getDriver().get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/admin/viewSystemUsers?sortField=user_name&sortOrder=ASC");
	   return this;
   }
   
   public HomePage login(String  strUserName , String strPassword)
   {
	   userName.sendKeys(strUserName);
	   userPass.sendKeys(strPassword);
	   userLogin.click();
	   
	   //return new HomePage();
	   return new HomePage().isPageLaoded();
	   
	   
	   //HomePage hp = new HomePage();
	   //return hp;
   }
   public LoginPage isPageLaoded()
   {
	   
	   wait.until(ExpectedConditions.visibilityOf(userName));
	   wait.until(ExpectedConditions.visibilityOf(userPass));
	   wait.until(ExpectedConditions.visibilityOf(userLogin));
   
	   /*Assert.assertTrue(userName.isDisplayed(), "Username field not loaded");
	   Assert.assertTrue(userPass.isDisplayed(), "Password field not loaded");
	   Assert.assertTrue(userLogin.isDisplayed(), "login field not loaded");  */
	   return this;
	  
   }
}
