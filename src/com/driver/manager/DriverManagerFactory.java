/**
 * To create instance for each webDriver
 */
package com.driver.manager;


/**
 * @author W_Dragon
 * To create instance for each webDriver
 */
public class DriverManagerFactory {
	public static DriverManager getDriverManager(DriverType type) {
		DriverManager driverManager = null;
		
		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		case EDGE:
			driverManager = new EdgeDriverManager();
			break;
		// More browsers here
		default:
			driverManager = new IEDriverManager();
			
		}
		return driverManager;
		
	}
}
