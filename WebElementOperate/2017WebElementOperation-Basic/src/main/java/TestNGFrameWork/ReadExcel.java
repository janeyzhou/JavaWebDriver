package TestNGFrameWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
		
	public static Object[][] getAccountArray(String filePath, String sheetName) throws IOException{
		
		FileInputStream excelFile = new FileInputStream(filePath);
		XSSFWorkbook excelWorkBook = new XSSFWorkbook(excelFile);
		XSSFSheet excelSheet = excelWorkBook.getSheet(sheetName);
		
		int colCount = 2;
		int rowCount = excelSheet.getLastRowNum()+1;
		String[][] excelArray = new String[rowCount][colCount];
 		int arrayi = 0;
		for (int i = 0; i< rowCount; i++, arrayi++){
			int arrayj = 0;
			for (int j = 0; j< colCount; j++, arrayj++){
				excelArray[arrayi][arrayj] = excelSheet.getRow(i).getCell(j).toString();
				System.out.println(excelArray[arrayi][arrayj]);
				System.out.println(rowCount);
			}
		}
		
		return excelArray;
		
	}

}
