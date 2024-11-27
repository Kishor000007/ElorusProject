package ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Elorus {

	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://app.elorus.com/login/");
	}
	@Test(priority = 1)
	public void logo() {
		boolean logo = driver.findElement(By.xpath("//i[@class='elorus-logo-full']")).isDisplayed();
		Assert.assertTrue(logo);
	}
	@Test(priority = 2)
	public void PageText() {
		boolean text = driver.findElement(By.xpath("//h1[text()='Welcome to Elorus']")).isDisplayed();
		Assert.assertFalse(text);
	}
	@Test(priority = 3,dependsOnMethods = "PageText")
	public void Username() {
		boolean un = driver.findElement(By.name("email")).isDisplayed();
		Assert.assertTrue(un);
	}
}
