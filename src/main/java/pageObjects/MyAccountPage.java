package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h2[text()='My Account']")
	public WebElement myAccountTxt;
	
	@FindBy(xpath="(//a[text()='Logout'])[1]")
	public WebElement lnklogout;
	
	public boolean isMyAccountPageExists() {
		try {
		return(myAccountTxt.isDisplayed());
	}
		catch(Exception e){
			return false;
		}
	}
	public void clickLogout() {
		this.lnklogout.click();
	}
	
}
