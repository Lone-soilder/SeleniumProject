package PageObjects;

import org.openqa.selenium.WebDriver;

//this class carrying everything you need for a test (driver + page manager)

public class PageObjectManager {
	
	WebDriver driver;
	Home homepage;
	SignUp signUpPage;
	Login LoginPage;
	AccountCreated accountCreated;
	DeleteAccount deleteAccount;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public Home getHomePage() {
		Home homePage = new Home(driver);
		return homePage;
	}
	
	public Login getLoginPage() {
		Login loginPage = new Login(driver);
		return loginPage;
	}
	
	public SignUp getSignUpPage() {
		if(driver != null)
		signUpPage = new SignUp(driver);
		return signUpPage;
	}
	
	public AccountCreated getAccountCreatedPage() {
		accountCreated = new AccountCreated(driver);
		return accountCreated;
	}
	
	public DeleteAccount getDeleteAccountPage() {
		deleteAccount = new DeleteAccount(driver);
		return deleteAccount;
	}
}
