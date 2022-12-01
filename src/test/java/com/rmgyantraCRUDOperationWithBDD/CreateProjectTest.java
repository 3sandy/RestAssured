package com.rmgyantraCRUDOperationWithBDD;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JSONObject jobj=new JSONObject();
		
		jobj.put("createdBy", "XYZ");
		jobj.put("projectName", "SDET_10_RestAssured_2");
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
