# cucumber test
Feature: Signup

#T1
@SmokeTest
Scenario: Can create a non-admin account
	Given User launches chrome browser
	And navigates to home page "https://zk-yelpcamp.herokuapp.com/campgrounds"
	When user clicks on Sign Up link
	And fills in for all required fields and clicks on Sign Up button
	Then new account has been created 
	And user has automatically logged in with that new account
	Then user can view confirmation message containing their username
	And close browser

#T2	
@RegressionTest
Scenario: Can create an admin account
	Given This is a blank test