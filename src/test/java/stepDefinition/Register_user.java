package stepDefinition;

import PageObjects.Home;
import PageObjects.SignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class Register_user {
	
	TestContextSetup testContextSetup;
	Home homepage;
	SignUp signUpPage;
	
	public Register_user(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		homepage = testContextSetup.pageObjectManager.getHomePage();
		signUpPage = testContextSetup.pageObjectManager.getSignUpPage();
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
    	boolean isTrue = signUpTitle.equals(signUpPage.getSignUpLevel());
    	if(isTrue) {
    		System.out.println(signUpTitle + " is visible.");
    	}
    }
    @When ("^Enter the (.+) , (.+) address$")
    public void fillSignUpDetails(String name , String email){
    	signUpPage.fillUserName(name);
    	signUpPage.fillEmail(email);
    }
    
    @When("click on Sign up button")
    public void signUpClick(){
    	signUpPage.clickSignUp();
    }
    
    @Then("user navigate the sign up page")
    public void landedOnSignUpPage() {
    	boolean isTrue = signUpPage.getSignUpPageUrl().contains("signup");
    	
    	if(isTrue) {
    		System.out.println("SignUp page landed..");
    	}
    }
	
	
}
