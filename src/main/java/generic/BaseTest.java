package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;
	public Logger logger;
	public Properties data;
	
	@BeforeClass(groups={"Sanity","Regression","Master"})
	public void setPath() {
		try {
		FileInputStream f=new FileInputStream("D:\\Selenium\\Opencart\\data\\loginData.properties");
		data=new Properties();
		data.load(f);
	}catch(Exception e) {
		System.out.println("File loading failed");
	}
  }	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) {
		logger=LogManager.getLogger(this.getClass());
		
		if(br.toLowerCase().equals("chrome")) {
		driver=new ChromeDriver();
	   }
		else if(br.toLowerCase().equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(br.toLowerCase().equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browser name");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(data.getProperty("url"));
	}
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumeric() {
		String generatedAlphaNumeric = RandomStringUtils.randomAlphanumeric(4);
		return generatedAlphaNumeric;
	}
	
	public String captureScreen(String testname) throws IOException {
		
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String targetfilepath = System.getProperty("user.dir")+"\\screenshots\\"+ testname+"_"+timestamp+".png";
		File dest=new File(targetfilepath);
		FileUtils.copyFile(src, dest);
		return targetfilepath;
	}
	
	
	
	
	
	
	
	
}
