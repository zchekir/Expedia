# cucumber test
Feature: Signup

#T1
@SmokeTest
Scenario: Can create a non-admin account
	Given I am on the homepage "https://zk-yelpcamp.herokuapp.com/campgrounds"
	When I click on the Sign Up link
	And I fill in my personal information 
	And I click on the Sign Up button
	Then A new account is created and I am automatically logged in

#T2	
@RegressionTest
Scenario: Can create an admin account
	Given This is a blank test