package com.rmgyantraCRUDOperationWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PartialUpdateProject {

	@Test
	public void partialupdateProject() 
	{
       JSONObject jobj=new JSONObject();
		
		
		jobj.put("teamsize", 7);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.patch("https://reqres.in/")
		.then()
		.assertThat().statusCode(200)
		.and().assertThat().contentType(ContentType.JSON)
		.log().all();
		
		
	}
}
