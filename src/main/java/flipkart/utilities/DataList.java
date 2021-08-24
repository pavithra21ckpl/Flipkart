package flipkart.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import flipkart.base.TestBase;
public class DataList extends TestBase{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	public static Map<String, String> map() throws IOException {
		File file = new File("C:\\Users\\Administrator\\eclipse-workspace\\Test\\Book (1).xlsx");
		  FileInputStream fis = new FileInputStream(file);
		  wb = new XSSFWorkbook(fis);
		  sheet = wb.getSheetAt(0);
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

