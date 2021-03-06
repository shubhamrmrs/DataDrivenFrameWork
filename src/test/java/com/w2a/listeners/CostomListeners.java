package com.w2a.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;
import com.w2a.utilities.TestUtil;

public class CostomListeners extends TestBase implements ITestListener, ISuiteListener {
	String messageBody;

	public void onTestStart(ITestResult result) {

		test = rep.startTest(result.getName().toUpperCase());
// runmode - Y
		if (!TestUtil.isTestRunnable(result.getName(), excel)) {
			throw new SkipException("skipping the test" + result.getName().toUpperCase() + " as the runmode is NO ");
		}

	}

	public void onTestSuccess(ITestResult result) {
//ExtentReport:	
		test.log(LogStatus.PASS, result.getName().toUpperCase() + "PASS");
		rep.endTest(test);
		rep.flush();

	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}

// ExtentReport:
		test.log(LogStatus.FAIL, result.getName().toUpperCase() + " failed with exception: " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

//ReportNG:		
		Reporter.log("Click to see");
		Reporter.log("<a target=\"blank\" href=" + TestUtil.screenshotName + ">ScreenShot<a/>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img><a/>");
		rep.endTest(test);
		rep.flush();

	}

	public void onTestSkipped(ITestResult result) {

		test.log(LogStatus.SKIP, result.getName().toUpperCase() + " skipped the test as the runmode test No");
		rep.endTest(test);
		rep.flush();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		MonitoringMail mail = new MonitoringMail();
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/DataDrivenFrameWork/Extent_20Reports/";
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
