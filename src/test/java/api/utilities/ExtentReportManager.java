package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentReportManager implements ITestListener
	{
		public ExtentSparkReporter sparkReporter; // UI of report 
		public ExtentReports extent;				//common data like name os date ...
		public ExtentTest test;						// creating entries in the report
		
		String repName;
		
		public void onStart(ITestContext testContext) // before starting all the class
		{
			
			// Look and Feel
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Time Stamp
			repName="Test-Report-"+timeStamp+".html";
			
			sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);   // Specify Location of the report
			
			sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); // Title of the Project
			sparkReporter.config().setReportName("Pet Store Users API");  // Name of the report
			sparkReporter.config().setTheme(Theme.STANDARD);
			
			// General Information about
			
			extent=new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application", "Pet Store Users API");
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));
			//extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "Sriprasad R");
		}
	
		// Test case success 
		public void onTestSuccess(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.assignCategory(result.getName());
			test.createNode(result.getName());
			test.log(Status.PASS, "Test Passed");
		}
		
		// Test case Fail
		public void onTestFailure(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL, "Test Failed");
			test.log(Status.FAIL, result.getThrowable().getMessage());
		}
		
		// Test case Skipped
		public void onTestSkipped(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, "Test Skipped");
			test.log(Status.SKIP, result.getThrowable().getMessage());
		}
	
		// flush will generate by deleting old reports and generates new reports
		public void onFinish(ITestContext testContext)
		{
			extent.flush();
		}

	}
