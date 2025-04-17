package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	WebDriver driver ; 
	
	public WebDriver WebDrivermanager() {
		if(driver == null) {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://automationexercise.com/");
		return driver;
	}
}
