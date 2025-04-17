package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

	WebDriver driver;
	
	public Home(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By signUpBtn = By.xpath("//*[text()=' Signup / Login']");
	
	public String getUrlHomePage() {
		return driver.getCurrentUrl();
	}
	public void clickOnSignup() {
		driver.findElement(signUpBtn).click();
	}
	
}
