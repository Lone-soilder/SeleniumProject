package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainSteps {

	@Given("^User (.+) is on NetBanking landing page$")
	public void user_is_on_NetBanking_landing_page(String username) {
		//some code
		System.out.println(username + "user is landed on the page");
	}
	
//	@When("user login into application with username {string} and password {string}")
//	public void user_login_into_application(String username , String password) {
//		System.out.println(username + " is logging into the application");
//	}
	@When("^user login into application with username (.+) and password (.+)$")
	public void user_login_into_application(String username , String password) {
		System.out.println(username + " is logging into the application");
	}
	@Then("Home Page is displayed")
	public void home_Page_is_displayed() {
		System.out.println("home page is displayed.");
	}
	
	@Then("cards are displayed")
	public void cards_are_displayed() {
		System.out.println("cards are displayed");
	}
}
