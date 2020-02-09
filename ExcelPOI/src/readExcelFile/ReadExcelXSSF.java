package readExcelFile;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelXSSF {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File src = new File("D:\\selenium_workspace\\ExcelPOI\\src\\readExcelFile\\ExportExcelx.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);

		String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println("data = "+data0);
		
		int rowcount = sheet1.getLastRowNum();
		
		System.out.println("Total rows is: "+rowcount);
		
		for(int i=0;i<(rowcount+1);i++)
		{
			String data = sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("data "+i+" : "+data);
		}
		
		wb.close();
	}

}
