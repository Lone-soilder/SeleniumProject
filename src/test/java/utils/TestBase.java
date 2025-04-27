package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//the factory that creates the WebDriver tool
//Creates and configures WebDriver

public class TestBase {
	
	WebDriver driver ; 
	
	public WebDriver WebDrivermanager() {
		if(driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.print("Driver created by testBase is "+driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://automationexercise.com/");
			
		}
		return driver;
	}
}
