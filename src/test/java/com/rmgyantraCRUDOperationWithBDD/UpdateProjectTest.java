/**
 * 
 */
package com.rmgyantraCRUDOperationWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

/**
 * @author Pawan
 *
 */
public class UpdateProjectTest {

	@Test
	public void updateproject() 
	{
JSONObject jobj=new JSONObject();
		
		jobj.put("createdBy", "XY");
		jobj.put("projectName", "SDET_10_RestAssured_2");
		jobj.put("status", "created");
		jobj.put("teamsize", 6);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_803")
		.then()
		.assertThat().statusCode(200)
		.and().assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}
