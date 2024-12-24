package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_02_Login extends BaseTest{

	@Test(groups= {"Sanity","Master"})
	public void verify_login() {
		logger.info("*********Starting TC_02_Login test***********");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		logger.info("*******Entering customer login details*******");
		lp.enterEmail(data.getProperty("email"));
		lp.enterPassword(data.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage mp=new MyAccountPage(driver);
		boolean targetpage = mp.isMyAccountPageExists();
		
	    Assert.assertTrue(targetpage);
		}
		catch(Exception e) {
			Assert.fail();
			logger.error("******Test failed*******");
		}
		
		logger.info("*********Completed TC_02_Login test***********");
	}
}
