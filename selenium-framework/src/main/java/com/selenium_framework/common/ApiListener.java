package com.selenium_framework.common;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class ApiListener implements IInvokedMethodListener {
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) // one liner if statement
		{
			ExtentReportTestFactory.createNewTest(method);
		}
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
			if (!testResult.isSuccess()) {

				ExtentReportTestFactory.getTest().fail(testResult.getThrowable());

			} else {
				ExtentReportTestFactory.getTest().pass(testResult.getName() + " PASS successfully");
			}
			ExtentReportTestFactory.flushReport();
		}
	}
}
