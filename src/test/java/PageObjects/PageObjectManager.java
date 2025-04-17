package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	WebDriver driver;
	Home homepage;
	SignUp signUpPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public Home getHomePage() {
		Home homePage = new Home(driver);
		return homePage;
	}
	
	public SignUp getSignUpPage() {
		SignUp signUp = new SignUp(driver);
		return signUp;
	}
}
