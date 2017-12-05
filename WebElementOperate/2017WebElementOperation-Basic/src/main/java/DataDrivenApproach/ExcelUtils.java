package DataDrivenApproach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static Workbook ExcelWBook;
	private static Sheet ExcelSheet;
	private static Cell CELL;
	private static Row ROW;
	
	
	public void setExcelFile(String path, String sheetName) throws IOException{
		FileInputStream excelFile = new FileInputStream(path);
		ExcelWBook = new XSSFWorkbook(excelFile);
		ExcelSheet = ExcelWBook.getSheet(sheetName);
	}
	
	public String readExcelCell(int rowNum, int colNum) throws IOException{
		
		CELL = ExcelSheet.getRow(rowNum).getCell(colNum);
		String cellValue = CELL.getStringCellValue();
		return cellValue;
		
	}
	
	public void setExcelCell(int rowNum, int colNum, String cellValue, String filePath) throws IOException{
		ROW = ExcelSheet.getRow(rowNum);
		CELL = ROW.getCell(colNum, Row.RETURN_BLANK_AS_NULL);
		if(CELL == null){
			CELL = ROW.createCell(colNum);
			CELL.setCellValue(cellValue);
			}else{
				CELL.setCellValue(cellValue);
			}
		FileOutputStream fileOut = new FileOutputStream(filePath);
		ExcelWBook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		 
		
	}
	

}
