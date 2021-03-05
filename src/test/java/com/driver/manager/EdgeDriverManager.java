/**
 * Driver manager class for Edge 
 */
package com.driver.manager;

import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author W_Dragon
 *
 */
public class EdgeDriverManager extends DriverManager {

	@Override
	protected void createWebDriver() {
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
	    System.setProperty("webdriver.edge.driver", "D:\\Work\\Selenium\\Driver\\Edge\\msedgedriver.exe");
		
		this.driver = new EdgeDriver();
	}

}
