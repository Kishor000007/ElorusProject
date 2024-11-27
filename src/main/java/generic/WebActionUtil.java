package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebActionUtil {

	WebDriver driver;

	public WebActionUtil(WebDriver driver) {
		this.driver = driver;
	}

	// method to read the data from the Excel
	public static String getData(String location, String sn, int r, int c) {
		try {
			FileInputStream f1 = new FileInputStream(location);
			Workbook book = WorkbookFactory.create(f1);
			String data = book.getSheet(sn).getRow(r).getCell(c).getStringCellValue();
			return data;
		} catch (Exception e) {
			return null;
		}
	}

	// method to validate the title
	public void ValidateTitle(String expectedTitle) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			System.out.println("pass:Title is matching");
		} catch (Exception e) {
			System.out.println("Fail:Title is not matching");
			Assert.fail();
		}
	}

	// method to validate the visibility of an element
	public void ValidateVisibility(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("pass:Title is matching");
		} catch (Exception e) {
			System.out.println("Fail:Title is not matching");
			Assert.fail();
		}
	}

	// method to capture the screenshot
	public void captureScreenShot(String ScriptName) {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File(basetest.UserDir + "\\screenshot\\" + ScriptName + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

		}
	}
}
