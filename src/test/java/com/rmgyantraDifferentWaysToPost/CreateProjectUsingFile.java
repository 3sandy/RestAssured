package com.rmgyantraDifferentWaysToPost;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectUsingFile {

	@Test
	public void createProjectUsingJsonFile() {
		 
		File f=new File("./data.JSON");
		
		
		given()
		.contentType(ContentType.JSON)
		.body(f)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and().assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}
