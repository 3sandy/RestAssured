package com.rmgyantraDifferentWaysToPost;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreatProjectUsingHashMap {

	@Test
	public void creatProjectUsingHashMap()
	{
	
	HashMap jobj=new HashMap();
		
		jobj.put("createdBy", "XYZ");
		jobj.put("projectName", "SDET_10_RestAssured_23");
		jobj.put("status", "created");
		jobj.put("teamsize", 8);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and().assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}
}



