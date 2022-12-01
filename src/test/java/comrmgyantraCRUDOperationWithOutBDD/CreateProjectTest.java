package comrmgyantraCRUDOperationWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	public void createProject() {
		
	
   
	JSONObject jobj=new JSONObject();
	
	jobj.put("createdBy", "XYZ");
	jobj.put("projectName", "SDET_10_RestAssured");
	jobj.put("status", "created");
	jobj.put("teamsize", 8);
	
	RequestSpecification reqSpec=RestAssured.given();
	
	reqSpec.contentType(ContentType.JSON);
	reqSpec.body(jobj);


	Response reps=reqSpec.post("http://localhost:8084/addProject");
	
	reps.then().assertThat().statusCode(201).log().all();

	}
	
}
