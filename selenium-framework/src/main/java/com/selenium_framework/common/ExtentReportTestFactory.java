package com.selenium_framework.common;

import java.util.HashMap;
import java.util.Map;

import org.testng.IInvokedMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTestFactory 
{
	
	private static ExtentReports extentReport;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	private static Map<String, ExtentTest> moduleMap = new HashMap<String, ExtentTest>();
	
	static 
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Test Result");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Results");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
				
	}
	
	public static ExtentTest getParentTest(String className)
	{
		if(!moduleMap.isEmpty() && moduleMap.containsKey(className))
		{
			return moduleMap.get(className);
		}else {
			moduleMap.put(className, extentReport.createTest(className));
			return moduleMap.get(className);
		}
	}
	
	public static void createNewTest(IInvokedMethod m)
	{
		ExtentTest parentTest =getParentTest(m.getTestResult().getInstance().getClass().getSimpleName());
		
		ExtentTest childTest=parentTest.createNode(m.getTestMethod().getMethodName()); 
		
		extentTest.set(childTest);
		
		for(String group:m.getTestMethod().getGroups())
			extentTest.get().assignCategory(group);
	}

	public static void flushReport()
	{
		extentReport.flush();
	}

	public static ExtentTest getTest() 
	{
		return extentTest.get();
	}

}

