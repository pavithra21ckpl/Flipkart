package flipkart.testcases;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

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
public class MobilePageTest extends TestBase {
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
}
@Test(priority=0)
public void VerifyMyAccountTest() {
	String mobilePageTitle=mobilePage.verifyMobilePageTitle();
	String expectedTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	Assert.assertEquals(mobilePageTitle,expectedTitle);
}
@Test(priority=1)
public void SearchProductTest() throws InterruptedException {

	oppoRenoPage=mobilePage.SelectMobile();
}
@AfterMethod
public void browserClose() {
	driver.quit();
}
}