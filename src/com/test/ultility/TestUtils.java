/**
 * 
 */
package com.test.ultility;

import java.util.ArrayList;

import com.excel.ultilities.ExcelReader;

/**
 * @author W_Dragon
 *
 */
public class TestUtils {
	private static ExcelReader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() throws Exception {
		
		ArrayList<Object[]> myData = new ArrayList<>();
		
		reader = new ExcelReader("D:\\Work\\eclipse-workspace\\TestingFramework\\src\\TestData.xlsx", "Sheet1");
		
		for (int rowId=1; rowId < reader.excel_get_rows(); rowId++) {
			
			String driverType = reader.getCellData("Driver_Type", rowId);
			String URL = reader.getCellData("URL", rowId);
			String expResult = reader.getCellData("Expected result", rowId);
			
			myData.add(new Object[]{driverType, URL, expResult});
			
		}
		
		return myData;
		
	}

}
