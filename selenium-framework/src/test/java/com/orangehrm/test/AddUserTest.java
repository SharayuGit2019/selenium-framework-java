package com.orangehrm.test;

import org.testng.annotations.Test;
import com.selenium_framework.common.AbstractSelenium;
import com.selenium_framework.pages.LoginPage;

public class AddUserTest extends AbstractSelenium
{   
	@Test
    public void verifyAddUserSucc()                 
    {
    	LoginPage lp = new LoginPage();
    	lp.navigateToLoginPage()
    		.login("admin", "admin") //Login
    			.verifyAdminLinkisgettingDisplayed() //Home
    				.naviagateToAdminPage()	
    					.navigateToAddUserPage()
    						.addUser("Maithili Ashok Raut", "sraut12345")
    						      .verifyUserInUserTable();
    	
    	
    }
}


