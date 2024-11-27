package scripts;

import org.testng.annotations.Test;

import dataProviders.elorusDataProvider;
import generic.basetest;
import pages.initialisePages;

public class elorusAddContact_Script extends basetest {

	@Test(dataProviderClass = elorusDataProvider.class,dataProvider = "elorusAddContactData")
	public void elorusAddContactScript(String un,String pwd,String fn,String ln,String comp,String prof) {

		initialisePages pages=new initialisePages(driver);
		
		pages.elorusLogin.setUserName(un);
		
		pages.elorusLogin.setPassword(pwd);
		
		pages.elorusLogin.clickSignIn();
		
		pages.elorusHome.clickContact();
		
		pages.elorusContact.clickAdd();
		
		pages.elorusAddContact.firstName(fn);
		
		pages.elorusAddContact.lastname(ln);
		
		pages.elorusAddContact.company(comp);
		
		pages.elorusAddContact.profession(prof);
		
		pages.elorusAddContact.clickSave();
			   
	}
}
