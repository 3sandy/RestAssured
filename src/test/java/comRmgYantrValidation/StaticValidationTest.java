package comRmgYantrValidation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class StaticValidationTest {

	@Test
	public void vaidationTest()
	{
		
		String expData="deepak_";
		
	Response rsps=	when()
		.get("http://localhost:8084/projects");
		
		String actData=rsps.jsonPath().get("[2].projectName");
		
		Assert.assertEquals(actData, expData);
	}
	
}
