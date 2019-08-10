package com.selenium_framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_framework.common.WebDriverFactory;

public class AddEmpPage 
{
	@FindBy (id="firstName") 
	private WebElement empfName;
	
	@FindBy (id="lastName") 
	private WebElement emplName;
	
	@FindBy (id="btnSave") 
	private WebElement clickSave;	

	
	public AddEmpPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}

	
	public void addEmployee(String strEmpName, String strLastName) 
	{

		empfName.sendKeys(strEmpName);
		emplName.sendKeys(strLastName);
		clickSave.click();
		
	}
		
}
