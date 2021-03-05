/**
 * Driver manager class for Firefox 
 */

package com.driver.manager;

/**
 * @author W_Dragon
 *
 */
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager extends DriverManager {

	@SuppressWarnings("deprecation")
	@Override
	protected void createWebDriver() {
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
		System.setProperty("webdriver.gecko.driver", "D:\\Work\\Selenium\\Driver\\Firefox\\geckodriver.exe");
		
		// Create a capabilities instance
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("marionette", true);
		
		// assign the driver to a newly created FirefoxDriver with capabilities
		this.driver = new FirefoxDriver(capabilities);
	}

}
