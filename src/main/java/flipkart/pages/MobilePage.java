package flipkart.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipkart.base.TestBase;

public class MobilePage extends TestBase{
@FindBy(xpath="//div[@class='_2kHMtA']")
WebElement MobileImage;

public MobilePage() {
	
PageFactory.initElements(driver,this);	
}
public OppoRenoPage SelectMobile() {
	 MobileImage.click();
	 String MainWindow=driver.getWindowHandle();	
		Set<String> s1=driver.getWindowHandles();		
	    Iterator<String> i1=s1.iterator();		
	    		
	    while(i1.hasNext())			
	    {		
	        String ChildWindow=i1.next();		
	        		
	        if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	        {    		
	                driver.switchTo().window(ChildWindow);	
	                
	        }		
	    }		
	 return new OppoRenoPage();
}
public String verifyMobilePageTitle() {
	return driver.getTitle();
}
}
