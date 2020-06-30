# cucumber test
Feature: Login to yelpcamp 

#T1
@SmokeTest
Scenario: Successful login with valid credentials
	Given chrome browser launches and goes to url "https://zk-yelpcamp.herokuapp.com/login"
	When user enters username "ztestuser" and password "Cogstate123"
	Then successfully logged in

#T2
