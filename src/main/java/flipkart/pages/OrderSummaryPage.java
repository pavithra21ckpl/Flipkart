package flipkart.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipkart.base.TestBase;

public class OrderSummaryPage extends TestBase {
	@FindBy(xpath="//button[@class='_2KpZ6l _1seccl _3AWRsL']")
	 WebElement ContinueButton;
	@FindBy(xpath="//span[@class='_1aULyb']")
	 WebElement OrderSummaryText;
    @FindBy(xpath="//label[@for='CREDIT']")
    WebElement ChooseCard;
    @FindBy(xpath="//input[@type='text']")
    WebElement CardNumber;
    @FindBy(xpath="//button[@class='_2KpZ6l _2nejCf _3AWRsL']")
    WebElement PayNowButton;
    @FindBy(xpath="//span[@class='_2XN54t']")
    WebElement InvalidMessage;
public OrderSummaryPage() {
	
	PageFactory.initElements(driver,this);	
}
public void payment() throws InterruptedException, IOException {
	ContinueButton.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)", "");
	
	Thread.sleep(3000);
	ChooseCard.click();
	CardNumber.sendKeys(map().get("CardNumber"));
	PayNowButton.click();
	String msg=InvalidMessage.getText();
	System.out.println(msg);
	
	
}

public boolean verifyOrderSummaryText() {
	return OrderSummaryText.isDisplayed();
}

	

}

