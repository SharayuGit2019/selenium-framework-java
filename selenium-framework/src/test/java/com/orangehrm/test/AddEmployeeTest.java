package com.orangehrm.test;

import org.testng.annotations.Test;

import com.selenium_framework.common.AbstractSelenium;
import com.selenium_framework.pages.LoginPage;

public class AddEmployeeTest extends AbstractSelenium
{   
	@Test
    public void verifyAddEmpSucc()                 
    {
    	LoginPage lp = new LoginPage();
    	lp.navigateToLoginPage()
    		.login("admin", "admin")
    			.verifyAdminLinkisgettingDisplayed()
    			      .naviagateToPimPage()
    			           .navigateToAddEmpPage()
    			                 .addEmployee("Ashima", "Rao");
    	
    }
}

