package com.selenium_framework.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory 
{
	private static WebDriver dr;

	public static void createWebDriverInstance() 
	{
		System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
        dr=new ChromeDriver();
		
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static WebDriver getDriver() 
	{
		return dr;
	}
}
