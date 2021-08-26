package flipkart.pages;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import flipkart.base.TestBase;

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
 public HomePage LoginProcess() throws IOException  {
	 UserPhoneNo.sendKeys(map().get("UserMail"));
	 LoginPassword.sendKeys(map().get("LoginPassword"));
	 LoginSubmitButton.click();
	 return new HomePage();
 }
 
 
 public boolean ValidateLoginIcon() {
	 return LoginLogo.isDisplayed();
	 
 }
 
}
