package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class TestBase {

	private static WebDriver driver;


	// Singleton pattern to ensure only one instance of WebDriver is created
	public WebDriver getDriver(String browserName) {
		System.out.println("getDriver is calling to browser name is "+ browserName);
		driver = WebDriverFactory.setUpDriver(browserName);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://automationexercise.com/");
		return driver; // Return the driver instance
	}

	public WebDriver getDriverInstance() {
		if (driver == null) {
			driver = getDriver("chrome");
		}
		return driver;
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}