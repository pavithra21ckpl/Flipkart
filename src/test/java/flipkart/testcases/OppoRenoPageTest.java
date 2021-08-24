package flipkart.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import flipkart.base.TestBase;
import flipkart.pages.HomePage;
import flipkart.pages.LoginPage;
import flipkart.pages.MobilePage;
import flipkart.pages.OppoRenoPage;


public class OppoRenoPageTest extends TestBase{
	HomePage homePage;
	MobilePage mobilePage;
	LoginPage loginPage;
	OppoRenoPage oppoRenoPage;
	
@BeforeMethod
public void setup() throws IOException, InterruptedException {
	initialization();
	loginPage=new LoginPage();
    mobilePage=new MobilePage();
	homePage=loginPage.LoginProcess();
	mobilePage=homePage.SearchProduct();
	oppoRenoPage=mobilePage.SelectMobile();
	
}
@Test(priority=0)
public void VerifyAddToCartButtonTest() {
	boolean flag=oppoRenoPage.VerifyAddToCartButton();
	Assert.assertTrue(flag);
}
@Test(priority=1)
public void SearchProductTest() {
	oppoRenoPage.BuyNow();
}
@AfterMethod
public void browserClose() {
	driver.quit();
}


}
