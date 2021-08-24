package flipkart.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import flipkart.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//input[@class='_3704LK']")
	 WebElement SearchBar;
	@FindBy(xpath="//button[@type='submit']")
	 WebElement SearchButton;
	@FindBy(xpath="//div[@class='exehdJ']")
	 WebElement MyAccount ;
	
public HomePage() {
	PageFactory.initElements(driver,this);

}
public  boolean VerifyMyAccount() {
	return MyAccount.isDisplayed();
}
public  MobilePage SearchProduct() throws InterruptedException {
	Thread.sleep(3000);
	SearchBar.sendKeys("oppo reno 6");
	SearchButton.click();
	return new MobilePage();
}
}
