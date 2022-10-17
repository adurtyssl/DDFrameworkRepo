package com.test.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.test.base.TestBase;
import com.test.utilities.TestUtils;

public class CustomListeners extends TestBase implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
	 test = report.startTest(result.getName().toUpperCase());  
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"Passed_Test");
		report.endTest(test);
		report.flush();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		
		String path = "'C:\\Users\\Shyam\\eclipse-workspace-2\\DDFramework\\target\\error-screenshots\\"
					
					+result.getMethod().getMethodName()+".jpg'>Screenshot</a>";
		
		String screenshotPath = TestUtils.captureScreenshot(result.getMethod().getMethodName());
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"_Failed_Test");
		
		test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		
		
		Reporter.log("Login Screenshot captured");
		Reporter.log("<a target=\"_blank\" href="+path);
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" <img src="+result.getName()+".jpg height=200 width=200 ></img");
//		System.out.println("Inside OnTestFailure Method: " + result.getMethod().getMethodName());

		report.endTest(test);
		report.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
