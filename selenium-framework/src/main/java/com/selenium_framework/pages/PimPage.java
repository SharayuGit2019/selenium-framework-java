package com.selenium_framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_framework.common.WebDriverFactory;

public class PimPage 
{
	@FindBy(id="menu_pim_addEmployee")
	private WebElement addEmpTab;
	
	public PimPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public AddEmpPage navigateToAddEmpPage()
	{
		addEmpTab.click();
		
		return new AddEmpPage();
	}
	
}
