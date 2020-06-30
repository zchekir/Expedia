$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successful login with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "name": "chrome browser launches and goes to url \"https://zk-yelpcamp.herokuapp.com/login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.chrome_browser_launches_and_goes_to_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters username \"ztestuser\" and password \"Cogstate123\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.user_enters_username_and_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "successfully logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.successfully_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:Features/Signup.feature");
formatter.feature({
  "name": "Signup",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Can create a non-admin account",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "name": "User launches chrome browser",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "navigates to home page \"https://zk-yelpcamp.herokuapp.com/campgrounds\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.navigates_to_home_page(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user clicks on Sign Up link",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.user_clicks_on_Sign_Up_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "fills in for all required fields and clicks on Sign Up button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.fills_in_for_all_required_fields_and_clicks_on_Sign_Up_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "new account has been created",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.new_account_has_been_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user has automatically logged in with that new account",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.user_has_automatically_logged_in_with_that_new_account()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user can view confirmation message containing their username",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.user_can_view_confirmation_message_containing_their_username()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.TestSteps.close_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Can create an admin account",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "name": "This is a blank test",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});