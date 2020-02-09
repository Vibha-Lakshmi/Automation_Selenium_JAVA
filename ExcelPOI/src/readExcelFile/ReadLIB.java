package readExcelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadLIB {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public ReadLIB(String excelpath) {
		try {
			File src = new File(excelpath);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception");
			e.printStackTrace();
		}

	}

	public String getdata(int sheetNumber, int row, int column) {
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
}
