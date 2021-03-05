/**
 * 
 */
package com.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.driver.manager.*;
import com.excel.ultility.ExcelUtils;
import com.page_objects.Page_objects_perc_calc;

/**
 * @author W_Dragon
 *
 */
public class PercentCalculator {
	DriverManager driverManager = null;
	WebDriver driver = null;
	
	@Test (dataProvider = "percentCalData")
	public void testPercentCalculator(String driverType, String num1, String num2, String expValue) {
		String path = "http://www.calculator.net";
		driverManager = DriverManagerFactory.getDriverManager(DriverType.valueOf(driverType));
		driver = driverManager.getWebDriver();
		driver.manage().window().maximize();
		
		// Access to the URL path
		driver.get(path);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click to the link to Percent calculator
		Page_objects_perc_calc.lnk_percent_calc(driver).click();
		// Input the 1st number
		Page_objects_perc_calc.txt_num_1(driver).sendKeys(num1);
		// Input the 2nd number
		Page_objects_perc_calc.txt_num_2(driver).sendKeys(num2);
		// Press calculate button
		Page_objects_perc_calc.btn_calc(driver).click();
		// Read actual result after page load
		String actualResult = Page_objects_perc_calc.web_result(driver).getText();
		// Compare actual result with expected Result
		Assert.assertEquals(Double.parseDouble(actualResult), Double.parseDouble(expValue));
		
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
	}
	@AfterMethod
	public void afterMethod() {
		driverManager.quitWebDriver();
	}
	
	@DataProvider
	public String[][] percentCalData() throws Exception{
		ExcelUtils excel = new ExcelUtils("D:\\Work\\eclipse-workspace\\SeleniumTestNG\\src\\test\\java\\com\\test\\ultility\\testdata1.xlsx", "Sheet1");
		return excel.getCellData();
	}
	

}
