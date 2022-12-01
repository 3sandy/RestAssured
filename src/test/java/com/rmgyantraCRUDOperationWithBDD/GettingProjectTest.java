package com.rmgyantraCRUDOperationWithBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GettingProjectTest {
@Test
	public void gettingProject()
	{
		
		given()
		.when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
}
