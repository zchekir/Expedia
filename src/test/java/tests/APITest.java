package tests;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class APITest {
	
	@Test
	public void settingUp() {
		
		RestAssured.baseURI = "https://zk-yelpcamp.herokuapp.com";
		
		given().log().all().header("Content-Type", "application/json")
		.body("{\"username\": \"ztestuser\", \"password\": \"Cogstate123\"}")
		.when().post("login")
		.then().assertThat().log().all().statusCode(200);
		
	}
	
}
