package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent
{

	static ExtentReports report;
	//helps to generate the logs in test report.
	static ExtentTest Logger;

	@BeforeClass

	public static void startTest()

	{
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html", true);

	}

	@Test
	public void test123()
	{
		Logger = report.startTest("test123");
		Assert.assertTrue(false);

	}

	@Test
	public void test1234()
	{
		Logger = report.startTest("test1234");
		System.out.println("testing");

	}

	@Test
	public void call()
	{
		Logger = report.startTest("call");
		aLOK a = new aLOK();
		a.test();
		a.test1();

	}

	@AfterMethod
	public void getResult(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			Logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			Logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			Logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
		}

		//report.endTest(Logger);
	}

	@AfterClass

	public static void endTest()

	{

		report.flush();

	}

}
