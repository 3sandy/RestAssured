package com.rmgyantraDifferentWaysToPost;

import org.testng.annotations.Test;

import com.rmgYantraPojoClass.POJO;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class createProjectUsingPojoTest {

	@Test
	public void createProjectUsingPojoTest()
	{
		POJO P=new POJO("sandeep","sdet_157","created",7);
		
		given()
		.contentType(ContentType.JSON)
		.body(P)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and().assertThat().contentType(ContentType.JSON)
		.log().all();
	
	}
	
	
}
