
Feature: Application login

Scenario: Admin page default login
Given User "adminUser" is on NetBanking landing page
When user login into application with username "adminUser" and password 1234
Then Home Page is displayed 
And cards are displayed


Scenario Outline: User page default login

Given User <username> is on NetBanking landing page
When user login into application with username <username> and password <password>
Then Home Page is displayed 
And cards are displayed

Examples:
	| username   |  password  |
	|	admin			 |	hi1234		|
	| debitUser  |  hello123	|
	 

