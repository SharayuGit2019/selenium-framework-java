package com.selenium_framework.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory 
{
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static void createWebDriverInstance() 
	{
		/*
		 * System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe"); 
		 * dr.set(new ChromeDriver());
		 */
		
		
		DesiredCapabilities capabilities =new DesiredCapabilities();
		
		capabilities.setBrowserName("chrome");
		capabilities.setVersion("76.0.3809.87");
		
		WebDriver localDriver;
		try {
			localDriver = new RemoteWebDriver(new URL("http://192.168.1.7:4444/wd/hub"),capabilities);
			dr.set(localDriver);
			dr.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static WebDriver getDriver() 
	{
		return dr.get();
	}
}
