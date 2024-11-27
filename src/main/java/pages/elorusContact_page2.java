package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//POM class for contact page
public class elorusContact_page2 {

	 //identifies add
    @FindBy(xpath="//span[text()='Add']/parent::a")
	private WebElement btnAdd;
    
	 //identifies add
    @FindBy(xpath="//span[text()='Bulk import']/parent::a")
	private WebElement btnBlkImport;
    
    //constructor
    public elorusContact_page2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    public void clickAdd() {
    	this.btnAdd.click();
    }
    
    public void clickBulkImport() {
    	this.btnBlkImport.click();
    }
}
