package com.expedia.tests;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

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
