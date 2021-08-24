package flipkart.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipkart.base.TestBase;
import flipkart.pages.HomePage;
import flipkart.pages.LoginPage;
import flipkart.pages.MobilePage;
import flipkart.pages.OppoRenoPage;
import flipkart.pages.OrderSummaryPage;


public class OrderSummaryPageTest extends TestBase{
	HomePage homePage;
	MobilePage mobilePage;
	LoginPage loginPage;
	OppoRenoPage oppoRenoPage;
	OrderSummaryPage orderSummaryPage;
	Logger log=Logger.getLogger(LoginPageTest.class);
	
@BeforeMethod
public void setup() throws IOException, InterruptedException {
	initialization();
	log.info("launching flipkart website");
	loginPage=new LoginPage();
    mobilePage=new MobilePage();
	homePage=loginPage.LoginProcess();
	log.info("logging into flipkart website");
	mobilePage=homePage.SearchProduct();
	log.info("searching oppo reno 6 in the searchbar");
	oppoRenoPage=mobilePage.SelectMobile();
	log.info("selecting oppo reno 6 ");
	orderSummaryPage=oppoRenoPage.BuyNow();
	log.info("clicking on the buynow button");
}
@Test(priority=0)
public void verifyOrderSummaryTextTest() {
	boolean flag=orderSummaryPage.verifyOrderSummaryText();
	Assert.assertTrue(flag);
	log.info("verifying order summary element in the page");
}
@Test(priority=1)
public void paymentTest() throws InterruptedException {
	orderSummaryPage.payment();
	log.warn("card credentials are incorrect");
}
@AfterMethod
public void browserClose() {
	driver.quit();
}


}
