package com.rmgYantra.parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class PathParameterTest {

	@Test
	public void pathParameter()
	{
		given()
		.pathParam("ProId", "TY_PROJ_803")
		.when()
		.get("http://localhost:8084/projects/{ProId}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		
	}
}
