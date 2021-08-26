package flipkart.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import flipkart.utilities.WebEventListener;
public class TestBase {
	public static WebDriver driver;
	public static Properties obj;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
public TestBase() {
	
}
	public static void initialization() throws IOException {
		Properties obj = new Properties(); 
		FileInputStream objfile = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Test\\src\\main\\java\\flipkart\\config\\config.properties");
		obj.load(objfile);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		//code to invoke event firing webdriver
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(obj.getProperty("url"));
	}
	public Map<String, String> map() throws IOException {
		File file = new File("C:\\Users\\Administrator\\eclipse-workspace\\Test\\Book 10 (1).xlsx");
		  FileInputStream fis = new FileInputStream(file);
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sheet = wb.getSheetAt(0);
		  int lastCellNum = sheet.getRow(0).getLastCellNum();
		  Map<String, String> datamap = new HashMap<String, String>();
		  for (int i = 0; i< lastCellNum; i++) {
			  String key=sheet.getRow(0).getCell(i).getStringCellValue();
			  String value=sheet.getRow(1).getCell(i).getStringCellValue();
			  datamap.put(key, value);
		  }
		return datamap;
	  }
}
