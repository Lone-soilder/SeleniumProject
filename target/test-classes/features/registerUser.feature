
@RegisterUser
Feature: Register the User
  I want to use this template for my feature file

	
  Scenario Outline: Sign up as new user
    Given user is on home page
    When User go to log in page
    And Verify "New User Signup!" is visible
    And Enter the <name> , <email> address 
    And click on Sign up button
    And Fill all necessary field
    And Account created successfully  
    And User click on "Delete Account" button
    Then "Account Deleted" is visible
    
    Examples: 
      | name  | email | 
      | Biswa | biswa123@gmail.com | 
      

