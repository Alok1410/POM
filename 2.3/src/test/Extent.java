package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent
    {
        
        // builds a new report using the html template
        static ExtentHtmlReporter htmlReporter;

        static ExtentReports      extent;
        // helps to generate the logs in test report.
        static ExtentTest         test;

        @BeforeClass

        public static void startTest()

            {// initialize the HtmlReporter
                htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\ExtentReportResults.html");

                // initialize ExtentReports and attach the HtmlReporter
                extent = new ExtentReports();
                extent.attachReporter(htmlReporter);

            }

        @Test
        public void test123()
            {
                test = extent.createTest("test123");
                Assert.assertTrue(false);

            }

        @Test
        public void test1234()
            {
                test = extent.createTest("test1234");
                System.out.println("testing");

            }

        @Test
        public void call()
            {
                test = extent.createTest("call");
                aLOK a = new aLOK();
                a.test();
                a.test1();

            }

        @AfterMethod
        public void getResult(ITestResult result)
            {
                if (result.getStatus() == ITestResult.FAILURE)
                    {
                        test.log(Status.FAIL, "Test Case Failed is " + result.getName());
                        test.fail(result.getThrowable());
                    } else if (result.getStatus() == ITestResult.SUCCESS)
                    {
                        test.log(Status.PASS, "Test Case Passed is " + result.getName());
                    }

                // report.endTest(Logger);
            }

        @AfterClass

        public static void endTest()

            {

                extent.flush();

            }

    }
