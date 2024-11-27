package ExtentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportClass implements ITestListener{

	//it specifies ui of the of the report
   public ExtentSparkReporter sparkReporter;
   
   //it populates the common information on the report
   public ExtentReports reports;
   
   //it creates testcases entries in the report and update the status of test methods
   public ExtentTest test;
   
   public void onStart(ITestContext context) {
	    String UserDir = System.getProperty("user.dir");
	    sparkReporter =new ExtentSparkReporter(UserDir+"./reports/demoreport.html");
	    //sets title of the report
	    sparkReporter.config().setDocumentTitle("Automation Testing");
	    //sets name of the report
	    sparkReporter.config().setReportName("Functional Testing");
	    //sets theme of the report 
	    sparkReporter.config().setTheme(Theme.DARK);
	    
	    reports=new ExtentReports();
	    reports.attachReporter(sparkReporter);
	    
	    reports.setSystemInfo("ComputerName", "Dell");
	    reports.setSystemInfo("OS", "Windows11");
	    reports.setSystemInfo("TesterName", "Kishor");
	  }
   
   public void onTestSuccess(ITestResult result) {
	   //create a new entry in the report
	    test=reports.createTest(result.getName());
	    //updates the status pass/fail/skip
	    test.log(Status.PASS,"Passed testcase is:"+result.getName());
	  }
   
   public void onTestFailure(ITestResult result) {
	   //create a new entry in the report
	    test=reports.createTest(result.getName());
	    //updates the status pass/fail/skip
	    test.log(Status.FAIL,"Testcase is Failed is:"+result.getName());
	    test.log(Status.FAIL," Failed testcase cause :"+result.getThrowable());
	  }

   public void onTestSkipped(ITestResult result) {
	   //create a new entry in the report
	    test=reports.createTest(result.getName());
	    //updates the status pass/fail/skip
	    test.log(Status.SKIP," Skipped testcase is is:"+result.getName());
	  }
   
   public void onFinish(ITestContext context) {
	   //it must have to write in onFinish method otherwise it didn't get work
	    reports.flush();
	  }
}
