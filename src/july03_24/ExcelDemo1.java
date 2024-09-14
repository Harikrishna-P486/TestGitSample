package july03_24;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo1 {

	public static void main(String[] args) throws Throwable {
		FileInputStream input = new FileInputStream("D:/Sample - Superstore.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet ws = wb.getSheet("Orders");
		int rc = ws.getLastRowNum();
		System.out.println("No of Rows :: "+rc);
		XSSFRow row= ws.getRow(3);
		int cc = row.getLastCellNum();
		System.out.println("No of Columns :: "+cc);
	//	XSSFRow ship_mode = ws.getRow(12);
	//	XSSFCell c5 = row.getRow(12);
		XSSFCell c5 = row.getCell(5);
		
		String shipmode = ws.getRow(22).getCell(6).getStringCellValue();
		System.out.println(shipmode);
		
        


	}

}
