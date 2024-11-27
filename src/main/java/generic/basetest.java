
package generic;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class basetest {

	// all the constants are defined
	public static final String UserDir = System.getProperty("user.dir");

	public static final String ChromeKey = "webdriver.chrome.driver";
	public static final String GeckoKey = "webdriver.gecko.driver";
	public static final String EdgeKey = "webdriver.edge.driver";
	public static final String ChromeValue = UserDir + "\\driver\\chromedriver.exe";
	public static final String GeckoValue = UserDir + "\\driver\\geckodriver.exe";
	public static final String EdgeValue = UserDir + "\\driver\\msedgedriver.exe";

	public static final String ExcelPath = UserDir + "\\data\\ElorusData.xlsx";
	public static final String PropertyPath = UserDir + "\\data\\ElorusData.properties";

	public Properties data;
	public WebDriver driver;
	public static WebActionUtil actionUtil;

	// sets the path for driver executables
	@BeforeClass
	public void setPath() {
		try {
			FileInputStream f = new FileInputStream(PropertyPath);
			data = new Properties();
			data.load(f);
		} catch (Exception e) {

		}
		System.setProperty(ChromeKey, ChromeValue);
		System.setProperty(EdgeKey, EdgeValue);
		System.setProperty(GeckoKey, GeckoValue);
	}

	// launches the browser
	@Parameters("BrowserName")
	@BeforeMethod
	public void launchBrowser(String bn) {

		if (bn.equals("chrome"))
			driver = new ChromeDriver();
		else if (bn.equals("firefox"))
			driver = new FirefoxDriver();
		else if (bn.equals("edge"))
			driver = new EdgeDriver();
		
        actionUtil=new WebActionUtil(driver);
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(data.getProperty("url"));
	}

	// closes the browser
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	// termintes the driver executables in the background
	@AfterSuite
	public void KillDriver() {
		try {
			Runtime.getRuntime().exec("taskkill /IM chromedriver.exe /F");
			Runtime.getRuntime().exec("taskkill /IM geckodriver.exe /F");
			Runtime.getRuntime().exec("taskkill /IM msedgedriver.exe /F");
		} catch (Exception e) {

		}
	}
}