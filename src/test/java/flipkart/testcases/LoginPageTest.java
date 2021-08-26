package flipkart.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import flipkart.base.TestBase;
import flipkart.pages.HomePage;
import flipkart.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Logger log=Logger.getLogger(LoginPageTest.class);
	
@BeforeMethod
public void setup() throws IOException {
	initialization();
	log.info("*****Flipkart site is launching*******");
	loginPage=new LoginPage();
}
@Test(priority=0)
public void validateLoginTest() {
	boolean flag=loginPage.ValidateLoginIcon();
	Assert.assertTrue(flag);
	log.info("*****checked login icon*******");
}
@Test(priority=1)
public void loginProcessTest() throws IOException{
	homePage=loginPage.LoginProcess();
	log.info("*****entering login credentials*******");
}
@AfterMethod
public void browserClose() {
	driver.quit();
}
}
