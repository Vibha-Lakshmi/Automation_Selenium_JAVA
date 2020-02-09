package readExcelFile;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {
	static String uname;
	static String pwd;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		 * File src = new
		 * File("D:\\selenium_workspace\\ExcelPOI\\src\\readExcelFile\\ExportExcel.xls")
		 * ;
		 * 
		 * FileInputStream fis = new FileInputStream(src);
		 * 
		 * HSSFWorkbook wb = new HSSFWorkbook(fis);
		 * 
		 * HSSFSheet sheet1 = wb.getSheetAt(0);
		 * 
		 * String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		 * 
		 * System.out.println("data = "+data0);
		 * 
		 * wb.close();
		 */
		File src = new File("D:\\selenium_workspace\\ExcelPOI\\spreadsheets\\phonebook.xlsx");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = wb.getSheetAt(0);

		 uname = sheet1.getRow(1).getCell(0).getStringCellValue();
		
		 pwd = sheet1.getRow(1).getCell(1).getStringCellValue();


		System.out.println("data = " + uname+"..."+pwd);

		wb.close();

	}

}
