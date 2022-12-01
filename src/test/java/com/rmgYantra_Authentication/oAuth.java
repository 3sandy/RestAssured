package com.rmgYantra_Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class oAuth {

	@Test
	public void oAuth()
	{
		Response rsps=given()
				.formParam("client_id", "sdet_10_sandeep")
				.formParam("client_secret", "d6a14b009bba5f5cf66912c37857eba9")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://sdet.com")
				.when()
				.post("http://coop.apps.symfonycasts.com/token");
		String token=rsps.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("USER-ID", "4059")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER-ID}/chickens-feed")
		.then()
		.log().all();

 
	}
	
}
