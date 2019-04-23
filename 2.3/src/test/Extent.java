package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Extent
{

	static ExtentTest test;

	static ExtentReports report;

	@BeforeClass

	public static void startTest()

	{

		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");

		test = report.startTest("aLOK");

	}

	@AfterClass

	public static void endTest()

	{

		report.endTest(test);

		report.flush();

	}

}
