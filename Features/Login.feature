# cucumber test
Feature: Login to yelpcamp 

#T1
@SmokeTest
Scenario: Successful login with valid credentials
	Given I am on the login page "https://zk-yelpcamp.herokuapp.com/login"
	When I enter my username "ztestuser" and password "Cogstate123"
	Then I am successfully logged in

#T2
