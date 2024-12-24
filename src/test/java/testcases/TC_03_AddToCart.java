package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pageObjects.HomePage;
import pageObjects.SerachResultPage;

public class TC_03_AddToCart extends BaseTest {

	@Test(groups= {"Regression"})
	public void verify_AddToCart() {
		logger.info("*********Starting TC_03_AddToCart test***********");
		try {
		HomePage hp=new HomePage(driver);
		hp.enterProduct("iphone");
		Thread.sleep(3000);
		hp.clicksearchbtn();
		
		SerachResultPage sp=new SerachResultPage(driver);
		sp.clickImgLink();
		sp.clickAddToCartbtn();
		boolean expmsg = sp.isSuccessMsgDisplyed();
		Assert.assertTrue(expmsg);
	}
	 catch(Exception e) {
		 Assert.fail();
		 logger.error("******Test failed*******");
	 }
		logger.info("*********Completed TC_03_AddToCart test***********");
}
}
