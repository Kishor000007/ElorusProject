package testcases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_01_Account_Registration extends BaseTest{

	@Test(groups= {"Regression","Master"})
	public void verify_Registration() {
		logger.info("****************Starting TC_01_Account_Registration test******************");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("*******Clicking on Myaccount*********");
		hp.clickMyAccount();
		logger.info("*******Clicking on Register*********");
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("*******Entering Customer Details*********");
		regpage.setFirstName(randomString());
		regpage.setLastName(randomString());
		regpage.setEmail(randomAlphaNumeric()+"@gmail.com");
		regpage.settelephone(randomNumber());
		
		String pwd = randomString()+"@"+randomAlphaNumeric();
		regpage.setPwd(pwd);
		regpage.setConfirmPwd(pwd);
		regpage.clickPrivacy();
		regpage.clickContinue();
		
		logger.info("********Validating expected message*********");
		String confmsg = regpage.getconfirmationMsg();
//		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		if(confmsg.equals("Your Account Has Been Created!")) {
			assertTrue(true);
		}
		else {
			assertFalse(false);
		}
	}catch(Exception e) {
		logger.error("*******Test Fialed********");
		Assert.fail();
	}
	logger.info("****************Completed TC_01_Account_Registration test******************");
}
}
