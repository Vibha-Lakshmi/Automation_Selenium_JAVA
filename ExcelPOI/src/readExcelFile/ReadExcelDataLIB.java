package readExcelFile;

public class ReadExcelDataLIB {

	public static void main(String[] args) {
		ReadLIB excel = new ReadLIB("D:\\selenium_workspace\\ExcelPOI\\src\\readExcelFile\\ExportExcelx.xlsx");
		System.out.println(excel.getdata(0, 0, 0));
	}
}
