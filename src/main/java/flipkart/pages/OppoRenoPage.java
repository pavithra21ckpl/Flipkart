package flipkart.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipkart.base.TestBase;

public class OppoRenoPage extends TestBase{
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
	 WebElement BuyNowButton;
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	 WebElement AddToCartButton ;

public OppoRenoPage() {
	
	PageFactory.initElements(driver,this);	
}
public OrderSummaryPage BuyNow() {
	 BuyNowButton.click();
	 return new OrderSummaryPage();
	
}
public  boolean VerifyAddToCartButton(){
	return AddToCartButton.isDisplayed();
}
}