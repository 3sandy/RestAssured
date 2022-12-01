package com.rmgYantra.parameters;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class RequestChaining {

	@Test
	public void requestChaining()
	{
		Response rsps=when()
		
				.get("http://localhost:8084/projects");
				rsps.prettyPrint();
		String projectid=rsps.jsonPath().get("[1].projectId");
		
		given()
		.pathParam("proId", projectid)
		.when()
		.delete("http://localhost:8084/projects/{proId}")
		.then()
		.log().all();
				
				

		
	}
}
