package com.selenium_framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_framework.common.WebDriverFactory;

public class EmpListPage 

{

	@FindBy(id="menu_pim_addEmployee")
	private WebElement addEmpPage;
	
	public EmpListPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public AdminPage naviagateToAddEmpPage()
	 {
		 addEmpPage.click();
		 return new AdminPage();
		 
	 }
}
