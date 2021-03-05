/**
 * Driver manager class for Chrome
 */
package com.driver.manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author W_Dragon
 *
 */
public class ChromeDriverManager extends DriverManager {

	@Override
	protected void createWebDriver() {
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
	    System.setProperty("webdriver.chrome.driver", "D:\\Work\\Selenium\\Driver\\Chrome\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// Define personal Chrome options here
		this.driver = new ChromeDriver(options);
		
	}

}
