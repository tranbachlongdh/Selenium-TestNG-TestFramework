/**
 * 
 */
package com.excel.ultility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author W_Dragon
 *
 */
public class ExcelReader {
	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	
	/**
	 * Constructor for class: Read excel file and workSheet 
	 * @param Path the direct path the excel file
	 * @param SheetName name of sheet that will be read in excel file
	 * 
	 */
	public ExcelReader(String Path, String SheetName) throws Exception {
		   
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

	/**
	 * Getter for getting Excel workSheet
	 * @return XSSFSheet object
	 */
	public XSSFSheet getExcelWSheet() {
		return ExcelWSheet;
	}

	/**
	 * Getter for getting Excel workBook
	 * @return XSSFWorkbook object
	 */
	public XSSFWorkbook getExcelWBook() {
		return ExcelWBook;
	}
	
	/**
	 * Return number of row of workSheet
	 * @return number of row
	 */
	public int excel_get_rows() throws Exception {
   
		try {
			return ExcelWSheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			throw (e);
		}
	}
	
	
	/**
	 * Return number of column of workSheet
	 * @return number of column
	 */
	public int excel_get_cols() throws Exception {
   
		try {
			return ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			throw (e);
		}
	}
	
	
	/**
	 * Return the cell data if its data type is String
	 * @param cell
	 * @return (String) cell's value 
	 */
	private String getCellDataAsString(Cell cell) {
		return cell.getStringCellValue();
	}
	   
	
	/**
	 * Return the cell data if its data type is number 
	 * @param cell
	 * @return (double) cell's value
	 */
	private double getCellDataAsNumber(Cell cell) {
		return cell.getNumericCellValue();
	}
	
	/**
	 * Convert cell data to String and return it
	 * @param cell
	 * @return (String) cell's value
	 */
	public String getCellData(Cell cell) {
		
		try {
			if (cell.getCellType() == CellType.STRING) {
				return getCellDataAsString(cell);
			} else {
				return String.valueOf(getCellDataAsNumber(cell));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	
	/**
	 * Search for column that has the column name
	 * @param colName (String)
	 * @return index number of column that match column name
	 * 			return -1 if not found
	 * @throws Exception 
	 */
	private int searchForColName(String colName) throws Exception {
		int colNum = excel_get_cols();
		for (int i=0; i< colNum; i++) {
			if (getCellData(ExcelWSheet.getRow(0).getCell(i)).equalsIgnoreCase(colName)) {
				return i;
			}
		}
		return -1;
		
	}
	
	/**
	 * Return cell data of particular cell
	 * @param colName: (String)
	 * @param rowIndex: (int) index number of particular row
	 * @return Cell data (String)
	 * @throws Exception 
	 */
	public String getCellData(String colName, int rowIndex) throws Exception {
		String data = "";
		try {
			data = getCellData(ExcelWSheet.getRow(rowIndex).getCell(searchForColName(colName)));
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return data;
	}
	
//	public static void main(String[] args) throws Exception {
//		ExcelReader excel = new ExcelReader("D:\\Work\\eclipse-workspace\\TestingFramework\\src\\TestData.xlsx", "Sheet1");
//		System.out.print(excel.getCellData("Expected result", 3));
//		
//	}
	
	
	
	
	
	
	
	
	

}
