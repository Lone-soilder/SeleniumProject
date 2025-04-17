package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {

	WebDriver driver;
	public SignUp(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By signUpLevel = By.xpath("//h2[text() = 'New User Signup!']");
	By username = By.xpath("//input[@data-qa = 'signup-name']");
	By email = By.xpath("//input[@data-qa = 'signup-email']");
	By signUpBtn = By.xpath("//button[@data-qa = 'signup-button']");
	
	public void findSignUpHeader() {
		driver.findElement(signUpLevel).getText();
	}
	
	public void fillUserName(String name) {
		driver.findElement(username).sendKeys(name);
	}
	
	public void fillEmail(String email) {
		driver.findElement(this.email).sendKeys(email);
	}
	
	public void clickSignUp() {
		driver.findElement(signUpBtn).click();
	}
	
	public String getSignUpPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getSignUpLevel() {
		return driver.findElement(signUpLevel).getText();
	}

}
