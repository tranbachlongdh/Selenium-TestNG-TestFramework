/**
 * Read excel file and return an 2-D String array
 */
package com.excel.ultilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author W_Dragon
 *
 */
public class ExcelUtils {
	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	
	//Constructor to connect to the Excel with sheetName and Path
	public ExcelUtils(String Path, String SheetName) throws Exception {
	   
		try {
			// Open the Excel file
	        FileInputStream ExcelFile = new FileInputStream(Path);
	         
	        // Access the required test data sheet
	        ExcelWBook = new XSSFWorkbook(ExcelFile);
	        ExcelWSheet = ExcelWBook.getSheet(SheetName);
	    } catch (Exception e) {
	    	throw (e);
	    }
	}
	
	//This method is to get the rowCount of the excel.
	public int excel_get_rows() throws Exception {
   
		try {
			return ExcelWSheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			throw (e);
		}
	}
	
	//This method is to get the colCount of the excel.
	public int excel_get_cols() throws Exception {
   
		try {
			return ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			throw (e);
		}
	}
	
	//This method to get the data and get the value as strings.
	private String getCellDataAsString(Cell cell) {
		return cell.getStringCellValue();
	}
	   
	//This method to get the data and get the value as number.
	private double getCellDataAsNumber(Cell cell) {
		return cell.getNumericCellValue();
	}
	
	public String[][] getCellData() throws Exception {
		int numRows = excel_get_rows();
		int numCols = excel_get_cols();
		
		String data[][] = new String[numRows-1][numCols];
		for(int i=1; i<numRows; i++) {
			Row r = ExcelWSheet.getRow(i);
			for(int j=0; j<numCols; j++) {
				Cell c = r.getCell(j);
				try {
				if (c.getCellType() == CellType.STRING) {
					data[i - 1][j] = getCellDataAsString(c);
				} else {
					data[i - 1][j] = String.valueOf(getCellDataAsNumber(c));
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
//	public static void main(String[] args) throws Exception {
//		ExcelUtils excel = new ExcelUtils("D:\\Work\\eclipse-workspace\\TestingFramework\\src\\TestData.xlsx", "Sheet1");
//		System.out.println("The Row count is " + excel.getCellData().length);
//		System.out.println("The Cols count is " + excel.getCellData()[0].length);
//		
//		for (int i = 0; i < excel.getCellData().length; i++) {
//			for(int j= 0; j< excel.getCellData()[0].length; j++) {
//				System.out.print(excel.getCellData()[i][j]+ " - ");
//			}
//			System.out.println("");
//		}
//
//	}
	
	
}
