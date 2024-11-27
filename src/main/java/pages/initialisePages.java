package pages;

import org.openqa.selenium.WebDriver;

public class initialisePages {

	public elorusLogin_page2 elorusLogin;
	public elorusHome_page2 elorusHome;
	public elorusContact_page2 elorusContact;
	public elorusAddContact_page2 elorusAddContact;
	
	public initialisePages(WebDriver driver) {
		this.elorusLogin=new elorusLogin_page2(driver);
		this.elorusHome=new elorusHome_page2(driver);
		this.elorusContact=new elorusContact_page2(driver);
		this.elorusAddContact=new elorusAddContact_page2(driver);
	}
}
