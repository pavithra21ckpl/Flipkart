package flipkart.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import flipkart.base.TestBase;
import flipkart.pages.HomePage;
import flipkart.pages.LoginPage;
import flipkart.pages.MobilePage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	MobilePage mobilePage;
	LoginPage loginPage;
@BeforeMethod
public void setup() throws IOException {
	initialization();
	loginPage=new LoginPage();
	homePage=loginPage.LoginProcess();
}
@Test(priority=0)
public void VerifyMyAccountTest() {
	boolean flag=homePage.VerifyMyAccount();
	Assert.assertTrue(flag);
}
@Test(priority=1)
public void SearchProductTest() throws InterruptedException, IOException {
	mobilePage=homePage.SearchProduct();
}
@AfterMethod
public void browserClose() {
	driver.quit();
}
}
