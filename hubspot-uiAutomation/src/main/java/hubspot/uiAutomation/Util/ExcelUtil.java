package hubspot.uiAutomation.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private static File f;
	private static FileInputStream fis;
	private static XSSFWorkbook wb;
	private static XSSFSheet wbSheet;
	private static XSSFRow row;
	private static XSSFCell cell;

	static {
		
		try {
			f = new File(System.getProperty("user.dir") + "/TestData.xlsx");
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDataFromExcel(String dataSheetName, String colName, int rowIndex) throws Exception {
		boolean colNameFound = false;
		int colIndex = 0;
		//String cellvalue;
		wbSheet = wb.getSheet(dataSheetName);
		row = wbSheet.getRow(0);

		for (int i = 0; i < row.getLastCellNum(); i++) {
			cell = row.getCell(i);
			//cellvalue = cell.getStringCellValue();
			if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
				colIndex = i;
				colNameFound = true;
				break;
			}
		}

		if (colNameFound) {
			row = wbSheet.getRow(rowIndex);
			cell = row.getCell(colIndex);
			return cell.getStringCellValue();

		} else {
			throw new Exception("Unable to locate column name..");
		}
	}
	
	/**
	public static void main(String[] args) throws Exception {
		System.out.println(getDataFromExcel("Login","EmailId/",1));
	}
	**/

}
