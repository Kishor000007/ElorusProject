package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic.BaseTest;

public class ExtentReportClass implements ITestListener{

	//it specifies ui of the of the report
   public ExtentSparkReporter sparkReporter;
   
   //it populates the common information on the report
   public ExtentReports reports;
   
   //it creates testcases entries in the report and update the status of test methods
   public ExtentTest test;
   
   String repName;
   
   public void onStart(ITestContext testcontext) {
	   
	    /* SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	       Date dt=new Date();
	       String currentdatetimestamp = df.format(dt);  */
	   
	    String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    
	    repName="Test-Report-" + timestamp +  ".html";
//	    String UserDir = System.getProperty("user.dir");
	    sparkReporter =new ExtentSparkReporter(".\\reports\\"+repName);
	    //sets title of the report
	    sparkReporter.config().setDocumentTitle("Opencart Automation report");
	    //sets name of the report
	    sparkReporter.config().setReportName("Opencart Functional Testing");
	    //sets theme of the report 
	    sparkReporter.config().setTheme(Theme.DARK);
	    
	    reports=new ExtentReports();
	    reports.attachReporter(sparkReporter);
	    
	    reports.setSystemInfo("Application", "opencart");
	    reports.setSystemInfo("Module", "Admin");
	    reports.setSystemInfo("Sub Module", "Customers");
	    reports.setSystemInfo("User Name",System.getProperty("user.name"));
	    reports.setSystemInfo("Environment", "QA");
	    
	    String os = testcontext.getCurrentXmlTest().getParameter("os");
	    reports.setSystemInfo("Operating System", os);
	    
	    String browser = testcontext.getCurrentXmlTest().getParameter("browser");
	    reports.setSystemInfo("Browser", browser);
	    
	    List<String> includegroups = testcontext.getCurrentXmlTest().getIncludedGroups();
	    if(!includegroups.isEmpty())
	    	reports.setSystemInfo("Groups", includegroups.toString());
	  }
   
   public void onTestSuccess(ITestResult result) {
	   //create a new entry in the report
	    test=reports.createTest(result.getTestClass().getName());
	    //to display groups in report
	    test.assignCategory(result.getMethod().getGroups());
	    //updates the status pass/fail/skip
	    test.log(Status.PASS,result.getName()+" got sucessfully executed");
	  }
   
   public void onTestFailure(ITestResult result) {
	   //create a new entry in the report
	    test=reports.createTest(result.getTestClass().getName());
	    //to display groups in report
	    test.assignCategory(result.getMethod().getGroups());
	    //updates the status pass/fail/skip
	    test.log(Status.FAIL,result.getName()+" got failed");
	    test.log(Status.INFO,result.getThrowable().getMessage());
	    
	    try {
	    	String imgpath = new BaseTest().captureScreen(result.getName());
	    	test.addScreenCaptureFromPath(imgpath);
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	  }

   public void onTestSkipped(ITestResult result) {
	   //create a new entry in the report
	    test=reports.createTest(result.getTestClass().getName());
	    //to display groups in report
	    test.assignCategory(result.getMethod().getGroups());
	    //updates the status pass/fail/skip
	    test.log(Status.SKIP,result.getName()+" got skipped");
	    test.log(Status.INFO,result.getThrowable().getMessage());
	  }
   
   public void onFinish(ITestContext context) {
	   //it must have to write in onFinish method otherwise it didn't get work
	    reports.flush();
	    
	    String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
	    File extentReport=new File(pathOfExtentReport);
	    
	    try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
}
