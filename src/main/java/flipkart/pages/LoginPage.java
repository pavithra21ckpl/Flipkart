package flipkart.pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import flipkart.base.TestBase;
import flipkart.utilities.DataList;
public class LoginPage extends TestBase {
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
 WebElement UserPhoneNo;
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
 WebElement LoginPassword;
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
 WebElement LoginSubmitButton;
	@FindBy(xpath="//span[@class='_36KMOx']")
	 WebElement LoginLogo;
 public LoginPage() {
	 PageFactory.initElements(driver,this);
 }
 public HomePage LoginProcess()  {
	 UserPhoneNo.sendKeys("pavithra21ckpl@gmail.com");
	 LoginPassword.sendKeys("pavithra1");
	 LoginSubmitButton.click();
	 return new HomePage();
 }
 
 
 public boolean ValidateLoginIcon() {
	 return LoginLogo.isDisplayed();
	 
 }
 
}
