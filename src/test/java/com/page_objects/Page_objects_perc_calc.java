/**
 * 
 */
package com.page_objects;

import org.openqa.selenium.*;

/**
 * @author W_Dragon
 *
 */
public class Page_objects_perc_calc {
		private static WebElement element = null;
	 
		// Math Calc Link
		public static WebElement lnk_math_calc(WebDriver driver) {
			element = driver.findElement(By.xpath(".//*[@id = 'contentout']/table/tbody/tr/td[3]/div[3]/a"));
			return element;
		}
		
		//Percentage Calc Link
		public static WebElement lnk_percent_calc(WebDriver driver) {
			element = driver.findElement(By.xpath(".//*[@id = 'hl3']/li[3]/a"));
			return element;
		}
		
		//Number 1 Text Box
		public static WebElement txt_num_1(WebDriver driver) {
			element = driver.findElement(By.id("cpar1"));
			return element;
		}
		
		//Number 2 Text Box	
		public static WebElement txt_num_2(WebDriver driver) {
		     element = driver.findElement(By.id("cpar2"));
		     return element;
		}
		
		//Calculate Button	
		public static WebElement btn_calc(WebDriver driver) {
			element =
	         driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/input[2]"));
			return element;
		}	
		
		//Clear Button	
		public static WebElement btn_clr(WebDriver driver) {
			element =
	         driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/img"));
			return element;
		}
		
		// Result	
		public static WebElement web_result(WebDriver driver) {
			element =
					driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b"));
			return element;
		}	
}
