package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//POM class for add contact page
public class elorusAddContact_page2 {

	 //identifies firstname
    @FindBy(name="first_name")
	private WebElement tbFirstName;
    
    //identifies lastname
    @FindBy(name="last_name")
    private WebElement tbLastName;
    
    //identifies company
    @FindBy(name="company")
    private WebElement tbCompany;
    
    //identifies profession
    @FindBy(name="profession")
    private WebElement tbProfession;
    
    //identifies save button
    @FindBy(xpath="//span[text()='Save']/parent::a")
    private WebElement btnSave;
    
    public elorusAddContact_page2(WebDriver driver) {
		//initialises webelements
		PageFactory.initElements(driver, this);
	}
    
    public void firstName(String fn) {
    	this.tbFirstName.sendKeys(fn);
    }
    
    public void lastname(String ln) {
    	this.tbLastName.sendKeys(ln);
    }
    
    public void company(String cmp) {
    	this.tbCompany.sendKeys(cmp);
    }
    
    public void profession(String prof) {
    	this.tbProfession.sendKeys(prof);
    }
    
    public void clickSave() {
    	this.btnSave.click();
    }
    
    
}
