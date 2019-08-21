package com.orangehrm.test;

import org.testng.annotations.Test;

import com.selenium_framework.common.AbstractSelenium;
import com.selenium_framework.pages.LoginPage;

public class LoginTest extends AbstractSelenium
{   
	@Test(dataProvider= "ExcelData")
    public void verifyAdminLoginSucc(String  strUserName , String strPassword)                 
    {
    	LoginPage lp = new LoginPage();
    	lp.navigateToLoginPage()
    		.login(strUserName ,strPassword)
    			.verifyAdminLinkisgettingDisplayed();             //object Chain
    
    	//HomePage hp =new HomePage();
    	//hp.verifyAdminLinkisgettingDisplayed();
    }

	@Test(dataProvider= "ExcelData")
    public void verifyAdminLoginSuc1(String  strUserName , String strPassword)                 
    {
    	LoginPage lp = new LoginPage();
    	lp.navigateToLoginPage()
    		.login(strUserName ,strPassword)
    			.verifyAdminLinkisgettingDisplayed();             //object Chain
    
    	//HomePage hp =new HomePage();
    	//hp.verifyAdminLinkisgettingDisplayed();
    }

}
