package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	public WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	public WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	public WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	public WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	public WebElement txtPwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	public WebElement txtConfPwd;
	
	@FindBy(xpath="//input[@name='agree']")
	public WebElement chkPrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	public WebElement btnContinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	public WebElement confirmationMessage;
	
	public void setFirstName(String firstname) {
		this.txtFirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		this.txtLastName.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		this.txtEmail.sendKeys(email);
	}
	
	public void settelephone(String telephone) {
		this.txttelephone.sendKeys(telephone);
	}
	
	public void setPwd(String pwd) {
		this.txtPwd.sendKeys(pwd);
	}
	
	public void setConfirmPwd(String confirmpwd) {
		this.txtConfPwd.sendKeys(confirmpwd);
	}

	public void clickPrivacy() {
		this.chkPrivacyPolicy.click();
	}
	
	public void clickContinue() {
		this.btnContinue.click();
	}
	
	public String getconfirmationMsg() {
		try {
			return(confirmationMessage.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
}
