package july03_24;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo1_AlternateMethod {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream("D:/Book1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		int rc=ws.getLastRowNum();
		System.out.println("No of rows: "+rc);
	    XSSFRow row = ws.getRow(3);
	    int cc = row.getLastCellNum();
	    System.out.println("No of cells: "+cc);
	    String fname = ws.getRow(5).getCell(0).getStringCellValue();
	    String mname = ws.getRow(10).getCell(1).getStringCellValue();
	    String lname = ws.getRow(13).getCell(2).getStringCellValue();
	   int eid= (int) ws.getRow(9).getCell(3).getNumericCellValue();
	   
	   System.out.println(fname+"      "+mname+"      "+lname+"        "+eid);
	   fi.close();
	   wb.close();
	}

}
