/**
 * 
 */
package com.driver.manager;

import org.openqa.selenium.WebDriver;

/**
 * @author W_Dragon
 *
 */
public abstract class DriverManager {
	protected WebDriver driver;
	protected abstract void createWebDriver();
	public void quitWebDriver() {
		if (null!=this.driver) {
			driver.quit();
			driver = null;
		} else {
			// do Nothing
		}
	}
	
	public WebDriver getWebDriver() {
		if (null == this.driver) {
			createWebDriver();
		} else {
			// do Nothing
		}
		return driver;
	}
	
	
}
