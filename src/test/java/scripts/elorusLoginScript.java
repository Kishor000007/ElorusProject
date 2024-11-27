package scripts;

import org.testng.annotations.Test;

import generic.basetest;
import pages.initialisePages;

public class elorusLoginScript extends basetest {

	@Test
	public void elorusLogin_Script() {

		initialisePages pages = new initialisePages(driver);
		pages.elorusLogin.setUserName(data.getProperty("username"));
		pages.elorusLogin.setPassword(data.getProperty("password"));
		pages.elorusLogin.clickSignIn();
		actionUtil.ValidateTitle("Elorus");
	}
}
