package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//POM class for home page
public class elorusHome_page2 {

	    //identifies invoices
	    @FindBy(xpath="//a[@title='Invoices']")
		private WebElement lnkInvoices;
	    
	    //identifies expenses
	    @FindBy(xpath="//a[@title='Expenses']")
	    private WebElement lnkExpenses;
		
		 //identifies projects
	    @FindBy(xpath="//a[@title='Projects']")
	    private WebElement lnkProjects;
		
		 //identifies time
	    @FindBy(xpath="//a[@title='Time']")
	    private WebElement lnkTime;
		
		 //identifies contact
	    @FindBy(xpath="//a[@title='Contacts']")
	    private WebElement lnkContact;
		
		 //identifies estimates
	    @FindBy(xpath="//a[@title='Estimates']")
	    private WebElement lnkEstimates;
		
		 //identifies usermenu
	    @FindBy(xpath="//a[@title='User menu']")
	    private WebElement btnUserMenu;
		
		 //identifies logout
	    @FindBy(xpath="//a[text()='Logout']")
	    private WebElement btnLogout;
	    
	    //constructor
	    public elorusHome_page2(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	    
	    //click on invoices
	    public void clickInvoices() {
	    	this.lnkInvoices.click();
	    }
	    
	    //click on expenses
	    public void clickExpenses() {
	    	this.lnkExpenses.click();
	    }
	    
	    //click on projects
	    public void clickProject() {
	    	this.lnkProjects.click();
	    }
	    
	    //click on time
	    public void clickTime() {
	    	this.lnkTime.click();
	    }
	    
	    //click on contact
	    public void clickContact() {
	    	this.lnkContact.click();
	    }
	    
	    //click on estimates
	    public void clickEstimates() {
	    	this.lnkEstimates.click();
	    }
	    
	    //click on user menu
	    public void clickUserMenu() {
	    	this.btnUserMenu.click();
	    }
	    
	    //click on logout
	    public void clickLogOut() {
	    	this.btnLogout.click();
	    }
		
		
}
