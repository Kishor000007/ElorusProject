package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SerachResultPage extends BasePage {

	public SerachResultPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//img[@title='iPhone']/..")
	public WebElement lnkprodName;

	@FindBy(id = "button-cart")
	public WebElement btnAddtoCart;

	@FindBy(xpath = "//div[text()='Success: You have added ']")
	public WebElement successMsg;

	public void clickImgLink() {
		this.lnkprodName.click();
	}

	public void clickAddToCartbtn() {
		this.btnAddtoCart.click();
	}

	public boolean isSuccessMsgDisplyed() {
		try {
			return (successMsg.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

}
