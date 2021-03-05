/**
 * Driver manager class for IE
 */
package com.driver.manager;

import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author W_Dragon
 *
 */
public class IEDriverManager extends DriverManager {

	@Override
	protected void createWebDriver() {
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
	    System.setProperty("webdriver.ie.driver", "D:\\Work\\Selenium\\Driver\\IE\\IEDriverServer.exe");
		
		// Define personal IE options here
		this.driver = new InternetExplorerDriver();
	}

}
