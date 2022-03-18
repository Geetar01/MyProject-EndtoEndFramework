package com.MyStore.utility;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.MyStore.base.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerClass extends ExtentManager implements ITestListener {
		//BaseClass bc=new BaseClass();
		public void onTestStart(ITestResult result) {
			test = extent.createTest(result.getName());
			//result.getMethod().getMethodName() this will give each method name whch r executing
		}

		public void onTestSuccess(ITestResult result) {
			if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, "Pass Test case is: " + result.getName());
				
				/*if (result.getStatus() == ITestResult.SUCCESS) {
					extentTest.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + ” Test Case PASSED”, ExtentColor.GREEN));
					extentTest.pass(methodName + “Test Step Passed”);
					}*/
			}
		}

		public void onTestFailure(ITestResult result) {
			
			if (result.getStatus() == ITestResult.FAILURE) {
				try {
					test.log(Status.FAIL,
							MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
					test.log(Status.FAIL,
							MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
					// Here you can add screenshot in the report for fail case
					String imgPath = BaseClass.captureScreenShot(BaseClass.getDriver(), result.getName());
				// now we are adding the captured screen in our extent report using test.
					test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build()); 
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		public void onTestSkipped(ITestResult result) {
			if (result.getStatus() == ITestResult.SKIP) {
				test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
				
			/*	if (result.getStatus() == ITestResult.SKIP) {
					extentTest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + ” – Test Case Skipped”, ExtentColor.ORANGE));
					extentTest.skip(methodName + “Test Step Skipped”);
					}*/
			}
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub

		}

		public void onFinish(ITestContext context) {
	
		}
	}
