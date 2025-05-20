package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

//Central holder of everything to share across step definitions
//TestContextSetup → uses TestBase to create driver
//TestContextSetup → uses PageObjectManager to give you page objects (SignUp, Login, etc.)

public class TestContextSetup {
	
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	
	public TestContextSetup() throws IOException{
		testBase = new TestBase();
		WebDriver driver = testBase.getDriverInstance();
		System.out.println("driver is initialized " + driver);
		pageObjectManager = new PageObjectManager(driver);
	}

	public void closeDriver() {
		testBase.quitDriver();
		System.out.println("driver is closed");
	}
}
