package com.test;

import org.testng.annotations.Test;

import com.driver.manager.*;
import com.excel.ultility.ExcelUtils;
import com.test.ultility.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AccessToURL {
	DriverManager driverManager = null;
	WebDriver driver = null;
	
	
  @Test (dataProvider = "getExcelData2")
  public void navigate(String driverType, String path, String exp_result) {
	  
	  driverManager = DriverManagerFactory.getDriverManager(DriverType.valueOf(driverType));
	  driver = driverManager.getWebDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.get(path);
	  Assert.assertEquals(exp_result, driver.getTitle());
  }
  
  @DataProvider (name = "navigateToURL1")
  public Object [] [] case1 ()
  {
//    Object [] [] data = new Object [2] [3];
//    
//    data [0] [0] = "http://www.google.com.vn";    data [0] [1] = "Google";    
//    data [1] [0] = "http://www.calculator.net";      data [1] [1] = "Calculator.net: Free Online Calculators - Math, Fitness, Finance, Science";
     
    return new Object[][] {
		   { "CHROME", "http://www.google.com.vn", "Google"},
		   { "FIREFOX", "http://www.google.com.vn", "Google"},
		   { "CHROME", "http://www.calculator.net", "Calculator.net: Free Online Calculators - Math, Fitness, Finance, Science"},
		   { "FIREFOX", "http://www.calculator.net", "Calculator.net: Free Online Calculators - Math, Fitness, Finance, Science"},
		 };
    
//    return data;
  }
  
  @DataProvider (name = "navigateToURL2")
  public Object [] [] case2 ()
  {
    Object [] [] data = new Object [2] [3];
    
    data [0] [0] = "http://www.google.com.vn";    data [0] [1] = "Google";    
    data [1] [0] = "http://www.calculator.net";      data [1] [1] = "Calculator.net: Free Online Calculators - Math, Fitness, Finance, Science";
 
    return data;
  }
  
  @DataProvider (name = "getExcelData1")
  public String[][] getExcelData1() throws Exception {
	  ExcelUtils excel = new ExcelUtils("D:\\Work\\eclipse-workspace\\SeleniumTestNG\\src\\test\\java\\com\\test\\ultility\\TestData.xlsx", "Sheet1");
	  return excel.getCellData();
  }
  
  @DataProvider (name = "getExcelData2")
  public Iterator<Object[]> getExcelData2() throws Exception {
	  return TestUtils.getDataFromExcel().iterator();
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
//	  driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
//	  driver = driverManager.getWebDriver();
//	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
 

  @AfterMethod
  public void afterMethod() {
	  driverManager.quitWebDriver();
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
