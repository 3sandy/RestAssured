package com.rmgYantra.parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QueryParaameterTest {
 
	@Test
	public void queryParaameterTest()
	{
		given()
		.pathParam("username","3sandy")
		.queryParam("sort","created")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.log().all();
	}
}
