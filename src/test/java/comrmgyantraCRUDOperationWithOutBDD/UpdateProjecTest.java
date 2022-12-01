package comrmgyantraCRUDOperationWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjecTest {
	
	
	
@Test
	public void updateProject()
	{
JSONObject jobj=new JSONObject();
	
	jobj.put("createdBy", "abc");
	jobj.put("projectName", "SDET_10_RestAssured");
	jobj.put("status", "created");
	jobj.put("teamsize", 7);
	
	RequestSpecification reqSpec=RestAssured.given();
	
	reqSpec.contentType(ContentType.JSON);
	reqSpec.body(jobj);


	Response reps=reqSpec.put("http://localhost:8084/projects/TY_PROJ_1802");
	
	reps.then().assertThat().statusCode(200).log().all();
	
	}
}
