package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//POM class for login page
public class elorusLogin_page2  {

	//identifies username
	@FindBy(id="id_email")
	private WebElement tbUsername;
	
	//identifies password
	@FindBy(name="password")
	private WebElement tbPassword;
	
	//identifies sign in
	@FindBy(xpath="//input[@value='SIGN IN']")
	private WebElement btnSignIN;
	
	//method to enter the username
	public void setUserName(String un) {
		this.tbUsername.sendKeys(un);
	}
	
	//method to enter the password
	public void setPassword(String pw) {
			this.tbPassword.sendKeys(pw);
		}
		
	//method to clicks on sign in
	public void clickSignIn() {
			this.btnSignIN.click();
		}
	
	//constructor
	public elorusLogin_page2(WebDriver driver) {
		//initialises webelements
		PageFactory.initElements(driver, this);
	}

}
