package com.CRM.VTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	ExtentReports er;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName + "--->" + "TestScript execution started");
		// Start testScript execution.
		test = er.createTest(MethodName);

	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName + "--->" + "TestScript pass");
		test.log(Status.PASS, "TestScript pass");

	}

	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName + "--->" + "TestScript fail");
		test.log(Status.FAIL, "TestScript fail");
		// To print exception in our report
		test.log(Status.INFO, result.getThrowable());
		WebDriverUtility wdu = new WebDriverUtility();
		JavaUtility ju = new JavaUtility();
		String screenshotName = MethodName + "-" + ju.modifiedDate();
		try {
			String path = wdu.screenshotForEntireWebPage(BaseClass.listenerDriver, screenshotName);
			// Copy the SS from SS folder and attach the SS into our report.
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName + "--->" + "TestScript skipped");
		test.log(Status.SKIP, "TestScript skipped");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		System.out.println("Suite level execution started");
		// Basic system configuration
		ExtentSparkReporter esr = new ExtentSparkReporter(
				"./ExtentReport\\Report-" + new JavaUtility().modifiedDate() + ".html");
		esr.config().setDocumentTitle("Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("VTiger Execution Report");

		// Report configuration
		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("BaseURL", "http://localhost:8888");
		er.setSystemInfo("Browser", "Chrome");
		er.setSystemInfo("Platform", "Window");
		er.setSystemInfo("Reporter Name", "Raju");

	}

	public void onFinish(ITestContext context) {
		System.out.println("Suite level execution ended");
		// To consolidate the report and to replace the old report with new one.
		er.flush();
	}

}
