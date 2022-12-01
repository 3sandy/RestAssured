package com.rmgYantra_Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class BarerToken {

	
	@Test
	public void barerToken()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log().all();

	}
}
