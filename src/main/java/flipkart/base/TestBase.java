package flipkart.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestBase {
	public static WebDriver driver;
	public static Properties obj;
public TestBase() {
	
}
	public static void initialization() throws IOException {
		Properties obj = new Properties(); 
		FileInputStream objfile = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Test\\src\\main\\java\\flipkart\\config\\config.properties");
		obj.load(objfile);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(obj.getProperty("url"));
	}
}
