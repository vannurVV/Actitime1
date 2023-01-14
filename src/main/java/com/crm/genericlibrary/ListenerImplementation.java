package com.crm.genericlibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log("testmethod execution started",true);
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("testmethod execution success",true);
	}

	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+name+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("testmethod execution skipped",true);
	}
}
