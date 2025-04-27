package stepDefinition;

import PageObjects.AccountCreated;
import PageObjects.DeleteAccount;
import PageObjects.Home;
import PageObjects.Login;
import PageObjects.SignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class Register_user {
	
	TestContextSetup testContextSetup;
	Home homepage;
	Login loginPage;
	SignUp signUpPage;
	AccountCreated accountCreatedPage;
	DeleteAccount deleteAccountPage;
	
	//So who creates the TestContextSetup object?
	//That happens through Cucumber's Dependency Injection using PicoContainer or another DI library.
	
	public Register_user(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		homepage = testContextSetup.pageObjectManager.getHomePage();
		loginPage = testContextSetup.pageObjectManager.getLoginPage();
		signUpPage = testContextSetup.pageObjectManager.getSignUpPage();
		accountCreatedPage = testContextSetup.pageObjectManager.getAccountCreatedPage();
		deleteAccountPage = testContextSetup.pageObjectManager.getDeleteAccountPage();
		
	}
	
	
	@Given("user is on home page")
	public void goToHomePage() {
		System.out.println(homepage.getUrlHomePage());
	}
    @When ("User go to log in page")
    public void goToSignUp() {
    	homepage.clickOnSignup();
    }
    @When ("Verify {string} is visible")
    public void verifySignUpPage(String signUpTitle ) {
    	//signUpPage.getSignUpPageUrl().contains(SignUpTitle);
    	boolean isTrue = signUpTitle.equals(loginPage.getSignUpLevel());
    	if(isTrue) {
    		System.out.println(signUpTitle + " is visible.");
    	}
    }
    @When ("^Enter the (.+) , (.+) address$")
    public void fillSignUpDetails(String name , String email){
    	loginPage.fillUserName(name);
    	loginPage.fillEmail(email);
    }
    
    @When("click on Sign up button")
    public void signUpClick(){
    	loginPage.clickSignUp();
    }
    
    
  	@When("Fill all necessary field")
  	public void fillTheInputsOfSignUpPage() {
  		signUpPage.fillAllFields();	
  	}
    
  	@When("Account created successfully") 
  	public void CheckAccountCreation() {
  		signUpPage.createAccount();
  		String message= accountCreatedPage.getSuccessMessage();
  		System.out.println(message);
  		accountCreatedPage.clickOnContinue();
  		
  	}
  	
  	@When("User click on {string} button")
  	public void user_click_on_button(String string) {
  	    // Write code here that turns the phrase above into concrete actions
  	    homepage.clickOnDeleteAccount();
  	}

  	@Then("{string} is visible")
  	public void is_visible(String string) {
  	    // Write code here that turns the phrase above into concrete actions
  	    String message = testContextSetup.pageObjectManager.getDeleteAccountPage().getAccountDeleteMessage();
  	    System.out.println(message);
  	    
  	    if(message.contains("DELETED")) {
  	    	testContextSetup.driver.quit();
  	    }
  	}
  	
  	
  	
	
	
}
