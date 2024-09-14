package july03_24;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;

public class ExcelDemo {

	public static void main(String[] args) throws Throwable {
		FileInputStream input = new FileInputStream("D:/EmployeeData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet= workbook.getSheet("EmployeeSheet");
		XSSFRow row= sheet.getRow(2);
		//count no of rows present in sheet
		int rc = sheet.getLastRowNum();
		Reporter.log("No of rows :: "+rc ,true);
	    int cc = row.getLastCellNum();
	    Reporter.log("No of columns :: "+cc ,true);
	    input.close();
	    workbook.close();
	    
	    
	}

}
