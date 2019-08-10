package com.selenium_framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium_framework.common.WebDriverFactory;

public class AddUserPage 
{
	@FindBy (id="systemUser_employeeName_empName") 
	private WebElement empName;
	
	@FindBy (id="systemUser_userName") 
	private WebElement lastName;
	
	@FindBy (id="btnSave") 
	private WebElement clickSave;	

	
	public AddUserPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}

	
	public AdminPage addUser(String strEmpName, String strLastName) 
	{

		empName.sendKeys(strEmpName);
		lastName.sendKeys(strLastName);
		clickSave.click();
		
		return new AdminPage();
		
	}


}
