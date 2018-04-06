package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil {
	
	Workbook wb;
	public ExcelFileUtil() throws Throwable, Throwable, IOException {
		FileInputStream fis = new FileInputStream("D:\\Testing\\HybridFrameWork_CRM\\Banking\\InputData\\TestData.xlsx");
		wb=WorkbookFactory.create(fis);
	}
	
	public int rowCount(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
		
	}
	
	public int colCount(String sheetName, int rowNum) {
		return wb.getSheet(sheetName).getRow(rowNum).getLastCellNum();
	}
	
	public String getData(String sheetName, int rowNum, int colNum) {
		String data = "";
		if(wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getCellType()==Cell.CELL_TYPE_NUMERIC) {
	        int cellData = (int) wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue();
			data = String.valueOf(cellData);
		} else {
			data = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		return data;
	}
	
	public void setData(String sheetName, int rowNum, int colNum, String data) throws Throwable {
		
		wb.getSheet(sheetName).getRow(rowNum).createCell(colNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(new File("D:\\Testing\\HybridFrameWork_CRM\\Banking\\OutputData\\OutputTestData.xlsx"));
	    wb.write(fos);
	    fos.close();
	    fos.flush();
		
	}

}
