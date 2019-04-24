package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent
{
	static ExtentReports extent;
	static ExtentTest logger;

	@BeforeClass

	public static void startTest()

	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/testReport.html");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		logger = extent.createTest("test123");

		logger = extent.createTest("test1234");
		//	logger = extent.createTest("aLOK");

	}

	public void test123()
	{
		Assert.assertTrue(false);
	}

	public void test1234()
	{
		Assert.assertTrue(true);
	}

	@AfterClass

	public static void endTest()

	{

		extent.flush();

	}

}
