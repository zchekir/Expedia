package com.expedia.TestCases;

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

class AuthJSONRequest
{
  /// <summary>-------------------------------------------------------
  /// External users key for accessing the API
  /// </summary>
//  public String key { get; set; }
//  public AuthJSONRequest{
	  
  }


public class APITest {
	
	@Test
	public void settingUp() {
		
		RestAssured.baseURI = "https://zk-yelpcamp.herokuapp.com";
		
		given().log().all().header("Content-Type", "application/json")
		.body("{\"username\": \"ztestuser\", \"password\": \"Cogstate123\"}")
		.when().post("login")
		.then().assertThat().log().all().statusCode(200);
		
	}
	
	public static void authentication() throws ClientProtocolException, Exception {

		 

        // Authentication:
        //WebDriver driver = webDriver();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost1 = new HttpPost("https://cgst-qcpd.azurewebsites.net/api/external/AuthenticationToken?key=cf7d1bfe-7294-4f84-8bc4-428b3272dbcb&secret=5268fa42-8060-4bb6-b159-7da0d8b60d10");
        CloseableHttpResponse response1 = httpclient.execute(httpPost1);

 

        try {

 

            HttpEntity entity = response1.getEntity();
            token = EntityUtils.toString(entity);
            
            // ParessToken

 

            String InputJson = token;
            ObjectMapper mapper = new ObjectMapper();
            ParsToken = mapper.readValue(InputJson, MainPaseser.class);
     
            
            
            System.out.println(ParsToken.getServerAuthToken());
            EntityUtils.consume(entity);
            //System.out.println(InputJson );
        } finally {
            response1.close();
        }

 

    }
	
}
