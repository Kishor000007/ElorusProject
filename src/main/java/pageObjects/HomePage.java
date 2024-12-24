package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[text()='My Account']")
	public WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	public WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	public WebElement lnkLogIn;
	
	@FindBy(name="search")
	public WebElement txtsearch;
	
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	public WebElement btnsearch;
	
	public void clickMyAccount() {
		this.lnkMyAccount.click();
	}
	
	public void clickRegister() {
		this.lnkRegister.click();	
	}
	
	public void clickLogin() {
		this.lnkLogIn.click();
	}
	
	public void enterProduct(String prod) {
		this.txtsearch.sendKeys(prod);
	}
	
	public void clicksearchbtn() {
		this.btnsearch.click();;
	}
}
