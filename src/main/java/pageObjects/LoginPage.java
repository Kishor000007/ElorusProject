package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-email")
	public WebElement textEmail;
	
	@FindBy(id="input-password")
	public WebElement textPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement btnLogin;
	
	public void enterEmail(String email) {
		this.textEmail.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		this.textPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		this.btnLogin.click();
	}
	
	
}
