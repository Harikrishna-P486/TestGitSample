package july03_24;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormatCell {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream("D:/Book1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws= wb.getSheetAt(0);
		int rc = ws.getLastRowNum();
		System.out.println("No of rows: "+rc);
		
		for(int i=1;i<=rc;i++) {
		//ws.getRow(i).createCell(4).setCellValue("Pass");
		//ws.getRow(i).getCell(4).setCellValue("Fail");
		ws.getRow(i).getCell(4).setCellValue("Blocked");	
		 XSSFCellStyle style =wb.createCellStyle();
		  XSSFFont font = wb.createFont();
		  //colour to green
		//font.setColor(IndexedColors.GREEN.getIndex());
		//  font.setColor(IndexedColors.RED.getIndex());
		  font.setColor(IndexedColors.BLUE.getIndex());
		  //bold the text 
		  font.setBold(true);
		  style.setFont(font);
		  ws.getRow(i).getCell(4).setCellStyle(style);
		}
		fi.close();
		
		FileOutputStream fo = new FileOutputStream("D:/Books1Reports.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

	}

}
