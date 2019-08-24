package com.selenium_framework.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SeleniumUtil 
{

	public static void takeScreenshot(String fileNameWithPath)
	{
		File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(scrFile, new File(fileNameWithPath));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}