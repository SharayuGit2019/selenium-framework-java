package com.selenium_framework.common;

import java.io.IOException;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.selenium_framework.common.ExtentReportTestFactory;

public class FrameworkListeners implements IInvokedMethodListener
{
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
	{
		// TODO Auto-generated method stub
		if(method.isTestMethod()) //one liner if statement
		{
			WebDriverFactory.createWebDriverInstance();
			ExtentReportTestFactory.createNewTest(method);
		}
	}
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		// TODO Auto-generated method stub
		if(method.isTestMethod())
		{
			if(!testResult.isSuccess())
			{
				String screenshotNameWithPath="C:\\Selenium\\ScreenShots\\"+testResult.getName()+"-"+System.currentTimeMillis()+".png";
					SeleniumUtil.takeScreenshot(screenshotNameWithPath);
					
					try 
					{
						ExtentReportTestFactory.getTest().fail(testResult.getThrowable()).addScreenCaptureFromPath(screenshotNameWithPath);
					} catch (IOException e)
					{
						ExtentReportTestFactory.getTest().fail(testResult.getThrowable());
						e.printStackTrace();
					}
			}
			else 
			{
				ExtentReportTestFactory.getTest().pass(testResult.getName()+" PASS successfully");
			}
			ExtentReportTestFactory.flushReport();
			WebDriverFactory.getDriver().quit(); 
		}
	}
}
