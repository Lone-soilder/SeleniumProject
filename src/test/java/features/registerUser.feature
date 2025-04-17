
Feature: Register the User
  I want to use this template for my feature file

  

	@RegisterUser
  Scenario Outline: Sign up as new user
    Given user is on home page
    When User go to log in page
    And Verify "New User Signup!" is visible
    And Enter the <name> , <email> address 
    And click on Sign up button
    Then user navigate the sign up page

    Examples: 
      | name  | email | 
      | Biswa | biswa123@gmail.com | 
      
  #Scenario: Create account
  #	Given Sign up page landed 
  #	When Fill all necessary field
  #	Then Account created successfully  
  #	
  #Scenario: Delete account 
  #	Given User signed up successfully
  #	When User click on "Delete Account" button
  #	Then "Account deleted!" is visible
  
      
