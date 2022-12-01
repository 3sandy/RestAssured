package comrmgyantraCRUDOperationWithOutBDD;



import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GettingProjectTest {
@Test
	public void getProject()
	{
	Response rsps=RestAssured.get("http://localhost:8084/projects");
	//System.out.println(rsps.asString());
	//rsps.prettyPrint();
	
	//rsps.getTime();
//	System.out.println(rsps.getTime());
	ValidatableResponse vres=rsps.then();
	vres.assertThat().statusCode(200);
	vres.assertThat().contentType(ContentType.JSON);
	//vres.log().all();
	
	}
}
